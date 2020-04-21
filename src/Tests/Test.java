package Tests;

import hw2.*;


public class Test {
    public static void main(String[] args){
        RealScalar n = new RealScalar(5);
        RealScalar m = new RealScalar(3);
        RationalScalar a = new RationalScalar(1,2);
        RationalScalar b = new RationalScalar(4,2);
        System.out.println(m.isMatch(n));
        System.out.println(a.isMatch(b));
        System.out.println(n.isMatch(a));
        System.out.println(a.isMatch(m));

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = p1.build('Q', "0");
        p2 = p2.build('R',"1 33");
        System.out.println(p1.mul(p2));
        System.out.println(p2.mul(p1));
    }
}
