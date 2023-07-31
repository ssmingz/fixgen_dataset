class PlaceHold {
  public static Test suite() {
    TestSuite suite = new TestSuite("Test for com.puppycrawl.tools.checkstyle");
    suite.addTest(new TestSuite(DetailASTTest.class));
    suite.addTest(new TestSuite(CheckerTest.class));
    suite.addTest(new TestSuite(AvoidStarImportTest.class));
    suite.addTest(new TestSuite(ConfigurationLoaderTest.class));
    suite.addTest(new TestSuite(ConstantNameCheckTest.class));
    suite.addTest(new TestSuite(EmptyBlockCheckTest.class));
    suite.addTest(new TestSuite(EqualsHashCodeCheckTest.class));
    suite.addTest(new TestSuite(FileLengthCheckTest.class));
    suite.addTest(new TestSuite(FileSetCheckLifecycleTest.class));
    suite.addTest(new TestSuite(GenericIllegalRegexpCheckTest.class));
    suite.addTest(new TestSuite(HeaderCheckTest.class));
    suite.addTest(new TestSuite(HiddenFieldCheckTest.class));
    suite.addTest(new TestSuite(IllegalImportCheckTest.class));
    suite.addTest(new TestSuite(IllegalInstantiationCheckTest.class));
    suite.addTest(new TestSuite(InnerAssignmentCheckTest.class));
    suite.addTest(new TestSuite(JavadocMethodCheckTest.class));
    suite.addTest(new TestSuite(JavadocTypeCheckTest.class));
    suite.addTest(new TestSuite(JavadocVariableCheckTest.class));
    suite.addTest(new TestSuite(LineLengthCheckTest.class));
    suite.addTest(new TestSuite(LocalFinalVariableNameCheckTest.class));
    suite.addTest(new TestSuite(LocalVariableNameCheckTest.class));
    suite.addTest(new TestSuite(MemberNameCheckTest.class));
    suite.addTest(new TestSuite(MethodLeftCurlyCheckTest.class));
    suite.addTest(new TestSuite(MethodLengthCheckTest.class));
    suite.addTest(new TestSuite(MethodNameCheckTest.class));
    suite.addTest(new TestSuite(ModifierCheckTest.class));
    suite.addTest(new TestSuite(NeedBracesCheckTest.class));
    suite.addTest(new TestSuite(NoWhitespaceAfterCheckTest.class));
    suite.addTest(new TestSuite(NoWhitespaceBeforeCheckTest.class));
    suite.addTest(new TestSuite(OperatorWrapCheckTest.class));
    suite.addTest(new TestSuite(OptionTest.class));
    suite.addTest(new TestSuite(OtherLeftCurlyCheckTest.class));
    suite.addTest(new TestSuite(PackageHtmlCheckTest.class));
    suite.addTest(new TestSuite(PackageNameCheckTest.class));
    suite.addTest(new TestSuite(PackageNamesLoaderTest.class));
    suite.addTest(new TestSuite(PackageObjectFactoryTest.class));
    suite.addTest(new TestSuite(ParameterNameCheckTest.class));
    suite.addTest(new TestSuite(ParameterNumberCheckTest.class));
    suite.addTest(new TestSuite(ParenPadCheckTest.class));
    suite.addTest(new TestSuite(PublicMemberNameCheckTest.class));
    suite.addTest(new TestSuite(RedundantImportCheckTest.class));
    suite.addTest(new TestSuite(RedundantModifierTest.class));
    suite.addTest(new TestSuite(RightCurlyCheckTest.class));
    suite.addTest(new TestSuite(SimplifyBooleanExpressionCheckTest.class));
    suite.addTest(new TestSuite(SimplifyBooleanReturnCheckTest.class));
    suite.addTest(new TestSuite(StaticVariableNameCheckTest.class));
    suite.addTest(new TestSuite(StringArrayReaderTest.class));
    suite.addTest(new TestSuite(TabCharacterCheckTest.class));
    suite.addTest(new TestSuite(TodoCommentCheckTest.class));
    suite.addTest(new TestSuite(TranslationCheckTest.class));
    suite.addTest(new TestSuite(TypeLeftCurlyCheckTest.class));
    suite.addTest(new TestSuite(TypeNameCheckTest.class));
    suite.addTest(new TestSuite(UnusedImportsCheckTest.class));
    suite.addTest(new TestSuite(UpperEllCheckTest.class));
    suite.addTest(new TestSuite(UtilsTest.class));
    suite.addTest(new TestSuite(VisibilityModifierCheckTest.class));
    suite.addTest(new TestSuite(WhitespaceAfterCheckTest.class));
    suite.addTest(new TestSuite(WhitespaceAroundTest.class));
    suite.addTest(new TestSuite(XMLLoggerTest.class));
    return suite;
  }
}