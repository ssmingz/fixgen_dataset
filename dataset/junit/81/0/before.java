class PlaceHold {
  protected Collection<Field> getDataPointsFields(ParameterSignature sig) {
    List<FrameworkField> fields = fClass.getAnnotatedFields(DataPoints.class);
    Collection<Field> validFields = new ArrayList<Field>();
    for (FrameworkField frameworkField : fields) {
      validFields.add(frameworkField.getField());
    }
    return validFields;
  }
}
