import java.rmi.MarshalledObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;

    public Polynomial() {
        monomials = new LinkedList<>();
    }

    public void build(char type, String input) { // TODO check if the biuld is according to the Instructions
        String[] coefficients = input.split(" ");
        int exp = 0;
        for (String coefficient : coefficients) {
            if (coefficient.length() > 0) {
                if (type == 'Q') {
                    String[] n = coefficient.split("/");
                    int a = Integer.parseInt(n[0]);
                    if (a != 0) {
                        int b = 1;
                        if (n.length > 1) b = Integer.parseInt(n[1]);
                        RationalScalar c = new RationalScalar(a, b);
                        monomials.add(new Monomial(c, exp));
                    }
                } else {
                    double v = Double.parseDouble(coefficient);
                    if (v != 0) {
                        RealScalar c = new RealScalar(v);
                        monomials.add(new Monomial(c, exp));
                    }
                }
                exp++;
            }

        }
    }

    public boolean isMatch(Polynomial p) {
        if (p == null) throw new IllegalArgumentException();
        Iterator<Monomial> iterThis = monomials.iterator();
        Iterator<Monomial> iterP = p.monomials.iterator();
        while (iterP.hasNext() & iterThis.hasNext()) {
            if (!iterThis.next().isMatch(iterP.next()))
                return false;
        }
        return true;

    }


    public Polynomial clone(){
        Polynomial ans=new Polynomial();
        for(Monomial mono: monomials)
            ans.monomials.add(mono);
        return ans;
    }


    public Polynomial add(Polynomial p) {
        if (!isMatch(p)) return null;
        Polynomial ans = new Polynomial();
        if (p.monomials.isEmpty()) ans = clone();
        else {
            Iterator<Monomial> thisIter = monomials.iterator();
            Iterator<Monomial> pIter = p.monomials.iterator();
            Monomial thismono = null;
            Monomial pmono = null;
            boolean tmNext = true;
            boolean pmNext = true;
            while ((thisIter.hasNext() & pIter.hasNext())) {
                if (pmNext) {
                    pmono = pIter.next();
                    pmNext = false;
                }
                if (tmNext) {
                    thismono = thisIter.next();
                    tmNext = false;
                }

                if (pmono.getExp() < thismono.getExp()) {
                    ans.monomials.add(pmono);
                    pmNext = true;
                } else if (thismono.getExp() < pmono.getExp()) {
                    ans.monomials.add(thismono);
                    tmNext = true;
                } else {
                    Monomial temp = thismono.add(pmono);
                    if (temp.getScalar().sign() != 0) //TODO check whether can we get 0 as sign
                        ans.monomials.add(temp);
                    tmNext = true;
                    pmNext = true;
                }
            }

            while (thisIter.hasNext() | !tmNext) {
                if (tmNext) {
                    thismono = thisIter.next();
                }
                tmNext = true;
                if (!pmNext & pmono.getExp() <= thismono.getExp()) {
                    if (pmono.getExp() == thismono.getExp()) {
                        Monomial temp = thismono.add(pmono);
                        if (temp.getScalar().sign() != 0) //TODO check whether can we get 0 as sign
                            ans.monomials.add(temp);
                    }
                    ans.monomials.add(pmono);
                    pmNext = true;
                }
                ans.monomials.add(thismono);
            }

            while (pIter.hasNext() | !pmNext) {
                if (!tmNext & pmono.getExp() >= thismono.getExp()) {
                    if (pmono.getExp() == thismono.getExp()) {
                        Monomial temp = thismono.add(pmono);
                        if (temp.getScalar().sign() != 0) //TODO check whether can we get 0 as sign
                            ans.monomials.add(temp);
                    } else ans.monomials.add(thismono);
                    tmNext = true;
                }
                if (pmNext) {
                    pmono = pIter.next();
                }
                pmNext = true;
                ans.monomials.add(pmono);
            }
        }
        return ans;
    }


    public Polynomial mul(Polynomial p) {
        if (!isMatch(p)) return null;
        Polynomial ans = new Polynomial();
        Iterator<Monomial> thisIter = monomials.iterator();
        while (thisIter.hasNext()) {
            Monomial thismono = thisIter.next();
            Polynomial temp = new Polynomial();
            for (Monomial mono : p.monomials) {
                temp.monomials.add(thismono.mul(mono));
            }
            ans = temp.add(ans);
        }
        return ans;

    }

    public Scalar evaluate(Scalar scalar) {
        Scalar ans = scalar.mul(1);
        Scalar nega = scalar.mul(-1);
        for (Monomial mono : monomials) {
            ans = ans.add(mono.evalute(scalar));
        }
        ans = ans.add(nega);
        return ans;
    }

    public Polynomial derivative() {
        Polynomial ans = new Polynomial();
        for (Monomial mono : monomials) {
            if (mono.derivative() != null)
                ans.monomials.add(mono.derivative());
        }
        return ans;
    }

    public String toString() {
        String str = "";
        for (Monomial mono : monomials) {
            if (mono.sign() == 1)
                str = str + "+" + mono.toString();
            else
                str = str + mono.toString();
        }
        if (str.length() == 0){
            str = "0";
        }
        else {
            if (str.charAt(0) == '+') str = str.substring(1);
        }
        return str;
    }


}
