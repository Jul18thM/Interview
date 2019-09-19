package jul18thm.interview.interview.container;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 13:55
 * description 迭代器 Iterator 是什么？
 */
public class 迭代器Iterator {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        Iterator iterator = arrayList.iterator();

        /*
         * Iterator源码可以看出Iterator是一个接口，源码 -> public interface Iterator<E> {}
         * Iterator接口提供了对集合元素的迭代，每迭代一次，就向下移动一个位置，直到下一个元素为null，返回false。
         */

    }

}
