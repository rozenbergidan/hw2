package Visitor;

import hw2.*;

public class IsMatchScalarVisitor implements ScalarVisitor {
    private boolean isMatch;

    @Override
    public void visitRealScalar(RealScalar rs1, RealScalar rs2) {
        isMatch=true;
    }

    @Override
    public void visitRealScalar(RealScalar rs1, RationalScalar rs2) {
        isMatch=false;
    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RationalScalar rs2) {
        isMatch=true;
    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RealScalar rs2) {
        isMatch=false;
    }

    public boolean isMatch(){
        return isMatch;
    }
}
