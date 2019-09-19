package jul18thm.interview.interview.container;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 10:41
 * description 如何实现数组和 List 之间的转换？
 */
public class 数组和List之间的转换 {

    public static void main(String[] args) {

        // 数组转List：通过Arrays.asList()方法
        String[] arr = new String[]{"1","2","3","4","5"};
        List list = Arrays.asList(arr);
        System.out.println(list);


        // List转数组：通过list.toArray()方法
        String[] array = new String[list.size()];
        list.toArray(array);
    }
}
