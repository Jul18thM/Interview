package jul18thm.interview.interview.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 15:10
 * description 怎么确保一个集合不能被修改？
 */
public class 怎么确保一个集合不能被修改 {

    /**
     * 通过使用Collections集合工具类中的unmodifiableList方法将集合变成不可修改的类型。
     * final定义的引用数据类型只是地址不可改变，内容是可变的。
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list = Collections.unmodifiableList(list);
        // 在list变成不可修改的类型后，再对list进行add()操作会抛出 java.lang.UnsupportedOperationException 异常
        list.add("String4");
    }

}
