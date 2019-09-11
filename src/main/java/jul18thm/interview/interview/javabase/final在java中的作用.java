package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-10 14:39
 * description final 在 java 中有什么作用
 */
public class final在java中的作用 {

    // final关键字主要用在：变量，方法，类。

    //作用一： 被final修饰的变量，不可以被更改。
    private static final String username = "Jul18thM";


    public static void main(String[] args) {

        // 代码：username = ""; 报错 Error:(17, 9) java: 无法为最终变量username分配值



    }

    /**
     * 作用二：被final修饰的类不可以被其他类继承
     *@author Jul.18th.M
     *@return
     */
    private final class Author{
        private String name;

        private String age;
    }
    // 创建一个新的类，继承Author
    // 代码：private class Person extends Author{}；报错 Error:(30, 34) java: 无法从最终jul18thm.interview.interview.javabase.final在java中的作用.Author进行继承


    /**
     * 作用三：使用final修饰方法，可以把方法锁定，不允许其他继承本类的继承类修改本方法的含义。早期的java实现版本中，使用final会将方法转为内嵌调用，在方法不是过于庞大的前提下，可以提高效率。但是现版本下的java中，类中所有的private方法都被隐式的指定为final
     *@author Jul.18th.M
     *@return java.lang.String
     */
    public final String setUsername(String name){
        return name;
    }
}
