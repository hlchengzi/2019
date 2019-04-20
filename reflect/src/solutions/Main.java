package solutions;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if(!s.contains(",")){
            System.out.println(-1);
            return;
        }
        s.split(",");

        int a= Integer.parseInt(s.split(",")[0]);
        int b= Integer.parseInt(s.split(",")[1]);
        if(a<-100||1>100 || b>100 ||b<-100){
            return;
        }
        if(a>=b){
            System.out.println(a-b);
            return;
        }
            //表示是正常的
            int step =0;
            int now= a;
            while(now!=b){

                if(now>b){
                    step = step+(now-b);
                    now = b;

                }
                else if(now*2<b){
                    step++;
                    now*=2;
                }
                else if(now*2>b && (now*2-b)<(b-now)){

                    step++;
                    now*=2;
                }
//                else if((now*2>b&&(now-1)*2-b)<now*2-b){
//                    step+=2;
//                    now = (now-1)*2;
//                }
                else {

                    now++;
                    step++;
                }
            }
            System.out.println(step);
    }

}
