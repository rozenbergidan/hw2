import com.sun.scenario.effect.light.SpotLight;

import javax.management.relation.Relation;
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

//    public Polynomial add(Polynomial p) {
//        if (!isMatch(p)) return null;
//        Polynomial ans = new Polynomial();
//
//        Iterator<Monomial> thisIter = monomials.iterator();
//        Iterator<Monomial> pIter = p.monomials.iterator();
//        Monomial thismono = null;
//        Monomial pmono = null;
//
//        while(thisIter.hasNext() & pIter.hasNext()){
//            if (thismono == null & pmono == null) {
//                thismono = thisIter.next();
//                pmono = pIter.next();
//            }
//            if (pmono.getExp() < thismono.getExp()) {
//                ans.monomials.add(pmono);
//                pmono = pIter.next();
//            } else if (thismono.getExp() < pmono.getExp()) {
//                ans.monomials.add(thismono);
//                thismono = thisIter.next();
//            } else {
//                Monomial temp = thismono.add(pmono);
//                if (temp.getScalar().sign() != 0) //TODO check whether can we get 0 as sign
//                    ans.monomials.add(temp);
//                    thismono = thisIter.next();
//                    pmono = pIter.next();
//            }
//        }
//        while (thisIter.hasNext()) {
//            if (thismono == null)
//                thismono = thisIter.next();
//            ans.monomials.add(thismono);
//            thismono = thisIter.next();
//        }
//        while (pIter.hasNext()) {
//            if (pmono == null)
//                pmono = pIter.next();
//            ans.monomials.add(pmono);
//            pmono = pIter.next();
//        }
//        return ans;
//    }
public Polynomial add(Polynomial p) {
    if (!isMatch(p)) return null;
    Polynomial ans = new Polynomial();

    Iterator<Monomial> thisIter = monomials.iterator();
    Iterator<Monomial> pIter = p.monomials.iterator();
    Monomial thismono = null;
    Monomial pmono = null;
    boolean tmNext = true;
    boolean pmNext = true;
    while (thisIter.hasNext() & pIter.hasNext()) {
        if(pmNext) pmono = pIter.next();
        if(tmNext) thismono = thisIter.next();
        pmNext = false;
        tmNext = false;
        if (pmono.getExp() < thismono.getExp()) {
            ans.monomials.add(pmono);
            pmNext=true;
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

    while (thisIter.hasNext()) {
        thismono = thisIter.next();
        ans.monomials.add(thismono);
    }
    while (pIter.hasNext()) {
        pmono = pIter.next();
        ans.monomials.add(pmono);
    }
    return ans;
}

    public Polynomial mul(Polynomial p) {
        if (isMatch(p)) return null;
        Polynomial ans = new Polynomial();
        Iterator<Monomial> thisIter = monomials.iterator();
        while (thisIter.hasNext()) {
            Monomial thismono = thisIter.next();
            Polynomial temp = new Polynomial();
            for (Monomial mono : p.monomials) {
                temp.monomials.add(thismono.mul(mono));
            }
            ans = ans.add(temp);
        }
        return ans;

    }

    public Scalar evaluate(Scalar scalar) {
        Scalar ans=scalar.mul(1);
        Scalar nega=scalar.mul(-1);
        for(Monomial mono: monomials){
            ans=ans.add(mono.evalute(scalar));
        }
        ans=ans.add(nega);
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
            if(mono.sign()==1)
                str = str+"+"+mono.toString();
            else
            str = str+mono.toString();
        }
        if(str.charAt(0)=='+') str=str.substring(1);
        return str;
    }


}
