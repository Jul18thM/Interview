package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-12 11:15
 * description 抽象类必须要有抽象方法吗？
 */
public class 抽象类必须要有抽象方法吗 {

    public static void main(String[] args) {
        // 因为Author类是抽象类，不可以被实例化，所以对Author author = new Author();进行编译会报错：Error:(12, 25) java: 无法从静态上下文中引用非静态 变量 this


    }

    /**
     * 因为Reader类继承自抽象类Author，并重写了抽象类中的抽象方法think()，所以Reader类不是抽象类，可以被实例化
     *@author Jul.18th.M
     *@return
     */
    Reader reader =  new Reader();

    /**
     * 因为Student类继承了抽象类Author，没有重写抽象类中的抽象方法，想要实例化Student对象，必须在对象中重写抽象方法
     *@author Jul.18th.M
     *@return
     */
    Student student = new Student() {
        @Override
        public void think() {

        }
    };


    /**
     * 抽象类: 一个没有足够的信息来描绘具体的对象的类是抽象类
     * 抽象类的特征：
     * 1.抽象类不可以被实例化，但可以被子类继承
     * 2.抽象类具有构造器，因为所有类都有构造器
     * 3.抽象方法所在类一定是抽象类，但抽象类不一定有抽象方法
     *@author Jul.18th.M
     *@return
     */
    abstract class Author{
        /**
         * 抽象类的构造方法
         *@author Jul.18th.M
         *@return
         */
        public Author(){}

        /**
         * 抽象方法，没有{}方法体
         * 抽象方法之保留方法的功能，具体的执行，交给继承抽象类的子类，有子类重写抽象方法
         *@author Jul.18th.M
         *@return void
         */
        public abstract void think();

        /**
         * 非抽象方法
         *@author Jul.18th.M
         *@return void
         */
        public void talking(){

        }
    }

    /**
     * 子类继承抽象类，并重写抽象方法，则子类不是抽象类，可以被实例化
     *@author Jul.18th.M
     *@return
     */
    class Reader extends Author{

        @Override
        public void think() {
            System.out.println("思考中...");
        }
    }

    /**
     * 子类继承抽象类，不重写抽象方法，那么子类中包含了抽象方法，则子类必须被声明为abstract抽象的
     *@author Jul.18th.M
     *@return
     */
    abstract class Student extends Author{}

}
