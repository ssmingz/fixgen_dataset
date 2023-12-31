class PlaceHold {
  @Override
  public int[] getAcceptableTokens() {
    final Set<String> tokenNames = getTokenNames();
    final int[] result = new int[tokenNames.size()];
    int i = 0;
    for (String name : tokenNames) {
      result[i++] = TokenTypes.getTokenId(name);
    }
    return result;
  }
}
