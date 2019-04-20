import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.*;


public  class test{


    public static void main(String []args) throws Exception {

        Class classinfo = Class.forName("java.util.List");

//        表示其构造函数
        Constructor cons[] = classinfo.getConstructors();
        System.out.println("Constructor");
        for (Constructor i:cons){
            System.out.println(i.toString());
        }
        Field fil[]  = classinfo.getDeclaredFields();
        System.out.println("Field:");
        for(Field i:fil){
            System.out.println(i.toString());
        }
        Method met[] = classinfo.getDeclaredMethods();
        System.out.println("Method");
        for(Method i:met){
            System.out.println(i.toString());
        }
//        Class classinfo = Class.forName("Solution");
//        Object obj  = classinfo.getConstructor().newInstance();
/**
 * 第二题
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * 解题思路，对于这种[1,:n-1]的问题，参考桶排序的思想，便利数组，将相对应的数放在该位置上，其位置上数表示数组中该数的个数
 */
//        Method mt1 = classinfo.getMethod("Find2",int[].class,int.class);
//        int[] nums ={2, 3, 1, 0, 2, 5};
//        System.out.println(mt1.invoke(obj,new Object[]{nums,nums.length}));
/**
 * 第三题
 */
//        Method mt2 = classinfo.getMethod("Finds3",int.class,int[][].class);
//        int[][] array = {
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};
//        System.out.println(mt2.invoke(obj,new Object[]{5,array}));
/**
 * 第五题
 */
//        Method mth3 =classinfo.getMethod("Finds5",StringBuffer.class);
//        StringBuffer strB = new StringBuffer("We Are Happy.");
//        System.out.println(mth3.invoke(obj,new Object[]{strB}));

        /**
         * 多线程知识相关
         */



    }
}