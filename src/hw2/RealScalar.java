package hw2;

import Visitor.IsMatchScalarVisitor;
import Visitor.ScalarVisitor;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {
    private double v;

    public RealScalar(double x) {
        v = x;
    }

    public boolean isMatch(Scalar s){
        IsMatchScalarVisitor sv = new IsMatchScalarVisitor();
        return s.accept(sv, this);
    }

    public double getValue() {
        return v;
    }

    public Scalar add(Scalar s) {
        if (s == null || !isMatch(s)) return null;
        return new RealScalar(v + s.getValue());
    }

    public Scalar mul(Scalar s) {
        if (s == null || !isMatch(s)) return null;
        return new RealScalar(v * s.getValue());
    }

    public Scalar mul(int i) {
        return new RealScalar(v * i);
    }

    public Scalar power(int exp) {
        double x = 1;
        for (int i = 0; i < exp; i++)
            x *= v;
        return new RealScalar(x);
    }

    public int sign() {
        if (v > 0) return 1;
        else if (v < 0) return -1;
        else return 0; // should not happend
    }

    @Override
    public boolean accept(ScalarVisitor v, RationalScalar s) {
        return v.visitRationalScalar(this);
    }

    public boolean accept(ScalarVisitor v, RealScalar s) {
        return v.visitRealScalar(this);
    }

    public String toString() {
        DecimalFormat df3 = new DecimalFormat("#.###");
        String str = df3.format(v);
        return str;
    }
}
