package jul18thm.interview.interview.javabase;

import lombok.Data;

import java.util.HashSet;

/**
 * @author Jul.18th.M
 * @date 2019-09-10 11:26
 * description 两个对象的 hashCode()相同，则 equals()也一定为 true，对吗
 */
public class 两个对象的hashCode相同则equals也一定为true对吗 {

    // hashCode是哈希码，也成为散列码，实际上是一个int整数，哈希码的作用是确定对象在哈希表中的索引位置。

    //hashCode()和equals()的相关规定

    // 1.如果两个对象相等，则hashCode也一定相同
    // 2.两个对象相等，对两个对象调用equals()方法返回true
    // 3.两个对象有相同的hashCode值，则两个对象不一定相等
    // 4.equals()方法被覆盖过，则hashCode()方法也一定被覆盖
    // 5.hashCode()的默认行为是对堆上的对象产生独特值，如果没重写hashCode()方法,则该class的两个对象无论如何都不会相等（即使这个对象指向相同的数据）

    public static void main(String[] args) {
        // 新建User对象
        User u1 = new User("Jul18thM", 24);
        User u2 = new User("Jul18thM", 24);
        User u3 = new User("MMW", 24);

        HashSet set = new HashSet();
        set.add(u1);
        set.add(u2);
        set.add(u3);
        System.out.println("u1.hashCode()是：" + u1.hashCode() + "/u1.hashCode()是：" + u2.hashCode() + "/u1.hashCode()是："+ u3.hashCode());
        // u1对象和u2对象虽然值相等，但各自对应的的hashCode不同，所以set中出现了重复元素
        System.out.println("u1.equals(u2)的结果是：" + u1.equals(u2));
        // 没有重置hashCode()，则会出现
        System.out.println(set);


        // 创建Person对象
        Person p1 = new Person("Jul18thM", 24);
        Person p2 = new Person("Jul18thM", 24);
        Person p3 = new Person("MMW", 24);
        Person p4 = new Person("jul18thm", 24);

        // 新建hashSet对象
        HashSet hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        // 两个值相同的对象之间在改写了hashCode()和equals()方法后，两者的hashCode相同，都是470166793，p1.equals(p2)的结果是：true，因为hashCode相同，hashSet不可以插入相同的hashCode，所以p2无法插入到hashSet中，hashSet中不再存在重复元素
        System.out.println("p1.equals(p2)的结果是：" + p1.equals(p2) + ";p1的hashCode是：" + p1.hashCode() + " p2的hashCode是：" + p2.hashCode());
        // 不同person对象之间的比较，虽然hashCode都是470166793，但p1.equals(p4)的结果是：false
        System.out.println("p1.equals(p4)的结果是：" + p1.equals(p4) + ";p1的hashCode是：" + p1.hashCode() + " p4的hashCode是：" + p4.hashCode());

        System.out.println(hashSet);

    }

    /***
     * 没有覆盖hashCode()和equals()方法的User对象
     *@author Jul.18th.M
     *@return
     */
    @Data
    private static class User{
        private String username;

        private Integer age;

        public User(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            // 如果是同一个对象返回true，反之则false
            if(this == obj){
                return true;
            }
            // 判断类型是否相同
            if(this.getClass() != obj.getClass()){
                return false;
            }

            User user = (User) obj;
            return username.equals(user.username) && age == user.age;
        }
    }

    @Data
    private static class Person{
        private String username;

        private Integer age;

        public Person(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            // 如果是同一个对象返回true，反之则false
            if(this == obj){
                return true;
            }
            // 判断类型是否相同
            if(this.getClass() != obj.getClass()){
                return false;
            }

            Person person = (Person) obj;
            return username.equals(person.username) && age == person.age;
        }

        @Override
        public int hashCode() {
            int nameHash =  username.toUpperCase().hashCode();
            return nameHash ^ age;
        }
    }
}
