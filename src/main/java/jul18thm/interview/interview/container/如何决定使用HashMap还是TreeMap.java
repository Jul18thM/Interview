package jul18thm.interview.interview.container;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Jul.18th.M
 * @date 2019-09-18 17:05
 * description 如何决定使用 HashMap 还是 TreeMap？
 */
public class 如何决定使用HashMap还是TreeMap {

    public static void main(String[] args) {
        /*
         * 如果需要按Key值排序，就使用TreeMap
         */
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("String3","String3");
        treeMap.put("String1","String1");
        treeMap.put("String2","String2");
        // TreeMap会按自然顺序对key值惊醒排序
        System.out.println(treeMap);


        /*
         * 如果不需要排序则使用HashMap
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>(100000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hashMap.put(i,i);
        }
        long end = System.currentTimeMillis();
        System.out.println("HashMap插入十万组键值对耗时：" + (end - start));

        TreeMap<Integer,Integer> treeMap1 = new TreeMap<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            treeMap1.put(i,i);
        }
        end = System.currentTimeMillis();
        System.out.println("TreeMap插入十万组键值对耗时：" + (end - start));

        /*
         * 通过控制台打印结果（HashMap插入十万组键值对耗时：20；TreeMap插入十万组键值对耗时：40）可以看出，HashMap的效率要高于TreeMap。
         * 如果不需要排序，那么首先选择HashMap
         */
    }
}
