package Visitor;
import hw2.*;

public interface ScalarVisitor {
    //in this Interface, the signatures only different by the second scalar type the function get.
    // hence the scalar that calling the visitor know which func to use, and due to the similarity of the signatures,
    // the instance type of scalar rs2 determent which function will be called

    void visitRealScalar(RealScalar rs1, RealScalar rs2);
    void visitRealScalar(RealScalar rs1, RationalScalar rs2);
    void visitRationalScalar(RationalScalar rs1, RationalScalar rs2);
    void visitRationalScalar(RationalScalar rs1, RealScalar rs2);
}
