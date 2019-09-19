package jul18thm.interview.interview.container;

import java.util.ArrayList;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 13:15
 * description Array 和 ArrayList 有何区别？
 */
public class Array和ArrayList区别 {

    /**
     * Array是数组，长度固定，不可以扩充容量，可以储存基本数据类型，也可以储存引用数据类型，但同一个数组只可以储存一种类型的数据
     * ArrayList是基于数组实现的，容量可以自动增长
     */
    public static void main(String[] args) {

        // Array
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        // int数组中，若添加arr[2] = "3"会报错：java: 不兼容的类型: java.lang.String无法转换为int
        // arr[2] = "3";

        // Array自动扩容，储存数据类型不受限
        ArrayList arrayList = new ArrayList(10);
        for (int i = 0; i < 11; i++) {
            if(i % 2 == 0) {
                arrayList.add(i);
            }else{
                arrayList.add("Sting" + i);
            }
        }
        System.out.println(arrayList);
    }

}
