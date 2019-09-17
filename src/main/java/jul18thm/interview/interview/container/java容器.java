package jul18thm.interview.interview.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 10:29
 * description java 容器都有哪些？
 */
public class java容器 {

    /*
     * Java容器可分为两大类：
     * 1. Collection（List，Set）
     * 2. Map（HashMap，TreeMap，ConcurrentHashMap，hashTable）
     */

    /**
     * Collection
     *@author Jul.18th.M
     */
    Collection collection;

        List list;

            ArrayList arrayList;

            LinkedList linkedList;

            Vector vector;

        Set set = new HashSet();

            HashSet hashSet;

                LinkedHashSet linkedHashSet;

            TreeSet treeSet;



    /**
     * Map
     *@author Jul.18th.M
     */
    Map map;

        HashMap hashMap;

            LinkedHashMap linkedHashMap;

        TreeMap treeMap;

        ConcurrentHashMap concurrentHashMap;

        Hashtable hashtable;
}
