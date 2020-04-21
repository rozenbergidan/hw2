package Visitor;

import hw2.*;

public class IsMatchScalarVisitor implements ScalarVisitor {

    //in this Object, the signatures only different by the second scalar type the function get.
    // hence the scalar that calling the visitor know which func to use, and due to the similarity of the signatures,
    // the instance type of scalar rs2 determent which function will be called

    private boolean isMatch;

    @Override
    public void visitRealScalar(RealScalar rs1, RealScalar rs2) {
        isMatch=true;
    }

    public void visitRealScalar(RealScalar rs1, RationalScalar rs2) {
        isMatch=false;
    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RationalScalar rs2) {
        isMatch=true;
    }

    public void visitRationalScalar(RationalScalar rs1, RealScalar rs2) {
        isMatch=false;
    }

    public boolean isMatch(){
        return isMatch;
    }
}
