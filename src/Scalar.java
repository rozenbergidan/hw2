
public interface Scalar {

    public boolean isMatch(Scalar v);

    public double getValue();

    public Scalar add(Scalar s);

    public Scalar mul(Scalar s);

    public Scalar mul(int i);

    public Scalar power(int exp);

    public int sign();

    public boolean accept(ScalarVisitor v, RealScalar s);
    public boolean accept(ScalarVisitor v, RationalScalar s);

}