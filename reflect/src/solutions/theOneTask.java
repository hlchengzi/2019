package solutions;

import java.util.HashMap;
import java.util.Scanner;

public class theOneTask {
    static String expr;
    static int step;
    public static void main(String[] srgs){

        method();
    }
    public static void method(){
        java.util.Scanner in = new Scanner(System.in);
        expr=in.nextLine();
        analyze(0,expr.length(),'E');
    }
    public static void analyze(int left,int right,char start){
        switch (start){
            case 'E':{
                int bracnt = 0;
                Boolean binope = false;
                for(int i=right-1;i>=left;--i){
                    if(expr.charAt(i)== '(') bracnt++;
                    if(expr.charAt(i) == ')') bracnt--;
                    if(bracnt!=0){
                        if(expr.charAt(i)=='+' || expr.charAt(i)=='-'){
                            binope = true;
                            System.out.println("step"+step+":");
                            System.out.print(start+"->"+expr.charAt(i)+"T");
                            step++;
                            analyze(left,i,'E');
                            analyze(i+1,right,'T');
                            break;
                        }
                    }
                }
                if(!binope){
                    System.out.println("step:"+step);
                    System.out.println(start+"->"+"T");
                    step++;
                    analyze(left,right,'T');
                }
                break;
            }
            case 'T':{
                int bracnt = 0;
                Boolean binope = false;
                for(int i=right-1;i>=left;--i){
                    if(expr.charAt(i) == '(')bracnt++;
                    if(expr.charAt(i) == ')')bracnt--;
                    if(0!=bracnt){
                        if(expr.charAt(i)=='*' || expr.charAt(i)=='/'){
                            binope = true;
                            System.out.println("step"+step+":");
                            System.out.println("->"+start+expr.charAt(i)+"F");
                            step++;
                            analyze(left,i,'T');
                            analyze(i+1,right,'F');
                            break;
                        }
                    }
                }
            }
            case'F':{
                if(expr.charAt(left) == '('){
                    System.out.println("step"+step+":");
                    System.out.println("->"+"E");
                    step++;
                    analyze(left+1,right,'E');
                }
                else{
                    System.out.println("step"+step+":");
                    System.out.println(start+"->"+"n");
                    step++;
                }
                break;
            }
            default:break;
        }
    }
    public static  void test(){
        HashMap hashMap= new HashMap();
        hashMap.put("1","111");
    }
}
