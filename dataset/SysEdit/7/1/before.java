class PlaceHold {
  public void openCompareDialog(final CompareEditorInput input) {
    if (input.canRunAsJob()) {
      Job job =
          new Job("Opening Compare Dialog") {
            protected IStatus run(IProgressMonitor monitor) {
              IStatus status = prepareInput(input, monitor);
              if (status.isOK()) {
                internalOpenDialog(input);
                return Status.OK_STATUS;
              }
              if (status.getCode() == NO_DIFFERENCE) {
                MessageDialog.openInformation(
                    getShell(),
                    Utilities.getString("CompareUIPlugin.dialogTitle"),
                    Utilities.getString(
                        "CompareUIPlugin.noDifferences")); //$NON-NLS-1$//$NON-NLS-2$
                return Status.OK_STATUS;
              }
              return status;
            }

            public boolean belongsTo(Object family) {
              return input.belongsTo(family);
            }
          };
      job.setUser(true);
      job.schedule();
    } else {
      if (compareResultOK(input, null)) {
        internalOpenDialog(input);
      }
    }
  }
}
