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
    }
}
