package jul18thm.interview.interview.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 14:39
 * description Iterator 怎么使用？有什么特点？
 */
public class Iterator使用和特点 {

    public static void main(String[] args) {


        /**
         * Iterator的使用
         */
        List list = new ArrayList();
        int maxLength = 10;
        for (int i = 0; i < maxLength; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer == 9)
                // 不可以使用集合的remove()方法，只可以使用iterator的remove()方法删除元素
                // list.remove(integer); 会抛出java.util.ConcurrentModificationException异常
                iterator.remove();
            else
                System.out.println(integer);
        }

        /*
         * foreach增强for循环，内部使用的是iterator，所以在使用foreach遍历集合的时候不可以使用remove()方法删除元素
         */



        /**
         * Iterator的特点：
         * 迭代过程中，不可以使用集合自带remove()方法删除元素，只可以使用Iterator自带的remove()方法删除元素。foreach内部使用Iterator，所以也不可以用集合自带的remove()方法删除元素。
         */

    }

}
