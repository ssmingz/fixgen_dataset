class PlaceHold {
  private void initTestPropFile() throws IOException {
    Properties testProps = new Properties();
    testProps.put(FNAME_KEY, FNAME);
    testProps.put(LNAME_KEY, LNAME);
    testProps.put(EMAIL_KEY, EMAIL);
    testProps.put("existing.prop", "37");
    FileOutputStream fos =
        new FileOutputStream(new File(buildRule.getOutputDir(), testPropsFilePath));
    testProps.store(fos, "defaults");
    fos.close();
  }
}