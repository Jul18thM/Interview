package jul18thm.interview.interview.container;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 10:53
 * description ArrayList 和 Vector 的区别是什么？
 */
public class ArrayList和Vector的区别 {

    public static void main(String[] args) {

        /*
         * 区别一： ArrayList是非线程安全的，Vector是线程安全的
         * 通过100个线程，每个线程中进行1000次的循环向ArrayList和LinkedList插入数据。
         * 若线程安全则两个list的长度均为100000，但实际上控制台打印的长度分别为：ArrayList的长度为：99986 Vector的长度为：100000，都不满足100000，所以ArrayList是非线程安全的,Vector是线程安全的。
         */
        ArrayList arrayList = new ArrayList();
        Vector vector = new Vector();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        arrayList.add(j);
                        vector.add(j);
                        System.out.println("ArrayList的长度为为：" + arrayList.size());
                        System.out.println("Vector的长度为为：" + vector.size());
                    }
                }
            }).start();
        }


        /*
         * 区别二：ArrayList和Vector的默认长度均为10，但增长倍率不同，ArrayList为1.5倍，Vector为2.0倍
         * 默认长度：Vector源码：  public Vector() {this(10);}
         *         ArrayList源码：  private static final int DEFAULT_CAPACITY = 10;
         * 控制台打印结果：ArrayList的扩容后的大小为：15；增长倍率为：1.5;Vector的扩容后的大小为：20；增长倍率为：2
         */
        int defaultCapacity = 10;
        Vector vector1 = new Vector(defaultCapacity);
        ArrayList arrayList1 = new ArrayList(defaultCapacity);
        for (int i = 0; i < 11; i++) {
            arrayList1.add(i);
            vector1.add(i);
        }
        System.out.println("ArrayList的扩容后的大小为：" + getArrayListCapacity(arrayList1) + "；增长倍率为：" + ((double)getArrayListCapacity(arrayList1) / defaultCapacity));
        System.out.println("Vector的扩容后的大小为：" +vector1.capacity() + "；增长倍率为：" + (vector1.capacity() / defaultCapacity));
    }


    /**
     * 获取ArrayList扩容后的大小
     *@author Jul.18th.M
     *@return int
     */
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[])field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }




}
