public interface ScalarVisitor {
    boolean visitRealScalar(RealScalar rs);
    boolean visitRationalScalar(RationalScalar rs);
}
