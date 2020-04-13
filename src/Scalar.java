
public interface Scalar {

//    /**
////     * learn about:  virtualization, double dispatch and visitor pattern to get 15 points
////     */
////    public boolean isMatch(Scalar s) {
////        return ((this instanceof RealScalar & s instanceof RealScalar) | (this instanceof RationalScalar & s instanceof RationalScalar));
////    }

    public boolean isMatch(Scalar v);

    public double getValue();

    public Scalar add(Scalar s);

    public Scalar mul(Scalar s);

    public Scalar mul(int i);

    public Scalar power(int exp);

    public int sign();

    public boolean accept(ScalarVisitor v);

}