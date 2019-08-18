package test.ThreadTest;

public class ThreadB extends Thread {
    public void run(){
        try {
            for(int i=0;i<100;i++){
                Tools.t1.set("ThreadB"+(i+1));
                System.out.println("ThreadB:get:"+(Tools.t1.get()));
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
