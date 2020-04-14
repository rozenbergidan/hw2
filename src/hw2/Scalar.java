package hw2;
import Visitor.*;
import Visitor.ScalarVisitor;

public interface Scalar {

    public boolean isMatch(Scalar v);

    public Scalar add(Scalar s);

    public Scalar mul(Scalar s);

    public Scalar mul(int i);

    public Scalar power(int exp);

    public int sign();

    public void accept(ScalarVisitor v, RealScalar s);
    public void accept(ScalarVisitor v, RationalScalar s);

    void accept(IsMatchScalarVisitor sv, RationalScalar rationalScalar);
}