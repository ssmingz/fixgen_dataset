class PlaceHold {
  public static ParseTree treeLinkInlineTags() {
    JavadocContext qUDSi = new JavadocContext(null, 0);
    JavadocInlineTagContext qrmKv = new JavadocInlineTagContext(qUDSi, 0);
    CommonToken nyjfF = new CommonToken(JavadocTokenTypes.JAVADOC_INLINE_TAG_START, "{");
    qrmKv.addChild(nyjfF);
    CommonToken HXSDY = new CommonToken(JavadocTokenTypes.LINK_LITERAL, "@link");
    qrmKv.addChild(HXSDY);
    CommonToken LbsbA = new CommonToken(JavadocTokenTypes.WS, " ");
    qrmKv.addChild(LbsbA);
    ReferenceContext qNvtx = new ReferenceContext(qrmKv, 0);
    CommonToken cPKhb = new CommonToken(JavadocTokenTypes.PACKAGE, "java.lang");
    qNvtx.addChild(cPKhb);
    CommonToken FXimU = new CommonToken(JavadocTokenTypes.DOT, ".");
    qNvtx.addChild(FXimU);
    CommonToken VmBeR = new CommonToken(JavadocTokenTypes.CLASS, "Integer");
    qNvtx.addChild(VmBeR);
    CommonToken ZQmZl = new CommonToken(JavadocTokenTypes.HASH, "#");
    qNvtx.addChild(ZQmZl);
    CommonToken LqBEr = new CommonToken(JavadocTokenTypes.MEMBER, "valueOf");
    qNvtx.addChild(LqBEr);
    qrmKv.addChild(qNvtx);
    CommonToken AMFgL = new CommonToken(JavadocTokenTypes.JAVADOC_INLINE_TAG_END, "}");
    qrmKv.addChild(AMFgL);
    qUDSi.addChild(qrmKv);
    CommonToken Soygb = new CommonToken(JavadocTokenTypes.NEWLINE, LINE_SEPARATOR);
    qUDSi.addChild(Soygb);
    JavadocInlineTagContext TkOkF = new JavadocInlineTagContext(qUDSi, 0);
    CommonToken PkzAI = new CommonToken(JavadocTokenTypes.JAVADOC_INLINE_TAG_START, "{");
    TkOkF.addChild(PkzAI);
    CommonToken kFrQb = new CommonToken(JavadocTokenTypes.LINK_LITERAL, "@link");
    TkOkF.addChild(kFrQb);
    CommonToken fVQnP = new CommonToken(JavadocTokenTypes.WS, " ");
    TkOkF.addChild(fVQnP);
    ReferenceContext Mwbat = new ReferenceContext(TkOkF, 0);
    CommonToken oHQua = new CommonToken(JavadocTokenTypes.PACKAGE, "java.lang");
    Mwbat.addChild(oHQua);
    CommonToken YvNhB = new CommonToken(JavadocTokenTypes.DOT, ".");
    Mwbat.addChild(YvNhB);
    CommonToken dsmbF = new CommonToken(JavadocTokenTypes.CLASS, "Integer");
    Mwbat.addChild(dsmbF);
    CommonToken HZVQi = new CommonToken(JavadocTokenTypes.HASH, "#");
    Mwbat.addChild(HZVQi);
    CommonToken FUOOd = new CommonToken(JavadocTokenTypes.MEMBER, "valueOf");
    Mwbat.addChild(FUOOd);
    TkOkF.addChild(Mwbat);
    DescriptionContext WchCg = new DescriptionContext(TkOkF, 0);
    TextContext fcThJ = new TextContext(WchCg, 0);
    CommonToken aDhfF = new CommonToken(JavadocTokenTypes.WS, " ");
    fcThJ.addChild(aDhfF);
    CommonToken vdvFW = new CommonToken(JavadocTokenTypes.CHAR, "v");
    fcThJ.addChild(vdvFW);
    CommonToken IHqck = new CommonToken(JavadocTokenTypes.CHAR, "a");
    fcThJ.addChild(IHqck);
    CommonToken xHjyx = new CommonToken(JavadocTokenTypes.CHAR, "l");
    fcThJ.addChild(xHjyx);
    CommonToken oKzoC = new CommonToken(JavadocTokenTypes.CHAR, "u");
    fcThJ.addChild(oKzoC);
    CommonToken wnkTX = new CommonToken(JavadocTokenTypes.CHAR, "e");
    fcThJ.addChild(wnkTX);
    CommonToken WAjRZ = new CommonToken(JavadocTokenTypes.CHAR, "O");
    fcThJ.addChild(WAjRZ);
    CommonToken mFsnr = new CommonToken(JavadocTokenTypes.CHAR, "f");
    fcThJ.addChild(mFsnr);
    WchCg.addChild(fcThJ);
    TkOkF.addChild(WchCg);
    CommonToken vtWLP = new CommonToken(JavadocTokenTypes.JAVADOC_INLINE_TAG_END, "}");
    TkOkF.addChild(vtWLP);
    qUDSi.addChild(TkOkF);
    CommonToken NyyJM = new CommonToken(JavadocTokenTypes.EOF, "<EOF>");
    qUDSi.addChild(NyyJM);
    return qUDSi;
  }
}
