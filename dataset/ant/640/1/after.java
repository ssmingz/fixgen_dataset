class PlaceHold {
  private void writeBlock() throws IOException {
    if (debug) {
      System.err.println("WriteBlock: blkIdx = " + currBlkIdx);
    }
    if (outStream == null) {
      throw new IOException("writing to an input buffer");
    }
    outStream.write(blockBuffer, 0, blockSize);
    outStream.flush();
    currRecIdx = 0;
    currBlkIdx++;
    Arrays.fill(blockBuffer, ((byte) (0)));
  }
}
