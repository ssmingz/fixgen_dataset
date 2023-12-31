class PlaceHold {
  public void applyAll(IProgressMonitor pm, Shell shell, String title) throws CoreException {

    final int WORK_UNIT = 10;

    int i;

    IFile singleFile = null; // file to be patched
    IContainer container = null;
    if (fTarget instanceof IContainer) container = (IContainer) fTarget;
    else if (fTarget instanceof IFile) {
      singleFile = (IFile) fTarget;
      container = singleFile.getParent();
    } else {
      Assert.isTrue(false);
    }

    // get all files to be modified in order to call validateEdit
    List list = new ArrayList();
    if (singleFile != null) list.add(singleFile);
    else {
      for (i = 0; i < fDiffs.length; i++) {
        FileDiff diff = fDiffs[i];
        if (isEnabled(diff)) {
          switch (diff.getDiffType(isReversed())) {
            case Differencer.CHANGE:
              list.add(createPath(container, getPath(diff)));
              break;
          }
        }
      }
    }
    if (!Utilities.validateResources(list, shell, title)) return;

    if (pm != null) {
      String message = PatchMessages.Patcher_Task_message;
      pm.beginTask(message, fDiffs.length * WORK_UNIT);
    }

    for (i = 0; i < fDiffs.length; i++) {

      int workTicks = WORK_UNIT;

      FileDiff diff = fDiffs[i];
      if (isEnabled(diff)) {

        IPath path = getPath(diff);
        if (pm != null) pm.subTask(path.toString());

        IFile file = singleFile != null ? singleFile : createPath(container, path);

        List failed = new ArrayList();
        List result = null;

        int type = diff.getDiffType(isReversed());
        switch (type) {
          case Differencer.ADDITION:
            // patch it and collect rejected hunks
            result = apply(diff, file, true, failed);
            store(createString(result), file, new SubProgressMonitor(pm, workTicks));
            workTicks -= WORK_UNIT;
            break;
          case Differencer.DELETION:
            file.delete(true, true, new SubProgressMonitor(pm, workTicks));
            workTicks -= WORK_UNIT;
            break;
          case Differencer.CHANGE:
            // patch it and collect rejected hunks
            result = apply(diff, file, false, failed);
            store(createString(result), file, new SubProgressMonitor(pm, workTicks));
            workTicks -= WORK_UNIT;
            break;
        }

        if (fGenerateRejectFile && failed.size() > 0) {
          IPath pp = null;
          if (path.segmentCount() > 1) {
            pp = path.removeLastSegments(1);
            pp = pp.append(path.lastSegment() + REJECT_FILE_EXTENSION);
          } else pp = new Path(path.lastSegment() + REJECT_FILE_EXTENSION);
          file = createPath(container, pp);
          if (file != null) {
            store(getRejected(failed), file, pm);
            try {
              IMarker marker = file.createMarker(MARKER_TYPE);
              marker.setAttribute(IMarker.MESSAGE, PatchMessages.Patcher_Marker_message);
              marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
            } catch (CoreException ex) {
              // NeedWork
            }
          }
        }
      }

      if (pm != null) {
        if (pm.isCanceled()) break;
        if (workTicks > 0) pm.worked(workTicks);
      }
    }
  }
}
