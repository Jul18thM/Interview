package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-11 9:30
 * description 如何将字符串反转？
 */
public class 将字符串反转 {

    private static final String author = "Jul18thM";

    public static void main(String[] args) {

        // 方法一：将String转为StringBuffer，通过StringBuffer内置的reverse()方法反转
        StringBuffer stringBuffer = new StringBuffer(author);
        System.out.println("将String转为StringBuffer，通过StringBuffer内置的reverse()方法反转" + stringBuffer.reverse());


        int length = author.length();

        // 方法二：通过字符串的charAt(int index)方法将author对象从尾部倒叙并赋值给str对象
        String str = "";
        for (int i = length - 1; i >= 0; i--) {
            str += author.charAt(i);
        }
        System.out.println("通过字符串的charAt(int index)方法将author对象从尾部倒叙并赋值给str对象" + str);

        // 方法三：

    }
}
