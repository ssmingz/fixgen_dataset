class PlaceHold {
  public static void main(String[] args) {
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    OleControlSite controlSite;
    try {
      OleFrame frame = new OleFrame(shell, SWT.NONE);
      controlSite = new OleControlSite(frame, SWT.NONE, "Shell.Explorer");
      controlSite.doVerb(OLEIVERB_INPLACEACTIVATE);
    } catch (SWTError e) {
      System.out.println("Unable to open activeX control");
      display.dispose();
      return;
    }
    final OleAutomation webBrowser = new OleAutomation(controlSite);
    int DownloadComplete = 104;
    controlSite.addEventListener(
        DownloadComplete,
        new OleListener() {
          public void handleEvent(OleEvent event) {
            int[] htmlDocumentID = webBrowser.getIDsOfNames(new String[] {"Document"});
            if (htmlDocumentID == null) {
              return;
            }
            Variant pVarResult = webBrowser.getProperty(htmlDocumentID[0]);
            if ((pVarResult == null) || (pVarResult.getType() == 0)) {
              return;
            }
            OleAutomation htmlDocument = null;
            try {
              htmlDocument = pVarResult.getAutomation();
              pVarResult.dispose();
              int[] scriptID = htmlDocument.getIDsOfNames(new String[] {"Script"});
              if (scriptID == null) {
                return;
              }
              pVarResult = htmlDocument.getProperty(scriptID[0]);
              if ((pVarResult == null) || (pVarResult.getType() == 0)) {
                return;
              }
              OleAutomation htmlWindow = null;
              try {
                htmlWindow = pVarResult.getAutomation();
                pVarResult.dispose();
                int[] evaluateID = htmlWindow.getIDsOfNames(new String[] {"evaluate"});
                if (evaluateID == null) {
                  return;
                }
                String expression = "5+Math.sin(9)";
                Variant[] rgvarg = new Variant[] {new Variant(expression)};
                pVarResult = htmlWindow.invoke(evaluateID[0], rgvarg, null);
                if ((pVarResult == null) || (pVarResult.getType() == 0)) {
                  return;
                }
                System.out.println((expression + " =") + pVarResult.getString());
              } finally {
                htmlWindow.dispose();
              }
            } finally {
              htmlDocument.dispose();
            }
          }
        });
    int[] ids = webBrowser.getIDsOfNames(new String[] {"Navigate", "URL"});
    Variant[] rgvarg =
        new Variant[] {
          new Variant(
              "http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet187.html")
        };
    int[] rgdispidNamedArgs = new int[] {ids[1]};
    webBrowser.invoke(ids[0], rgvarg, rgdispidNamedArgs);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    webBrowser.dispose();
    display.dispose();
  }
}
