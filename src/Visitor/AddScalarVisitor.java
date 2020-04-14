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
        int a = rs1.getA() *  rs2.getB() + rs1.getB() * rs2.getA();
        int b = rs1.getB() * rs2.getB();
        output = new RationalScalar(a, b);
    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RealScalar rs2) {
        output = null;

    }


    public Scalar add(){
        return output;
    }
}