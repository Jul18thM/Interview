package jul18thm.interview.interview.container;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 9:30
 * description ArrayList 和 LinkedList 的区别是什么？
 */
public class ArrayList和LinkedList的区别 {

    public static void main(String[] args) {
        /*
         * ArrayList和LinkedList都是非线程安全的
         * 通过100个线程，每个线程中进行1000次的循环向ArrayList和LinkedList插入数据。
         * 若线程安全则两个list的长度均为100000，但实际上控制台打印的长度分别为：ArrayList的长度为：99958 LinkedList的长度为：99999，都不满足100000，所以ArrayList和LinkedList都是非线程安全的。
         */
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        arrayList.add(j);
                        linkedList.add(j);
                        System.out.println("ArrayList的长度为：" + arrayList.size());
                        System.out.println("LinkedList的长度为：" + linkedList.size());
                    }
                }
            }).start();
        }


        /*
         * ArrayList是一个可改变大小的数组，在大批量数据的get上效率高于LinkedList
         */
        ArrayList arrayList1 = new ArrayList();
        LinkedList linkedList1 = new LinkedList();
        for (int i = 0; i < 50000; i++) {
            arrayList1.add(0,String.valueOf(i));
            linkedList1.add(0,String.valueOf(i));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
           arrayList1.get(i);
        }

        long end = System.currentTimeMillis();
        // 获取10000个ArrayList中元素耗时：1
        System.out.println("获取10000个ArrayList中元素耗时：" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList1.get(i);
        }
        end = System.currentTimeMillis();
        // 获取10000个LinkedList中元素耗时：104
        System.out.println("获取10000个LinkedList中元素耗时：" + (end - start));

        /*
         * LinkedList是一个链表，在删除元素和添加元素的性能上优于ArrayList，在get上弱于ArrayList；
         */

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            arrayList1.remove(0);
        }
        end = System.currentTimeMillis();
        // 移除ArrayList中元素耗时：173
        System.out.println("移除ArrayList中元素耗时：" + (end - start));


        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            linkedList1.remove(0);
        }
        end = System.currentTimeMillis();
        // 移除LinkedList中元素耗时：4
        System.out.println("移除LinkedList中元素耗时：" + (end - start));
    }
}
