package jul18thm.interview.interview.container;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 8:32
 * description 说一下 HashMap 的实现原理？
 */
public class HashMap的实现原理 {

    /**
     * HashMap是一种基于数组加链表的数据结构，HashMap是非线程安全的，key值允许出现一个null值，value值不限制null值出现次数。
     * HashMap底层基于哈希实现，使用 put(K key, V value)方法将键值对存放到容器中，使用get(Object key)方法输入对应的key值，查找对应的value值。
     * 在使用put()方法时，程序会先调用key值的hashCode()方法，获取key值对应的哈希值，根据获取的哈希值，将entry放在数组对应的位置上，这个哈希值就是entry在数组中对应的下标，在
     * 哈希值相同的情况下，会将entry存储到数组对应下标位置上的链表里。
     * 在使用get()方法是，程序会针对key值进行一次哈希映射，通过哈希值找到key值在数组中的下标，当key值的哈希值相等时，则会在数组对应下标的链表中通过key.equals方法寻找对应的节点。
     */
}
