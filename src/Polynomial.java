import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;

    public Polynomial(){
        monomials = new LinkedList<>();
    }

    public void build(char type, String input){ // TODO check if the biuld is according to the Instructions
        String[] coefficients = input.split(" ");
        int exp =0;
        for (String coefficient: coefficients) {
            if (coefficient.length() > 0) {
                if (type == 'Q') {
                    String[] n = coefficient.split("/");
                    int a = Integer.parseInt(n[0]);
                    if(a != 0) {
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
    public boolean isMatch(Polynomial p){
        if(p==null) throw new IllegalArgumentException();
        Iterator<Monomial>iterThis=monomials.iterator();
        Iterator<Monomial>iterP=p.monomials.iterator();
        while(iterP.hasNext() & iterThis.hasNext()){
            if(!iterThis.next().isMatch(iterP.next()))
                return false;
        }
        return true;

    }
    public Polynomial add(Polynomial p){
        if(!isMatch(p)) return null;

        Polynomial ans=new Polynomial();
        String str="";
        char type;
        int exp=0;
        Monomial checkType=new Monomial((new RealScalar(1.5)),1);
        Iterator<Monomial>iterThis=monomials.iterator();
        Iterator<Monomial>iterP=p.monomials.iterator();


        Monomial thismono=iterThis.next();
        Monomial pmono=iterP.next();

        if(thismono.isMatch(checkType)) type='R';
        else type='Q';
        while(iterP.hasNext() & iterThis.hasNext()) {
            if (exp < pmono.getExp() & exp < thismono.getExp()) { //if we didnt came to the poly exp
                str = str + "0 ";
            } else if (thismono.canAdd(pmono)) { //if exp is equals
                Monomial temp = thismono.add(pmono);
                str = str + temp.getScalar().toString() + " ";
                thismono = iterThis.next();
                pmono = iterP.next();
            } else if (pmono.getExp() < thismono.getExp()) { //if pmono exp is lower
                str = str + pmono.getScalar().toString() + " ";
                pmono = iterP.next();
            } else if (thismono.getExp() < pmono.getExp()) { //if thismono exp is lower
                str = str + thismono.getScalar().toString() + " ";
                thismono = iterP.next();
            }
            exp++;
        }
        while(iterP.hasNext()){  // if we didnt finish with p poly
            if(exp<pmono.getExp()){
                str = str + "0 ";
            }
            else{
                str = str + pmono.getScalar().toString() + " ";
                pmono = iterP.next();
            }
            exp++;
        }
        while(iterThis.hasNext()){  // if we didnt finish with this poly
            if(exp<thismono.getExp()){
                str = str + "0 ";
            }
            else{
                str = str + thismono.getScalar().toString() + " ";
                thismono = iterThis.next();
            }
            exp++;
        }

        ans.build(type,str);
        return ans;
    }
//    public Polynomial mul(Polynomial p){
//
//    }
   public Scalar evaluate(Scalar scalar){

       Iterator<Monomial> iter = monomials.iterator();

       Scalar ans;
       while (iter.hasNext()){
            ans = ans.
       }
    }
//    public Polynomial derivative(){
//
//    }
//    public String toString(){
//
//    }

}
