package solutions;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class test1904041 {
    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
       else return 2*(target-1);
    }
    public static void test(){
        Stack<Integer> stack1= new Stack<Integer>();
        stack1.push(new Integer(1));
        while(!stack1.empty()){
            stack1.pop();
        }
        System.out.println(stack1.empty());
        List<Integer> list = new ArrayList<Integer>(stack1.capacity());
        list.get(1);
    }
    public static int RectCover(int target) {
        //先分情况
        if(target<=1){
            return 1;
        }
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return RectCover((target-1))+RectCover(target-2);
        }
    }
    public static int minNumberInRotateArray(int [] array) {
            if(array.length == 0) {
                return 0;
            }

                for(int i=1;i<array.length;i++){
                    if(array[i-1]>array[i]){
                        return array[i];
                    }

            }
            return 0;
    }
    public static int Fibonacci(int n) {
    /**斐波拉契数列**/
    if(n==0||n==1){
        return n;
    }
    if(n==2){
        return 1;
    }
    return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static int JumpFloor(int target) {
        if(target<=2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    public static int NumberOf1(int n) {
        if(n==0){
            return 0;
        }
        else{
            int count=0;
            n= n & 0x7fffffff;
            while(n!=0){
                count++;
                n=n&(n-1);
            }
            return count;
        }
    }
    /**
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        先序遍历，第一个是根节点，中序遍历第一个根节点左边是左子树，根节点右边是右子树。
        if(pre.length == 0||in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;
    }**/
    public static double Power(double base, int exponent) {
        if(exponent==0||exponent==1){
            return 1-exponent;
        }
        //将指数转化正数
        long expon = (long)(exponent>0?exponent:-1*exponent);
        //然后使用快速幂算法
        double ans=1.0;
        while (expon!=0){
            if(expon!=0){
                ans = ans*base;
            }
            base*=base;
            expon>>=1;
        }
        return exponent>0?ans:1/ans;
    }
    public static void reOrderArray(int [] array) {
        List left=new ArrayList<Integer>(),right=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(1==(array[i]%2)){
                left.add(array[i]);
            }
            else {
                right.add(array[i]);
            }
        }
        for(int i=0;i<array.length;i++){
            if(i<left.size()){
                array[i]= (int) left.get(i);
            }
            else{
                array[i]=(int)right.get(i-left.size());
            }
        }
        for (int i=0;i<left.size();i++){
            System.out.print(left.get(i));
        }
        System.out.println();
        for (int i=0;i<right.size();i++){
            System.out.print(right.get(i));
        }
        System.out.println();
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }

    }
    public ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<>();
        int len=0;
        if(head==null||k<=0){
            return null;
        }
        while (head.next!=null){
            stack.push(head);
            head= head.next;
            len++;
        }
        stack.push(head);
        len++;
        if(k>len){
            return null;
        }
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        ListNode node = stack.pop();
        return node;
    }
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)  return false;
        return doesTree1HasTree2(root1, root2)|| HasSubtree(root1.left, root2)
                ||HasSubtree(root1.right, root2);
    }
    private boolean doesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2==null)  return true;
        if(root1==null)  return false;
        return root1.val==root2.val && doesTree1HasTree2(root1.left, root2.left)
                && doesTree1HasTree2(root1.right, root2.right);
    }
    public void Mirror(TreeNode root) {
    //操作给定的二叉树，将其变换为源二叉树的镜像。
        if(root!=null) {
                TreeNode tmp = null;
                tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                if(root.right!=null){
                    Mirror(root.right);
                }
                if(root.left!=null){
                    Mirror(root.left);
                }

        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        /**
         * 1   2  3  4
         * 5   6  7  8
         * 9  10 11 12
         * 13 14 15 16
         */
        int row=matrix.length-1,line=matrix[0].length;
        int[][] flag =new int[matrix.length][matrix[0].length];
        while(row>=1||line>=0){
            for(int i=0;i<line;i++){

            }
        }
        return null;
    }
    public void teatttt(){
        Scanner sc = new Scanner(System.in);
    }

    public static void main(String[] args){
        int n=10;
//        System.out.println(JumpFloorII(n));
//        System.out.println(RectCover(n));
//        test();
//        int[] array = {2,4,6,1,3,5,7};
//        System.out.println(minNumberInRotateArray(array));
//        System.out.println(Fibonacci(3));
//        System.out.println(JumpFloor(3));
//        System.out.println(NumberOf1(7));
//        System.out.println(Power(2.0,-3));
//        reOrderArray(array);
        int[][] matrix = {{1,2,3,4},
                          {1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};

        printMatrix(matrix);
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    Scanner sc = new Scanner(System.in);
//    String a = sc.
}
