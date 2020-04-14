package Visitor;
import hw2.*;

public interface ScalarVisitor {
    void visitRealScalar(RealScalar rs1, RealScalar rs2);
    void visitRealScalar(RealScalar rs1, RationalScalar rs2);
    void visitRationalScalar(RationalScalar rs1, RationalScalar rs2);
    void visitRationalScalar(RationalScalar rs1, RealScalar rs2);
}
