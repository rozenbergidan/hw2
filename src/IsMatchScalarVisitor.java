public class IsMatchScalarVisitor implements ScalarVisitor {
    @Override
    public boolean visitRealScalar(RealScalar rs) {
        return true;
    }

    public boolean visitRealScalar(RationalScalar rs) {
        return false;
    }

    public boolean visitRealScalar(Scalar s) {
        return false;
    }

    @Override
    public boolean visitRationalScalar(RationalScalar rs) {
        return true;
    }

    public boolean visitRationalScalar(RealScalar rs) {
        return false;
    }
}
