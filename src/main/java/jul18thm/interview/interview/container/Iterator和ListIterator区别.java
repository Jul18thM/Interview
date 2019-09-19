package jul18thm.interview.interview.container;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 14:54
 * description Iterator 和 ListIterator 有什么区别？
 */
public class Iterator和ListIterator区别 {

    /**
     * 区别一： 使用范围不用，Iterator可以使用在所有集合对象上，ListIterator只能使用在List和List的子类型。
     *
     * 区别二： ListIterator拥有add()方法，而Iterator则没有add()方法。
     *
     * 区别三： Iterator只可以顺序遍历，ListIterator不仅可以顺序遍历，还可以是通过hasPrevious()和previous()方法逆序遍历。
     *
     * 区别四： ListIterator可以通过nextIndex()和previousIndex()方法定位当前索引的位置，Iterator没有这样的功能。
     *
     * 区别五： ListIterator不仅可以实现对象的删除操作，还可以通过set()方法实现对象的修改操作，Iterator只可以删除对象，不可以修改对象。
     */
}
