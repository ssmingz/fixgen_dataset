class GC {
  public GC(Drawable drawable) {
    if (drawable == null) {
      SWT.error(ERROR_NULL_ARGUMENT);
    }
    GCData data = new GCData();
    int xGC = drawable.internal_new_GC(data);
    Device device = data.device;
    if (device == null) {
      device = Device.getDevice();
    }
    if (device == null) {
      SWT.error(ERROR_NULL_ARGUMENT);
    }
    data.device = device;
    init(drawable, data, xGC);
    if (device.tracking) {
      device.new_Object(this);
    }
  }
}