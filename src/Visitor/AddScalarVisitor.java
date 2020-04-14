package Visitor;

import hw2.*;

public class AddScalarVisitor implements ScalarVisitor{
    private Scalar output;

    @Override
    public void visitRealScalar(RealScalar rs1, RealScalar rs2) {
    output=new RealScalar(rs1.getValue()+rs2.getValue());

    }

    @Override
    public void visitRealScalar(RealScalar rs1, RationalScalar rs2) {
        output=null;
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