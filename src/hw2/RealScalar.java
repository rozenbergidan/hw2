package hw2;

import Visitor.*;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {
    private double v;

    public RealScalar(double x) {
        v = x;
    }

    // Verify that Scalar s is the same instance type as this
    public boolean isMatch(Scalar s){
        if(s == null) return false;
        IsMatchScalarVisitor sv = new IsMatchScalarVisitor();
        s.accept(sv, this);
        return sv.isMatch();
    }

    // Adding 2 scalars, returns null for scalar from different type
    public Scalar add(Scalar s) {
        if (!isMatch(s)) return null;
        AddScalarVisitor sv = new AddScalarVisitor();
        s.accept(sv,this);
        return sv.add();
    }

    // Multiply 2 scalars, returns null for scalar from different type
    public Scalar mul(Scalar s) {
        if (!isMatch(s)) return null;
        MulScalarVisitor sv = new MulScalarVisitor();
        s.accept(sv,this);
        return sv.mul();
    }


    // Multiply 2 scalars, returns null for scalar from different type
    public Scalar mul(int i) {
        return new RealScalar(v * i);
    }

    public Scalar power(int exp) {
        double x = 1;
        for (int i = 0; i < exp; i++)
            x *= v;
        return new RealScalar(x);
    }

    // return the sing of the scalar
    public int sign() {
        if (v > 0) return 1;
        else if (v < 0) return -1;
        else return 0; // should not happend
    }

    // accept method use to send this and s to the visitor
    @Override
    public void accept(ScalarVisitor v, RationalScalar s) {
        v.visitRealScalar(this, s);
    }

    // accept method use to send this and s to the visitor
    public void accept(ScalarVisitor v, RealScalar s) {
        v.visitRealScalar(this,s);
    }

    public String toString() {
        DecimalFormat df3 = new DecimalFormat("#.###");
        String str = df3.format(v);
        return str;
    }

    public double getValue() {
        return v;
    }
}
