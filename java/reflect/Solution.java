import java.util.ArrayList;

public class Solution {
    public Integer Finds2(int[] nums,int length){
        ArrayList<Integer> ret = new ArrayList<Integer>(length);
        for(int i=0;i<length;i++){
            ret.add(length+1);
        }
        for(int i=0;i<length;i++){
            if(ret.get(nums[i]).equals(nums[i])){
                //如果这个地方的数相同，则表示重复的数返回
                return nums[i];
            }
            else {
                ret.set(nums[i],nums[i]);
            }
        }
        return null;
    }
    public boolean Finds3(int target, int [][] array) {
        /**
         * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
         * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
         */
        int row = array.length;
        int column = array[0].length;
        System.out.println(row);
        System.out.println(column);
        for(int i=row-1,j=0;i>=0 && j<column;){
            System.out.print(i);
            System.out.println(j);
            if(target == array[i][j]){
                return true;
            }
            else{
                if(target>array[i][j]){
                    j++;
                }
                else {
                  i--;
                }
            }

        }
        return false;
    }
    public String Finds5(StringBuffer str){
        if(str==null){
            return null;
        }
        StringBuffer strB = new StringBuffer();
        int len = str.length();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                len=len+2;
            }
        }
        for(int i=0,j=0;i<str.length();i++,j++){
            if(str.charAt(j) == ' '){
                strB.append('%');
                strB.append('2');
                strB.append('0');

            }
            else{
                strB.append(str.charAt(i));
            }
        }
        return strB.toString();
    }


}