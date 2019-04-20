package test.sheji.celue;

public class Test {
    public static void main(String[] args){
        ICalc c = new Addcalc();
        Select obj = new Select(c);
        System.out.println(obj.calc(1,3));
    }
}
