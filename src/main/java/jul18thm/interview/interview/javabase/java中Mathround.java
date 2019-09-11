package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-10 15:05
 * description java 中的 Math.round(-1.5) 等于多少
 */
public class java中Mathround {

    public static void main(String[] args) {
        // 四舍五入的原理是在参数上加0.5然后做向下取整,所以-1.5 + 0.5 = -1.0，-1.0向下取整为-1
        System.out.println(Math.round(-1.5));
    }
}
