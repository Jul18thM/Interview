package jul18thm.interview.interview.container;

import java.util.*;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 14:06
 * description List、Set、Map 之间的区别是什么？
 */
public class List和Set和Map之间的区别 {
    public static void main(String[] args) {
        /**
         * List
         * 特点：元素有序放入，list中元素可以重复
         *      Collection接口的子接口 public interface List<E> extends Collection<E>
         *      List可以存在多个null值
         */
        List<String> list = new ArrayList();
        // List集合的add()方法用于在列表尾部插入元素，所以List的元素是有序放入的。
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Three");
        // 打印list的结果是[One, Two, Three, Three]，表明list可以存在重复元素
        System.out.println(list);


        /**
         * Set
         * 特点：元素无序放入，set中元素不可重复
         *      Collection接口的子接口 public interface Set<E> extends Collection<E>
         *      Set中只允许一个null
         */
        Set<String> set = new HashSet<>();
        set.add("String1");
        set.add("String4");
        set.add("String3");
        set.add("String2");
        set.add("String5");
        set.add("String5");
        /*
         * set打印结果为[String5, String4, String3, String2, String1]，与set元素的加入顺序不通，想要保持插入顺序则需要使用LinkedHashSet，若需要保持元素自然顺序则需要使用TreeSet
         * 插入6个元素，打印结果为5个元素，表示set中元素不可以重复
         */
        System.out.println(set);
        /*
         * -217105884
         * -217105885
         * -217105886
         * -217105887
         * -217105888
         * 元素在set中的位置是由元素的hashCode决定的,所以打印结果是[String5, String4, String3, String2, String1]
         */
        set.forEach(e -> System.out.println(e.hashCode()));


        /**
         * Map
         * 特点：Map是一个父级接口
         *      Map中数据以键值对形式存放，并且无序，key值不可以重复，value值可以重复
         *      key值只允许一个null值，value值不限制
         */
        Map<String, String> map = new HashMap(5);
        map.put("one", "one");
        map.put("two", "two");
        map.put("three", "three");
        map.put("three", "three");
        map.put("Three", "three");
        /*
         * map的打印结果为{two=two, three=three, Three=three, one=one}，并不与键值对插入顺序相同，所以map内元素是无序的
         * 一共插入了5组键值对，但是打印出来只有4对，说明了，key值不可以重复，打印结果中不同key值的value值存在重复，说明value值可以重复
         * 向HashMap中插入键值对，键值对是无序插入的，想保持键值对插入顺序需要使用LinkedHashMap，想要键值对根据key值保持自然顺序，则需要使用TreeSet
         */
        System.out.println(map);
        // 打印map中的key值的hashCode
        map.forEach((key, value) -> System.out.println("key值对应的hashCode为：" + key.hashCode()));
    }

}


