class PlaceHold {
  public void generateOptimizedGreaterThan(
      BlockScope currentScope,
      CodeStream codeStream,
      BranchLabel trueLabel,
      BranchLabel falseLabel,
      boolean valueRequired) {
    int promotedTypeID = (this.left.implicitConversion & TypeIds.IMPLICIT_CONVERSION_MASK) >> 4;
    // both sides got promoted in the same way
    if (promotedTypeID == TypeIds.T_int) {
      // 0 > x
      if ((this.left.constant != Constant.NotAConstant) && (this.left.constant.intValue() == 0)) {
        this.right.generateCode(currentScope, codeStream, valueRequired);
        if (valueRequired) {
          if (falseLabel == null) {
            if (trueLabel != null) {
              // implicitly falling through the FALSE case
              codeStream.iflt(trueLabel);
            }
          } else {
            if (trueLabel == null) {
              // implicitly falling through the TRUE case
              codeStream.ifge(falseLabel);
            } else {
              // no implicit fall through TRUE/FALSE --> should never occur
            }
          }
        }
        // reposition the endPC
        codeStream.recordPositionsFrom(codeStream.position, this.sourceEnd);
        return;
      }
      // x > 0
      if ((this.right.constant != Constant.NotAConstant) && (this.right.constant.intValue() == 0)) {
        this.left.generateCode(currentScope, codeStream, valueRequired);
        if (valueRequired) {
          if (falseLabel == null) {
            if (trueLabel != null) {
              // implicitly falling through the FALSE case
              codeStream.ifgt(trueLabel);
            }
          } else {
            if (trueLabel == null) {
              // implicitly falling through the TRUE case
              codeStream.ifle(falseLabel);
            } else {
              // no implicit fall through TRUE/FALSE --> should never occur
            }
          }
        }
        // reposition the endPC
        codeStream.recordPositionsFrom(codeStream.position, this.sourceEnd);
        return;
      }
    }
    // default comparison
    this.left.generateCode(currentScope, codeStream, valueRequired);
    this.right.generateCode(currentScope, codeStream, valueRequired);
    if (valueRequired) {
      if (falseLabel == null) {
        if (trueLabel != null) {
          // implicit falling through the FALSE case
          switch (promotedTypeID) {
            case T_int:
              codeStream.if_icmpgt(trueLabel);
              break;
            case T_float:
              codeStream.fcmpl();
              codeStream.ifgt(trueLabel);
              break;
            case T_long:
              codeStream.lcmp();
              codeStream.ifgt(trueLabel);
              break;
            case T_double:
              codeStream.dcmpl();
              codeStream.ifgt(trueLabel);
          }
          // reposition the endPC
          codeStream.recordPositionsFrom(codeStream.position, this.sourceEnd);
          return;
        }
      } else {
        if (trueLabel == null) {
          // implicit falling through the TRUE case
          switch (promotedTypeID) {
            case T_int:
              codeStream.if_icmple(falseLabel);
              break;
            case T_float:
              codeStream.fcmpl();
              codeStream.ifle(falseLabel);
              break;
            case T_long:
              codeStream.lcmp();
              codeStream.ifle(falseLabel);
              break;
            case T_double:
              codeStream.dcmpl();
              codeStream.ifle(falseLabel);
          }
          // reposition the endPC
          codeStream.recordPositionsFrom(codeStream.position, this.sourceEnd);
          return;
        } else {
          // no implicit fall through TRUE/FALSE --> should never occur
        }
      }
    }
  }
}
