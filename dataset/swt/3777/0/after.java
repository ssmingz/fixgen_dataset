class PlaceHold {
  void releaseWidget() {
    if (menus != null) {
      for (int i = 0; i < menus.length; i++) {
        Menu menu = menus[i];
        if ((menu != null) && (!menu.isDisposed())) {
          menu.releaseResources();
        }
      }
    }
    menuBar = null;
    menus = null;
    super.releaseWidget();
    defaultButton = saveDefault = null;
    label = null;
  }
}