class PlaceHold {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    final Table table = new Table(shell, (SWT.BORDER | SWT.V_SCROLL) | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    final int rowCount = 64;
    final int columnCount = 4;
    for (int i = 0; i < columnCount; i++) {
      TableColumn column = new TableColumn(table, SWT.NONE);
      column.setText("Column " + i);
    }
    for (int i = 0; i < rowCount; i++) {
      TableItem item = new TableItem(table, SWT.NONE);
      for (int j = 0; j < columnCount; j++) {
        item.setText(j, (("Item " + i) + "-") + j);
      }
    }
    for (int i = 0; i < columnCount; i++) {
      table.getColumn(i).pack();
    }
    Point size = table.computeSize(DEFAULT, 200);
    table.setSize(size);
    shell.pack();
    table.addListener(
        MouseDown,
        new Listener() {
          public void handleEvent(Event event) {
            Point pt = new Point(event.x, event.y);
            TableItem item = table.getItem(pt);
            if (item == null) {
              return;
            }
            for (int i = 0; i < columnCount; i++) {
              Rectangle rect = item.getBounds(i);
              if (rect.contains(pt)) {
                int index = table.indexOf(item);
                System.out.println((("Item " + index) + "-") + i);
              }
            }
          }
        });
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
