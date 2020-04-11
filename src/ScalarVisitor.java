public interface ScalarVisitor {
    boolean visitRealScalar(RealScalar rs);
    boolean visitRealScalar(RationalScalar rs);

    boolean visitRationalScalar(RationalScalar rs);
    boolean visitRationalScalar(RealScalar rs);
}
