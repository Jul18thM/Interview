package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-11 10:32
 * description String 类的常用方法都有那些？
 */
public class String类的常用方法 {

    public static void main(String[] args) {

        final String author = " Jul . 18th . M ";

        // 一：length()获取字符串长度
        System.out.println("author的长度为：" + author.length());

        // 二：indexOf(),lastIndexOf()获取字符在字符串中的索引位置

        // indexOf()方法返回的是首次搜索到字符对应的索引位置
        System.out.println(".首次出现在author字符串中的索引位置为：" + author.indexOf("."));
        // lastIndexOf()方法返回的是最后一次搜索到字符对应的索引位置
        System.out.println(".最后出现在author字符串中的索引位置为：" + author.lastIndexOf("."));

        // 三：charAt()获取在字符串中指定索引处的字符
        System.out.println("author字符串在索引为3处的字符为：" + author.charAt(3));

        // 四：trim()去除字符串首尾的空格，replaceAll()去除字符串中所有的空格
        System.out.println("使用trim()方法剔除author字符串首尾的空格后的字符串为：" + author.trim());
        System.out.println("使用replaceAll()方法提出author字符串中所有空格后的字符串为：" + author.replaceAll(" ", ""));

        // 五：replace()和replaceFirst()字符串替换
        // replace()替换的是所有符合指定字符串要求的字符串
        System.out.println("使用replace()方法替换后的字符串为：" + author.replace(" ", ""));
        // replaceFirst()替换的是第一个符合指定字符串要求的字符串
        System.out.println("使用replaceFirst()方法替换后的字符串为：" + author.replaceFirst(" ", ""));

        // 六：equals()和equalsIgnoreCaes()判断字符串是否相等
        // equals()方法和equalsIgnoreCaes()方法的区别是equals()方法区分大小写
        String temp = " jul . 18th . m ";
        System.out.println("区分大小写的equals()方法判断author字符串和temp字符串的结果是：" + author.equals(temp));
        System.out.println("不区分大小写的equalsIgnoreCaes()方法判断author字符串和temp字符串的结果是：" + author.equalsIgnoreCase(temp));

        // 七：split()分割字符串
        // split()方法的重载方式一：不指定分割次数
        String[] arr = author.split("18th");
        System.out.println("字符串不指定次数进行分割");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // split()方法的重载方式二：指定分割次数
        arr = author.split("18th", 1);
        System.out.println("字符串指定次数进行分割");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 八：toUpperCase()和toLowerCase()字符串大小写转换
        // toUpperCase()小写转大写方法
        System.out.println("author字符串小写转大写后的结果是：" + author.toUpperCase());
        // toLowerCase()大写转小写方法
        System.out.println("author字符串大写转小写后的结果是：" + author.toLowerCase());
    }

}
