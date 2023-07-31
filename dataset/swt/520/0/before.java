class PlaceHold {
  public void fillOval(int x, int y, int width, int height) {
    if (handle == 0) {
      SWT.error(ERROR_GRAPHIC_DISPOSED);
    }
    if (width < 0) {
      x = x + width;
      width = -width;
    }
    if (height < 0) {
      y = y + height;
      height = -height;
    }
    focus(true);
    if ((data.background & 0xff000000) == 0) {
      OS.RGBForeColor(data.background);
      fRect.set(x, y, width, height);
      OS.PaintOval(fRect.getData());
    } else {
    }
    unfocus(true);
  }
}