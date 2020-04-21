package hw2;
import Visitor.*;
import Visitor.ScalarVisitor;

public interface Scalar {

    boolean isMatch(Scalar v);

    Scalar add(Scalar s);

    Scalar mul(Scalar s);

    Scalar mul(int i);

    Scalar power(int exp);

    int sign();

    //Functions to send "this" and the visitor to other, in order to avoid "instance of" and casting
    void accept(ScalarVisitor v, RealScalar s);
    void accept(ScalarVisitor v, RationalScalar s);
}