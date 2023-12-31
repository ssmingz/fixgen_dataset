class PlaceHold {
  protected void extract() {
    if (source.lastModified() > dest.lastModified()) {
      log((("Expanding " + source.getAbsolutePath()) + " to ") + dest.getAbsolutePath());
      FileOutputStream out = null;
      GZIPInputStream zIn = null;
      FileInputStream fis = null;
      try {
        out = new FileOutputStream(dest);
        fis = new FileInputStream(source);
        zIn = new GZIPInputStream(fis);
        byte[] buffer = new byte[8 * 1024];
        int count = 0;
        do {
          out.write(buffer, 0, count);
          count = zIn.read(buffer, 0, buffer.length);
        } while (count != (-1));
      } catch (IOException ioe) {
        String msg = "Problem expanding gzip " + ioe.getMessage();
        throw new BuildException(msg, ioe, getLocation());
      } finally {
        if (fis != null) {
          try {
            fis.close();
          } catch (IOException ioex) {
          }
        }
        if (out != null) {
          try {
            out.close();
          } catch (IOException ioex) {
          }
        }
        if (zIn != null) {
          try {
            zIn.close();
          } catch (IOException ioex) {
          }
        }
      }
    }
  }
}
