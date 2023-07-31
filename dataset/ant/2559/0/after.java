class PlaceHold {
  public void execute() throws TaskException {
    checkConfiguration();
    final ArrayList files = getFileList();
    if (isUpToDate(files)) {
      return;
    }
    getContext().info("Building cab: " + m_cabFile.getAbsolutePath());
    if (!Os.isFamily(OS_FAMILY_WINDOWS)) {
      getContext().debug("Using listcab/libcabinet");
      final StringBuffer sb = new StringBuffer();
      final Iterator e = files.iterator();
      while (e.hasNext()) {
        sb.append(e.next()).append("\n");
      }
      sb.append("\n").append(m_cabFile.getAbsolutePath()).append("\n");
      try {
        Process p = Runtime.getRuntime().exec("listcab");
        OutputStream out = p.getOutputStream();
        out.write(sb.toString().getBytes());
        out.flush();
        out.close();
      } catch (IOException ex) {
        String msg = (("Problem creating " + m_cabFile) + " ") + ex.getMessage();
        throw new TaskException(msg);
      }
    } else {
      try {
        File listFile = createListFile(files);
        Execute exe = new Execute();
        exe.setWorkingDirectory(m_baseDir);
        final Commandline cmd = createCommand(listFile);
        exe.setCommandline(cmd);
        exe.execute(getContext());
        listFile.delete();
      } catch (final IOException ioe) {
        final String message = (("Problem creating " + m_cabFile) + " ") + ioe.getMessage();
        throw new TaskException(message);
      }
    }
  }
}