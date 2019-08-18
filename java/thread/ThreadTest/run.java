package test.ThreadTest;

public class run {
    public static void main(String[] args){
        try {
            ThreadA ta = new ThreadA();
            ThreadB tb = new ThreadB();
            ta.start();
            tb.start();
            for (int i= 0;i<100;i++){
                Tools.t1.set("Main"+(i+1));
                System.out.println("Main get Value="+Tools.t1.get());
            }
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
