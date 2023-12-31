class PlaceHold {
  public boolean execute() throws BuildException {
    attributes.log("Using jvc compiler", MSG_VERBOSE);
    Path classpath = new Path(project);
    if (bootclasspath != null) {
      classpath.append(bootclasspath);
    }
    addExtdirsToClasspath(classpath);
    if ((bootclasspath == null) || (bootclasspath.size() == 0)) {
      includeJavaRuntime = true;
    } else {
    }
    classpath.append(getCompileClasspath());
    classpath.append(src);
    Commandline cmd = new Commandline();
    cmd.setExecutable("jvc");
    if (destDir != null) {
      cmd.createArgument().setValue("/d");
      cmd.createArgument().setFile(destDir);
    }
    cmd.createArgument().setValue("/cp:p");
    cmd.createArgument().setPath(classpath);
    cmd.createArgument().setValue("/x-");
    cmd.createArgument().setValue("/nomessage");
    cmd.createArgument().setValue("/nologo");
    if (debug) {
      cmd.createArgument().setValue("/g");
    }
    if (optimize) {
      cmd.createArgument().setValue("/O");
    }
    if (verbose) {
      cmd.createArgument().setValue("/verbose");
    }
    int firstFileName = cmd.size();
    logAndAddFilesToCompile(cmd);
    return executeExternalCompile(cmd.getCommandline(), firstFileName) == 0;
  }
}
