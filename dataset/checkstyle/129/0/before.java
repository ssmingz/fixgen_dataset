class PlaceHold {
  @Test
  public void test_1168408_1() throws Exception {
    final String[] expected = new String[] {};
    verify(mCheckConfig, getSrcPath("checks/javadoc/Input_01.java"), expected);
  }
}
