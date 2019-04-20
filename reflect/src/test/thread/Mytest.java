package test.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ArrayList ：
 * LinkedList：
 * HashMap：
 * HashSet：
 * TreeMap：
 * TreeSet：
 * StringBulider：
 * 以上线程都是线程不安全的，最后使用的是ConcurrentLinkedQueue,它是线程安全的集合，容许发放的访问数据结构的不同部分来使竞争极小化。
 * 这些集合返回的都是弱一类的迭代器这意味着迭代器不一定能反映出他们被构造之后的所有的修改，但是，他们不会将同一个值返回两次。
 */

public class Mytest {

    public static void main(String[] args) {
        final Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("11111111111");
        queue.add("22222222222");
        queue.add("33333333333");
        queue.add("44444444444");
        queue.add("55555555555");
        queue.add("66666666666");
        queue.add("7777777777777ss");


        for(int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (queue.size() > 0) {
                        try {
                            /**
                             * 这里将线程的状态从new->waiting，等时间到了以后，又会从waiting转换为runnable
                             */
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String value = queue.poll();
                        /**
                         * 这里是对数据的处理过程
                         */
                        if(value != "" && null != value)
                            System.out.println(Thread.currentThread().getName() + "------------ " + value);
                    }


                }
            }).start();
        }

        student s = new student();
        Teacher t = new Teacher(s);
        Invoke invoke = new Invoke(t);
        invoke.executeM();
    }
}
