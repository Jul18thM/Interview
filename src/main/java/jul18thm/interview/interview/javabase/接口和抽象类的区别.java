package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-16 10:08
 * description 接口和抽象类有什么区别？
 */
public class 接口和抽象类的区别 {

    /**
     * 抽象类的特点：
     * 1.抽象类是由子类具有相同的同一特征抽象而来的，是子类的基类
     * 2.抽象方法必须为public或protected修饰的，不写关键字则默认public
     * 3.抽象类不能被实例化
     * 4.抽象类被子类继承，子类必须重写父类的抽象方法，如果子类不重写父类的抽象方法则子类也必须为抽象的
     * 5.抽象方法必须有子类来实现
     *@author Jul.18th.M
     */
    abstract static class Abstract{

        /**
         * 区别一： 抽象类可以有构造方法，接口没有构造方法
         *@author Jul.18th.M
         */
        public Abstract(){}

        /**
         * 区别二：抽象类中可以有普通成员变量，接口中不允许出现普通成员变量，只允许public static final修饰的静态变量
         *@author Jul.18th.M
         */
        String name = "Jul.18th.M";

        /**
         * 区别三：抽象类中的方法既可以是抽象方法也可以是非抽象方法，但接口中的方法都是抽象方法
         * 区别四：抽象类中的方法访问权限可以为public或者protected，接口中的方法访问权限只能是public
         *@author Jul.18th.M
         */
        protected void thinking(){
            System.out.println("I am thinking");
        }

        /**
         * 区别五：在jdk1.8之前，抽象类是不支持静态方法的，jdk1.8后支持静态方法，但要把抽象类声明为静态的
         *@author Jul.18th.M
         */
        public static void talking(){}

        /**
         * 区别六：抽象类中的静态变量的访问权限可以是public，private，protected,default,接口中的成员只能被声明成public static final类型的
         *@author Jul.18th.M
         */
        private static String author = "Jul.18th.M";

    }

    /**
     * 接口的特点：
     * 1.接口的所有方法访问权限自动被声明为public
     * 2.接口中的成员变量默认为public static final修饰的静态常量
     * 3.非抽象类实现接口则必须实现接口中的所有方法
     * 4.接口不是对象，接口可以声明接口变量
     * 5.接口完全解耦，提升代码复用性
     *@author Jul.18th.M
     */
    interface Interface{

        // 在接口中使用public Interface(){}构造方法会导致报错，因为接口中不可以存在构造方法

        /**
         * 接口中的变量默认为public static final修饰的静态变量，public static final可以不写
         *@author Jul.18th.M
         */
         String NAME = "Jul.18th.M";

         /**
          * 接口中的方法都是抽象的，不可以拥有方法体，而且只可以用public abstract修饰, protected void thinking();会报错：java: 此处不允许使用修饰符protected
          *@author Jul.18th.M
          */
         void thinking();
    }

    interface InterFace{}

    /**
     * 区别七：一个类只可以继承一个抽象类，但可以实现多接口；接口不可以实现接口，但可以继承接口
     *@author Jul.18th.M
     */
    class Author extends Abstract implements Interface,InterFace{
        @Override
        public void thinking() {
            System.out.println("一个类只可以继承一个抽象类，但可以实现多接口；接口不可以实现接口，但可以继承接口");
        }
    }

}
