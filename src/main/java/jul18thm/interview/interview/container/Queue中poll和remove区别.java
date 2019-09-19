package jul18thm.interview.interview.container;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Jul.18th.M
 * @date 2019-09-19 13:42
 * description 在 Queue 中 poll()和 remove()有什么区别？
 */
public class Queue中poll和remove区别 {

    /**
     * poll() 和 remove() 都是移除Queue中的第一个元素，但是remove()一个空的Queue时，会报java.util.NoSuchElementException 异常，而poll()则不会抛出异常
     */
    public static void main(String[] args) {
        // 新建一个队列
        Queue queue = new SynchronousQueue();
        // 使用poll()方法移除队列中第一个元素，不会报异常
        queue.poll();
        // 使用remove()方法移除队列中第一个元素，会抛出java.util.NoSuchElementException异常
        queue.remove();
    }

}



