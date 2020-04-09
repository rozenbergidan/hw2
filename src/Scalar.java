public abstract class Scalar extends Object{
    public boolean isMatch(Scalar s){
        return this.getType() == s.getType();
    }
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar mul(int i);
    public abstract Scalar power(int exp);
    public abstract int sign();
    protected abstract String getType();
}