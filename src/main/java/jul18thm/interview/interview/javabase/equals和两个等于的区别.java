package jul18thm.interview.interview.javabase;

import lombok.Data;

/**
 * @author Jul.18th.M
 * @date 2019-09-10 10:18
 * description == 和 equals 的区别
 */
public class equals和两个等于的区别 {

    public static void main(String[] args) {
        // ==比较的是两个对象的地址是否相等（基本数据类型用==比较的是值，引用数据类型==比较的是内存地址）
        User user1 = new User("Jul18thM");
        User user2 = new User("Jul18thM");
        System.out.println("user1的内存地址是：" + System.identityHashCode(user1));
        System.out.println("user2的内存地址是：" + System.identityHashCode(user2));
        // 对象之间使用==，比较的是两个对象的内存地址。user1的内存地址是：884457408  user2的内存地址是：913190639，所以打印的值是user1 == user2结果是：false
        System.out.println("user1 == user2结果是：" + (user1 == user2));

        // equals()的使用方法一
        // User类没有覆盖 equals() 方法。则通过 equals() 比较该类的两个对象时，等价于通过“==”比较这两个对象，所以打印的值user1.equals(user2)结果是：false
        System.out.println("user1.equals(user2)结果是：" + user1.equals(user2));
        // equals()的使用方法二
        // 此处为了体现==和equals()的区别，需要new String(),不可以直接String str1 = "Jul18thM",因为String str2 = "Jul18thM"是对str1的引用，所以==和equals()的结果相同
        String str1 = new String("Jul18thM");
        String str2 = new String("Jul18thM");
        System.out.println("str1的内存地址是：" + System.identityHashCode(str1));
        System.out.println("str2的内存地址是：" + System.identityHashCode(str2));
        // 两个new出来的String对象的地址分别是 str1的内存地址是：1845066581，str2的内存地址是：1018937824，所以str1 == str2的结果是：false
        System.out.println("str1 == str2的结果是：" + (str1 == str2));
        // 因为String类重写了equals()方法来比较两个对象的内容是否相等，所以str1.equals(str2)的结果是：true
        System.out.println("str1.equals(str2)的结果是：" + str1.equals(str2));

    }


    static class User{
        private String username;

        public User(String username) {
            this.username = username;
        }

    }
}
