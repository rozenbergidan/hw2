package Visitor;

import hw2.*;


public class MulScalarVisitor implements ScalarVisitor {

    //in this Object, the signatures only different by the second scalar type the function get.
    // hence the scalar that calling the visitor know which func to use, and due to the similarity of the signatures,
    // the instance type of scalar rs2 determent which function will be called

    private Scalar output;
    @Override
    public void visitRealScalar(RealScalar rs1, RealScalar rs2) {
        output=new RealScalar(rs1.getValue()*rs2.getValue());
    }

    @Override
    public void visitRealScalar(RealScalar rs1, RationalScalar rs2) {
        output=null;
    }


    @Override
    public void visitRationalScalar(RationalScalar rs1, RationalScalar rs2) {
        int a = rs1.getA() * rs2.getA();
        int b = rs1.getB() * rs2.getB();
        output = new RationalScalar(a, b);
    }

    @Override
    public void visitRationalScalar(RationalScalar rs1, RealScalar rs2) {
        output = null;
    }

    public Scalar mul(){
        return output;
    }
}
