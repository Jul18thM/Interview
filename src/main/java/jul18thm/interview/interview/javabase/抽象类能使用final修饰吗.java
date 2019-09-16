package jul18thm.interview.interview.javabase;

/**
 * @author Jul.18th.M
 * @date 2019-09-16 9:55
 * description 抽象类能使用 final 修饰吗？
 */
public class 抽象类能使用final修饰吗 {
    /*
     final关键字：
     1.final修饰的类不可以被继承
     2.final修饰的方法不可以被子类重写
     3.final修饰的变量是常量，不可以被修改，只能赋值一次*/

    // 抽象类需要被子类继承，而final关键字修饰的类是不可以被继承的，所以抽象类不能用final关键字修饰,强行使用会报错：java: 非法的修饰符组合: abstract和final
}

