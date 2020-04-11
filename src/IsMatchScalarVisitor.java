public class IsMatchScalarVisitor implements ScalarVisitor{
    @Override
    public boolean visitRealScalar(RealScalar rs) {
        return true;
    }

    @Override
    public boolean visitRationalScalar(RationalScalar rs) {
        return true;
    }
}
