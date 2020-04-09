import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;

    public Polynomial(){}

    public void build(char type, String input){ // TODO check if the biuld is according to the Instructions
        String[] coefficients = input.split(" ");
        int exp =0;
        for (String coefficient: coefficients) {
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
    public boolean isMatch(Polynomial p){

    }
    public Polynomial add(Polynomial p){

    }
    public Polynomial mul(Polynomial p){

    }
    public Scalar evaluate(Scalar scalar){

    }
    public Polynomial derivative(){

    }
    public String toString(){

    }

}
