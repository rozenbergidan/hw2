package hw2;

import Visitor.*;

public class RationalScalar implements Scalar {
    private int a;
    private int b;

    public RationalScalar(int a, int b) {
//        if (a == 0) throw new IllegalArgumentException("coefficient cant be 0");
        if (b == 0) throw new IllegalArgumentException("cannot divide by zero");
        this.a = a;
        this.b = b;
    }

    public boolean isMatch(Scalar s) {
        IsMatchScalarVisitor sv = new IsMatchScalarVisitor();
        s.accept(sv, this);
        return sv.isMatch()
    }

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public Scalar add(Scalar s) {//use GCD?
        if (s == null || !isMatch(s)) return null;
        int a = this.a * ((RationalScalar) s).b + this.b * ((RationalScalar) s).a;
        int b = this.b * ((RationalScalar) s).b;
        return new RationalScalar(a, b);
    }

    public Scalar mul(Scalar s) {//use GCD?
        if (s == null || !isMatch(s)) return null;
        int a = this.a * ((RationalScalar) s).a;
        int b = this.b * ((RationalScalar) s).b;
        return new RationalScalar(a, b);
    }

    public Scalar mul(int i) {
        return new RationalScalar(a * i, b);
    }

    public Scalar power(int exp) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < exp; i++) {
            a = a * this.a;
            b = b * this.b;
        }
        return new RationalScalar(a, b);
    }

    public int sign() {
        if (a * b > 0) return 1;
        else if (a * b < 0) return -1;
        else return 0;
    }

    @Override
    public void accept(ScalarVisitor v, RealScalar s) {

    }


    @Override
    public void accept(IsMatchScalarVisitor sv, RationalScalar rationalScalar) {

    }

    public String toString() {
        String returnValue;
        if (a % b == 0) returnValue = a / b+""; // is it casting?
        else {
            if (b < 0) {
                a = -a;
                b = -b;
            }
            returnValue = "(" + a + "/" + b + ")";
        }
        return returnValue;
    }
}

