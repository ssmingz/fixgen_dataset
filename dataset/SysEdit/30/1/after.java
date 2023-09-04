class PlaceHold {
  protected void handleDispose(DisposeEvent event) {

    Utilities.deregisterActions(fHandlerService, fActivations);
    fHandlerService = null;

    Object input = getInput();
    if (input instanceof ICompareInput)
      ((ICompareInput) input).removeCompareInputChangeListener(fCompareInputChangeListener);

    if (fCompareConfiguration != null && fPropertyChangeListener != null) {
      fCompareConfiguration.removePropertyChangeListener(fPropertyChangeListener);
      fPropertyChangeListener = null;
    }

    fAncestorLabel = null;
    fLeftLabel = null;
    fDirectionLabel = null;
    fRightLabel = null;
    fCenter = null;

    if (fRightArrow != null) {
      fRightArrow.dispose();
      fRightArrow = null;
    }
    if (fLeftArrow != null) {
      fLeftArrow.dispose();
      fLeftArrow = null;
    }
    if (fBothArrow != null) {
      fBothArrow.dispose();
      fBothArrow = null;
    }

    if (fNormalCursor != null) {
      fNormalCursor.dispose();
      fNormalCursor = null;
    }
    if (fHSashCursor != null) {
      fHSashCursor.dispose();
      fHSashCursor = null;
    }
    if (fVSashCursor != null) {
      fVSashCursor.dispose();
      fVSashCursor = null;
    }
    if (fHVSashCursor != null) {
      fHVSashCursor.dispose();
      fHVSashCursor = null;
    }

    super.handleDispose(event);
  }
}
