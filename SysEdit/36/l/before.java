class PlaceHold {
  private void initLabels() {
    CompareConfiguration cc = getCompareConfiguration();
    cc.setLeftEditable(false);
    cc.setRightEditable(false);
    String leftLabel = PatchMessages.PatcherCompareEditorInput_LocalCopy;
    cc.setLeftLabel(leftLabel);
    String rightLabel = PatchMessages.PatcherCompareEditorInput_AfterPatch;
    cc.setRightLabel(rightLabel);
  }
}
