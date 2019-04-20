package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void  main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1) {
            System.out.println();
            System.out.println(1);
        } else {
            List<Integer> list = new ArrayList<>();
            List<Integer> listOut = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() > 1) {
                for (int i = 1; i < m; i++) {
                    index++;
                    if (index > (list.size() - 1)) {
                        index = 0;
                    }
                }
                if (list.size() > 2) {
                    System.out.print(list.get(index) + " ");
                } else {
                    System.out.print(list.get(index));
                }
                list.remove(index);

            }
            System.out.println();
            System.out.println(list.get(0));
        }
    }
    public static void main(String args[]){
        main();
    }
}
