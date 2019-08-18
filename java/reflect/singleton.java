import java.lang.reflect.*;
import java.util.Scanner;

public class singleton {
    public static class Singleton2{
        private Singleton2(){}
        private static Singleton2 single = null;
        public static   Singleton2 getInstance(){
            synchronized(Singleton2.class){
            if(single == null) {
                single = new Singleton2();
                }
            }
            return  single;
        }
    }
    public static class Singleton3{
        private static class My{
            private static final Singleton3 single = new Singleton3();
        }
        private  Singleton3(){
            System.out.println("this is a new instance!");
        }
        public static final Singleton3 getInstance(){
            return My.single;
        }
    }
    public static void main(String []args)throws Exception {
        Scanner s = new Scanner(System.in);
        s.next();
        Singleton3 obj = Singleton3.getInstance();
        Singleton3 obj2 = Singleton3.getInstance();
    }

}
