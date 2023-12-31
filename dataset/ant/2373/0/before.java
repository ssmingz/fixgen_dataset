class PlaceHold {
  public int read() throws IOException {
    if (!getInitialized()) {
      initialize();
      setInitialized(true);
    }
    int ch = -1;
    if (line != null) {
      ch = line.charAt(0);
      if (line.length() == 1) {
        line = null;
      } else {
        line = line.substring(1);
      }
    } else {
      final int regexpsSize = regexps.size();
      for (line = readLine(); line != null; line = readLine()) {
        boolean matches = true;
        for (int i = 0; matches && (i < regexpsSize); i++) {
          RegularExpression regexp = ((RegularExpression) (regexps.elementAt(i)));
          Regexp re = regexp.getRegexp(getProject());
          matches = re.matches(line);
        }
        if (matches ^ isNegated()) {
          break;
        }
      }
      if (line != null) {
        return read();
      }
    }
    return ch;
  }
}
