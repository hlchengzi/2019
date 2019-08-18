package test.sheji.适配器;

public class Test {
    public static void main(String[] args){
        ThirdCompany third = new ThirdCompany();
        shipeiqi obj = new shipeiqi(third);
        System.out.println(obj.add(1,3));
    }
}
