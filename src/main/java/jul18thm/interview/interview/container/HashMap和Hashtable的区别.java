package jul18thm.interview.interview.container;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 15:32
 * description HashMap 和 Hashtable 有什么区别？
 */
public class HashMap和Hashtable的区别 {

    public static void main(String[] args) {

        /*
         * 区别一：Hashtable中的方法是同步的，在多线程并发情况下，Hashtable是线程安全的。
         *        HashMap中的方法不是同步的，在多线程并发情况下，HashMap是非线程安全的，想要线程安全，需要加上同步锁。
         */
        // 观察Hashtable的源码可以看到其put，get方法都加上了synchronized关键字修饰，对其加同步锁，保证线程安全
        Map<String,String> hashTable = new Hashtable<>();
        // 观察HashMap的源码，可以看到起put，get方法并没有加上synchronized关键字修饰，没有加同步锁，无法保证线程安全
        Map<String,String> hashMap = new HashMap<>();

        /*
         *
         */
    }
}
