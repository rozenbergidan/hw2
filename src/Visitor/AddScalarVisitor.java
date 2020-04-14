package Visitor;

import hw2.*;

public class AddScalarVisitor implements ScalarVisitor{
    private Scalar output;

    @Override
    public void visitRealScalar(RealScalar rs1, RealScalar rs2) {


    }

    @Override
    public void visitRealScalar(RealScalar rs1, RationalScalar rs2) {

    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RationalScalar rs2) {

    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RealScalar rs2) {

    }

    public Scalar add(){
        return output;
    }
}