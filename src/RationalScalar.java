public class RationalpullScalar extends Scalar{
    private int a;
    private int b;

    public RationalScalar(int a, int b){
        if(a == 0) throw new IllegalArgumentException("coefficient cant be 0");
        if(b == 0) throw new IllegalArgumentException("cannot divide by zero");
        this.a = a;
        this.b = b;
    }
    public Scalar add(Scalar s){
        if (!isMatch(s)) return null;
        int a = this.a*((RationalScalar)s).b+this.b*((RationalScalar)s).a;
        int b = this.b*((RationalScalar)s).b;
        return new RationalScalar(a,b);
    }
    public Scalar mul(Scalar s){
        if (!isMatch(s)) return null;
        int a = this.a*((RationalScalar)s).a;
        int b = this.b*((RationalScalar)s).b;
        return new RationalScalar(a,b);
    }

    public Scalar mul(int i) {
        return new RationalScalar(a*i, b);
    }
    public Scalar power(int exp) {
        int a = this.a;
        int b = this.b;
        for (int i = 0; i < exp ; i++) {
            a = a * this.a;
            b = b * this.b;
        }
        return new RationalScalar(a,b);
    }
    public int sign() {
        if(a*b > 0) return 1;
        return  -1;
    }

    public String toString(){
        String returnValue;
        if((a/b)*b == a) returnValue = (a/b)+"";// is it casting?
        else returnValue ="("+a+"/"+b+")";
        return  returnValue;
    }
}

