package test.sheji.celue;

public class Select {
    private ICalc obj;
    public Select(ICalc obj){
        this.obj = obj;
    }
    public int calc(int a,int b){
        return obj.calc(a,b);
    }
}
