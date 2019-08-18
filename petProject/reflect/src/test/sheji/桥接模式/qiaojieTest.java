package test.sheji.桥接模式;

public class qiaojieTest {
    public static void main(String[] args){
        Ipost Ip = new numpost();
        Letter letter = new Letter(Ip);
        letter.post();
    }
}
