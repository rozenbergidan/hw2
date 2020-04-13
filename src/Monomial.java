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
    public boolean isMatch(Monomial m) {
        if (m == null) throw new IllegalArgumentException();
        return this.coe.isMatch(m.coe);
    }

    public boolean canAdd(Monomial m) {
        return isMatch(m) && this.exp == m.exp;
    }

    public Monomial add(Monomial m) {
        if (!canAdd(m)) return null;
        return new Monomial(coe.add(m.coe), exp);
    }

    public Monomial mul(Monomial m) {
        if (!isMatch(m)) return null;
        return new Monomial(coe.mul(m.coe), exp + m.exp);
    }

    public Scalar evalute(Scalar scalar) {
        if (scalar == null) throw new IllegalArgumentException("");
        return scalar.power(exp).mul(coe);
    }

    public Monomial derivative() { //TODO ask about what happens if the exp is 0
        if(exp==0) return null;
        return new Monomial(coe.mul(exp), exp - 1);
    }

    public int sign() {
        return coe.sign();
    }

    public String toString() {
        String str = "";
//        if(exp==0) str=coe.toString();
//        else if(exp==1){
//            if(coe.getValue()==1) str="x";
//            else if(coe.getValue() ==-1) str="-x";
//            else str=coe.toString()+"x";
//        }
//        else{
//            if(coe.getValue()==1) str="x^"+exp;
//            else if(coe.getValue() ==-1) str="-x^"+exp;
//            else str=coe.toString()+"x^"+exp;
//        }

        if (!(coe.toString().equals("1") | coe.toString().equals("-1")) | exp == 0) str = str + coe.toString();
        if(str == "" & coe.toString().equals("-1")) str = "-" +str;
        if (exp == 1) str = str + "x";
        if (exp > 1) str = str + "x^" + exp;
        
        return str;
    }
}
