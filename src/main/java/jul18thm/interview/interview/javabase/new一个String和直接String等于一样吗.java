package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-11 9:11
 * description String str="i"与 String str=new String("i")一样吗
 */
public class new一个String和直接String等于一样吗 {

    public static void main(String[] args) {
        // String str1 = "Jul18thM";str1对象先在常量池里寻找是否存在Jul18thM常量，如果存在则指向这个常量对应的内存地址，如果不存在则在常量池中新建。
        String str1 = "Jul18thM";

        // String str2 = "Jul18thM";上面代码已经在常量池中创建了一个"Jul18thM"常量，所以str2直接指向"Jul18thM"的内存地址。
        String str2 = "Jul18thM";

        // 使用new String("Jul18thM")来新建一个str3对象，new 出来的String对象不管常量池中是否存在"Jul18thM"常量都会开辟一个新的内存空间来存放，并不会指向已存在的"Jul18thM"的地址。
        String str3 = new String("Jul18thM");

        // str1的内存地址为：1740035246;str2的内存地址为：1740035246，两个对象指向的内存地址相同，所以str1 == str2的结果是：true
        System.out.println("str1 == str2的结果是：" + (str1 == str2) + ";str1的内存地址为："+ System.identityHashCode(str1) + ";str2的内存地址为：" + System.identityHashCode(str2));

        // 因为str3是new出来的，所以str3和str1的内存地址并不是指向同一个地址，所以str1 == str3的结果是：false
        System.out.println("str1 == str3的结果是：" + (str1 == str3) + ";str1的内存地址为："+ System.identityHashCode(str1) + ";str3的内存地址为：" + System.identityHashCode(str3));
    }
}
