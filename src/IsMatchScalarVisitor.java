public class IsMatchScalarVisitor implements ScalarVisitor{
    @Override
    public boolean visitRealScalar(RealScalar rs) {
        return true;
    }
    public boolean visitRealScalar(RationalScalar rs) {
        return false;
    }

    @Override
    public boolean visitRationalScalar(RationalScalar rs) {
        return true;
    }
    public boolean visitRationalScalar(RealScalar rs) {
        return false;
    }

    public Scalar RealAdd(RealScalar rs1, RealScalar rs2){
        return new RealScalar(rs1.getValue() + rs2.getValue());
    }
}
