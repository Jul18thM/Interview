package jul18thm.interview.interview.container;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 15:32
 * description HashMap 和 Hashtable 有什么区别？
 */
public class HashMap和Hashtable的区别 {

    public static void main(String[] args) {


        Hashtable hashTable = new Hashtable<>();

        HashMap hashMap = new HashMap<>();

        /*
         * 区别一：Hashtable中的方法是同步的(加了synchronized同步锁)，在多线程并发情况下，Hashtable是线程安全的。
         *        HashMap中的方法不是同步的(没加synchronized同步锁)，在多线程并发情况下，HashMap是非线程安全的，想要线程安全，需要加上同步锁。
         * 源码：
         * Hashtable中的put方法 -> public synchronized V put(K key, V value) {}
         *
         * HashMap中的put方法 -> public V put(K key, V value) {}
         */


        /*
         * 区别二：Hashtable是继承自Dictionary类，HashMap继承自AbstractMap抽象类，并实现了Map接口。
         * 源码：
         * public class Hashtable<K,V>  extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable{}
         *
         * public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable{}
         */


        /*
         * 区别三：Hashtable中，key值和value值不允许存在null值；HashMap允许key值存在一个null值，value值可以多个null值。
         *
         * 源码：
         * Hashtable中的put方法中key值和value值不允许存在null的判断 -> value值 ：if (value == null) {throw new NullPointerException();}
         *                                                        key值：int hash = key.hashCode(); null既不是对象，又不是Object实例，所以没有hashCode，会报java.lang.NullPointerException
         * HashMap中put方法中key值和value值对null的判断 -> key值：static final int hash(Object key) {int h; return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);}
         *                                             value值：源码中并没有对value值进行相应的null之校验
         */


        /*
         * 区别四：Hashtable中hash数组初始大小为11,增量方式为2*oldSize + 1。HashMap中hash数组默认大小为16，大小是2的指数。
         *
         * 源码：
         * Hashtable -> 初始长度：public Hashtable() {this(11, 0.75f);}
         *              增量方式：rehash()方法中 int newCapacity = (oldCapacity << 1) + 1; 对旧的长度进行了左移一位操作，左移后加1，增量方式为2*n + 1
         *
         * HashMap -> 默认大小：static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; 1左移4位
         *
         */


        /*
         * 区别五：Hashtable是直接使用对象的hashCode，HashMap会重新计算hash值。
         */


        /*
         * 区别六：Hashtable在遍历上不仅是使用了Iterator迭代器，还使用了Enumeration枚举。HashMap仅使用了Iterator迭代器。
         *        Iterator迭代器支持fast-fail，Enumeration枚举不支持fast-fail。
         */

    }
}
