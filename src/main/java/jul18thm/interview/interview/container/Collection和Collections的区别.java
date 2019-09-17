package jul18thm.interview.interview.container;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 13:51
 * description Collection 和 Collections 有什么区别？
 */
public class Collection和Collections的区别 {

    /**
     * Collection是集合的上级接口，继承它的有Set和List接口
     */
    class Collect implements Collection{

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
    }


    /**
     * Collections是集合的工具类。
     */
    Collections collections ;

}
