package jul18thm.interview.interview.container;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 9:13
 * description 说一下 HashSet 的实现原理？
 */
public class HashSet的实现原理 {

    /**
     * HashSet底层是基于HashMap实现的，无序，元素不可重复。
     * HashSet通过add()方法向set中增加元素，HashSet的add()是基于HashMap的put()方法将键值对存放在HashSet中。
     * 为了保证元素在HashSet中的唯一性，会通过对比和key值的hashCode和value值是否相等，来规避重复的元素。
     */

}
