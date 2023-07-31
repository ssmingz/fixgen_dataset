class PlaceHold {
  public TransferData[] getAvailableTypes(int clipboards) {
    checkWidget();
    if ((clipboards & DND.CLIPBOARD) == 0) {
      return new TransferData[0];
    }
    NSPasteboard pasteboard = NSPasteboard.generalPasteboard();
    NSArray types = pasteboard.types();
    int count = types.count();
    TransferData[] result = new TransferData[count];
    for (int i = 0; i < count; i++) {
      result[i] = new TransferData();
      result[i].type = Transfer.registerType(new NSString(types.objectAtIndex(i)).getString());
    }
    return result;
  }
}