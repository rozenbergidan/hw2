public class Test {
    public static void main(String[] args){
        RationalScalar n = new RationalScalar(3,5);
        RationalScalar m = new RationalScalar(3,4);
        System.out.println(n.add(m));
        System.out.println(m.toString());
        RealScalar x = new RealScalar(2.1);
        System.out.println(n);
        Monomial mono = new Monomial(n,4);
        System.out.println(mono.derivative());
        System.out.println(mono.toString());
        Polynomial p = new Polynomial();
        p.build('R',"12    0    2.3 11");
        System.out.println("hello");
    }
}
