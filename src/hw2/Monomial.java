package hw2;

public class Monomial {
    private Scalar coe;
    private int exp;

    public Monomial(Scalar x, int expo) {
        coe = x;
        exp = expo;
    }

    public int getExp(){
        return exp;
    }

    public Scalar getScalar(){
        return coe;
    }

    // Verify that Scalar s is the same monomial type
    public boolean isMatch(Monomial m) {
        if (m == null) throw new IllegalArgumentException();
        return this.coe.isMatch(m.coe);
    }


    private boolean canAdd(Monomial m) {
        return isMatch(m) && this.exp == m.exp;
    }

    // Adding 2 monomials, returns null for scalar from different type
    public Monomial add(Monomial m) {
        if (!canAdd(m)) return null;
        return new Monomial(coe.add(m.coe), exp);
    }

    // Multiplying 2 monomials, returns null for scalar from different type
    public Monomial mul(Monomial m) {
        if (!isMatch(m)) return null;
        return new Monomial(coe.mul(m.coe), exp + m.exp);
    }

    //evaluate the monomial value
    public Scalar evalute(Scalar scalar) {
        if (scalar == null) throw new IllegalArgumentException("");
        return scalar.power(exp).mul(coe);
    }

    // return the derivative of the monomial
    public Monomial derivative() {
        if(exp==0) return null;
        return new Monomial(coe.mul(exp), exp - 1);
    }

    public int sign() {
        return coe.sign();
    }

    public String toString() {
        String str = "";
        if (!(coe.toString().equals("1") | coe.toString().equals("-1")) | exp == 0) str = str + coe.toString();
        if(str == "" & coe.toString().equals("-1")) str = "-" +str;
        if (exp == 1) str = str + "x";
        if (exp > 1) str = str + "x^" + exp;
        
        return str;
    }
}
