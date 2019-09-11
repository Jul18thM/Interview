package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-10 15:12
 * description java 中操作字符串都有哪些类？它们之间有什么区别？
 */
public class java中操作字符串都有哪些类 { ;

    public static void main(String[] args) {

        //java中操作字符串的类有：1.String，2.StringBuffer，3.StringBuilder

        // 1.String：String声明的是不可修改的对象，每次操作都会生成新的对象，然后将指针指向新的String对象。
        String str = "Jul18thM";
        System.out.println("变更之前的str的内存地址为：" + System.identityHashCode(str));
        str = str + "^_^";
        System.out.println("变更过后的str的内存地址为：" + System.identityHashCode(str));
        // 变更前和变更后str对象的内存地址从1740035246变为了884457408，说明String是不可修改的对象，任何对String的操作，都会产生新的对象，然后将原有对象指向新的内存地址


        // 2.StringBuffer：StringBuffer声明的对象是可以在原有对象基础上进行操作。StringBuffer是线程安全的,append方法会有同步锁,所以StringBuffer的效率比StringBuilder的效率低。


        // 3.StringBuilder：StringBuilder声明的对象是可以在原有对象的基础上进行操作。StringBuilder是非线程安全的。StringBuiler的效率比StringBuffer的效率高。


        // StringBuffer和StringBuilder的效率对比
        // stringBuffer的开始时间
        StringBuffer stringBuffer = new StringBuffer("stringBuffer");
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("StringBuffer所需时间：" + (l2 - l1));

        // StringBuilder的开始时间
        StringBuilder stringBuilder = new StringBuilder("stringBuilder");
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        long l4 = System.currentTimeMillis();
        System.out.println("StringBuilder所需时间：" + (l4 - l3));
        // StringBuffer所需时间：14，而StringBuilder所需时间：6，由此可见StringBuilder的效率高于StringBuffer

        //StringBuffer线程安全和StringBuilder非线程安全
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuilder stringBuilder1 = new StringBuilder();
        // 使用1000个线程，每个线程尽心1000次操作，字符串应有的长度应该是1000000，最后一次打印结果为stringBuffer1的长度为：1000000;stringBuffer1的长度为：999997，所以可以看出StringBuffer是线程安全的，StringBuilder是非线程安全的
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        stringBuffer1.append("1");
                        stringBuilder1.append("1");
                        System.out.println("stringBuffer1的长度为：" + stringBuffer1.length() + ";stringBuffer1的长度为：" +stringBuilder1.length());
                    }
                }
            }).start();
        }




    }



}
