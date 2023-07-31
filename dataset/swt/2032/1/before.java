class PlaceHold {
  public void setText(String string) {
    checkWidget();
    if (string == null) {
      error(ERROR_NULL_ARGUMENT);
    }
    super.setText(string);
    int length = string.length();
    char[] text = new char[length + 1];
    string.getChars(0, length, text, 0);
    for (int i = 0; i < length; i++) {
      if (text[i] == '&') {
        text[i] = '_';
      }
    }
    byte[] buffer = Converter.wcsToMbcs(null, text);
    OS.gtk_label_set_text_with_mnemonic(handle, buffer);
    parent.fixPage();
  }
}