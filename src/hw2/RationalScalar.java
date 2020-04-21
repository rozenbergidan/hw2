package hw2;

import Visitor.*;

public class RationalScalar implements Scalar {
    private int a;
    private int b;

    public RationalScalar(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("cannot divide by zero");
        this.a = a;
        this.b = b;
    }

    public RationalScalar(int a){
        this.a=a;
        this.b=1;
    }
    // Verify that Scalar s is the same instance type as this
    public boolean isMatch(Scalar s) {
        IsMatchScalarVisitor sv = new IsMatchScalarVisitor();
        s.accept(sv, this);
        return sv.isMatch();
    }

    // Adding 2 scalars, returns null for scalar from different type
    public Scalar add(Scalar s) {
        AddScalarVisitor asv = new AddScalarVisitor();
        s.accept(asv, this);
        return asv.add();
    }

    // Multiply 2 scalars, returns null for scalar from different type
    public Scalar mul(Scalar s) {
        MulScalarVisitor msv = new MulScalarVisitor();
        s.accept(msv, this);
        return msv.mul();
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

    // return the sing of the scalar
    public int sign() {
        if (a * b > 0) return 1;
        else if (a * b < 0) return -1;
        else return 0;
    }


    // accept method use to send this and s to the visitor
    @Override
    public void accept(ScalarVisitor v, RealScalar s) {
        v.visitRationalScalar(this, s);
    }

    // accept method use to send this and s to the visitor
    public void accept(ScalarVisitor v, RationalScalar s) {
        v.visitRationalScalar(this, s);
    }

    public String toString() {
        String returnValue;
        if (a % b == 0) returnValue = a / b + ""; // is it casting?
        else {
            if (b < 0) {
                a = -a;
                b = -b;
            }
            returnValue = "(" + a + "/" + b + ")";
        }
        return returnValue;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

