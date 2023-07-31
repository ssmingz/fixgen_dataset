class PlaceHold {
  public int internal_new_GC(GCData data) {
    checkWidget();
    int window = paintWindow();
    if (window == 0) {
      SWT.error(ERROR_NO_HANDLES);
    }
    int gdkGC = OS.gdk_gc_new(window);
    if (gdkGC == 0) {
      error(ERROR_NO_HANDLES);
    }
    if (data != null) {
      int fontHandle = fontHandle();
      GtkStyle style = new GtkStyle();
      OS.memmove(style, OS.gtk_widget_get_style(fontHandle));
      GdkColor foreground = new GdkColor();
      foreground.pixel = style.fg0_pixel;
      foreground.red = style.fg0_red;
      foreground.green = style.fg0_green;
      foreground.blue = style.fg0_blue;
      GdkColor background = new GdkColor();
      background.pixel = style.bg0_pixel;
      background.red = style.bg0_red;
      background.green = style.bg0_green;
      background.blue = style.bg0_blue;
      data.drawable = window;
      data.device = display;
      data.background = background;
      data.foreground = foreground;
      data.font = (font != null) ? font.handle : defaultFont();
    }
    return gdkGC;
  }
}