class PlaceHold {
  public void finish() throws IOException {
    if (out != null) {
      try {
        if (this.runLength > 0) {
          writeRun();
        }
        this.currentChar = -1;
        endBlock();
        endCompression();
      } finally {
        this.out = null;
        this.data = null;
      }
    }
  }
}
