import java.text.DecimalFormat;

public class RealScalar extends Scalar {
    private double v;

    public RealScalar(double x){
        if(x==0)
            throw new IllegalArgumentException("Coefficient can't be 0");
        v=x;
    }

    public double getV(){
        return v;
    }

    public Scalar add(Scalar s){
        if(s==null) return null;
        return new RealScalar(v+((RealScalar)s).getV());
    }

    public Scalar mul(Scalar s){
        if(s==null)return null;
        return new RealScalar(v*((RealScalar)s).getV());
    }
    public Scalar mul(int i){
        return new RealScalar(v*i);
    }
    public Scalar power(int exp){
        double x=v;
        for(int i=0;i<exp;i++)
            x*=x;
        return new RealScalar(x);

    }
    public int sign(){
        if(v>0) return 1;
        else if(v<0) return -1;
        else return 0; // should not happend
    }

    public String toString(){
        DecimalFormat df3 = new DecimalFormat("#.###");
        String str= df3.format(v);
        if(sign()==-1)
            str="-"+str;
        return str;
    }
}
