class PlaceHold {
  void initializeCallbacks() {
    keyCallback = new Callback(this, "keyProc", 3);
    keyProc = keyCallback.getAddress();
    if (keyProc == 0) {
      SWT.error(ERROR_NO_MORE_CALLBACKS);
    }
    windowCallback2 = new Callback(this, "windowProc", 2);
    windowProc2 = windowCallback2.getAddress();
    if (windowProc2 == 0) {
      SWT.error(ERROR_NO_MORE_CALLBACKS);
    }
    windowCallback3 = new Callback(this, "windowProc", 3);
    windowProc3 = windowCallback3.getAddress();
    if (windowProc3 == 0) {
      SWT.error(ERROR_NO_MORE_CALLBACKS);
    }
    windowCallback4 = new Callback(this, "windowProc", 4);
    windowProc4 = windowCallback4.getAddress();
    if (windowProc4 == 0) {
      SWT.error(ERROR_NO_MORE_CALLBACKS);
    }
    windowCallback5 = new Callback(this, "windowProc", 5);
    windowProc5 = windowCallback5.getAddress();
    if (windowProc5 == 0) {
      SWT.error(ERROR_NO_MORE_CALLBACKS);
    }
    timerCallback = new Callback(this, "timerProc", 2);
    timerProc = timerCallback.getAddress();
    if (timerProc == 0) {
      error(ERROR_NO_MORE_CALLBACKS);
    }
    windowTimerCallback = new Callback(this, "windowTimerProc", 2);
    windowTimerProc = windowTimerCallback.getAddress();
    if (windowTimerProc == 0) {
      error(ERROR_NO_MORE_CALLBACKS);
    }
    mouseHoverCallback = new Callback(this, "mouseHoverProc", 2);
    mouseHoverProc = mouseHoverCallback.getAddress();
    if (mouseHoverProc == 0) {
      error(ERROR_NO_MORE_CALLBACKS);
    }
    caretCallback = new Callback(this, "caretProc", 2);
    caretProc = caretCallback.getAddress();
    if (caretProc == 0) {
      error(ERROR_NO_MORE_CALLBACKS);
    }
  }
}