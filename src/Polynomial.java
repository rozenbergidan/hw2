import com.sun.scenario.effect.light.SpotLight;

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
                    int b = 1;
                    if (n.length > 1) b = Integer.parseInt(n[1]);
                    RationalScalar c = new RationalScalar(a, b);
                    monomials.add(new Monomial(c, exp));
                } else {
                    int v = Integer.parseInt(coefficient);
                    RealScalar c = new RealScalar(v);
                    monomials.add(new Monomial(c, exp));
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
//    public Polynomial add(Polynomial p){
//        if(!isMatch(p)) return null;
//
//        Polynomial ans=new Polynomial();
//        String str="";
//        char type;
//        int exp=0;
//
//        Monomial checkType=new Monomial((new RealScalar(1.5)),1); //RealScalar Mono check
//        Iterator<Monomial>iterThis=monomials.iterator();
//        Iterator<Monomial>iterP=p.monomials.iterator();
//
//
//        Monomial thismono=iterThis.next();
//        Monomial pmono=iterP.next();
//
//        if(thismono.isMatch(checkType)) type='R';
//        else type='Q';
//
//        while(iterP.hasNext() & iterThis.hasNext()) {
//            if (exp < pmono.getExp() & exp < thismono.getExp()) { //if we didnt came to the poly exp
//                str = str + "0 ";
//            } else if (thismono.canAdd(pmono)) { //if exp is equals
//                Monomial temp = thismono.add(pmono);
//                str = str + temp.getScalar().toString() + " ";
//                thismono = iterThis.next();
//                pmono = iterP.next();
//            } else if (pmono.getExp() < thismono.getExp()) { //if pmono exp is lower
//                str = str + pmono.getScalar().toString() + " ";
//                pmono = iterP.next();
//            } else if (thismono.getExp() < pmono.getExp()) { //if thismono exp is lower
//                str = str + thismono.getScalar().toString() + " ";
//                thismono = iterP.next();
//            }
//            exp++;
//        }
//        while(iterP.hasNext()){  // if we didnt finish with p poly
//            if(exp<pmono.getExp()){
//                str = str + "0 ";
//            }
//            else{
//                str = str + pmono.getScalar().toString() + " ";
//                pmono = iterP.next();
//            }
//            exp++;
//        }
//        while(iterThis.hasNext()){  // if we didnt finish with this poly
//            if(exp<thismono.getExp()){
//                str = str + "0 ";
//            }
//            else{
//                str = str + thismono.getScalar().toString() + " ";
//                thismono = iterThis.next();
//            }
//            exp++;
//        }
//
//        ans.build(type,str);
//        return ans;
//    }

    public Polynomial add(Polynomial p) {
        if (!isMatch(p)) return null;
        Polynomial ans = new Polynomial();

        Iterator<Monomial> thisIter = monomials.iterator();
        Iterator<Monomial> pIter = p.monomials.iterator();
        Monomial thismono=null;
        Monomial pmono=null;

        while (thisIter.hasNext() & pIter.hasNext()) {
            if(thismono==null & pmono==null){
                thismono=thisIter.next();
                pmono=pIter.next();
            }
            if (pmono.getExp() < thismono.getExp()) {
                ans.monomials.add(pmono);
                pmono = pIter.next();
            } else if (thismono.getExp() < pmono.getExp()) {
                ans.monomials.add(thismono);
                thismono = thisIter.next();
            } else {
                Monomial temp = thismono.add(pmono);
                if (temp.getScalar().sign() != 0) //TODO check whether can we get 0 as sign
                    ans.monomials.add(temp);
                thismono = thisIter.next();
                pmono = pIter.next();
            }
        }
        while (thisIter.hasNext()) {
            if(thismono==null)
                thismono=thisIter.next();
            ans.monomials.add(thismono);
            thismono = thisIter.next();
        }
        while (pIter.hasNext()) {
            if(pmono==null)
                pmono=pIter.next();
            ans.monomials.add(pmono);
            pmono = pIter.next();
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

    }

    public Polynomial derivative() {
        Polynomial ans=new Polynomial();
        for(Monomial mono: monomials){
            if(mono.derivative()!=null)
                ans.monomials.add(mono.derivative());
        }
        return ans;
    }

    public String toString() {
        String str = "";
        for(Monomial mono: monomials){
            str=str+mono.toString();
        }
        return str;
    }

}
