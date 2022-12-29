package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lrd
 * @date 2022-12-28 10:17
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 当入队时,把递减队列小于当前值的弹出
 * 当出队时,若为最大值,则弹出
 */
public class Offer59_2 {
@Leetcode("队列")
    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> deque;//递减双向队列
        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }
        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }
        public void push_back(int value) {
            queue.offer(value);
            while(!deque.isEmpty() && deque.peekLast() < value)
                deque.pollLast();
            deque.offerLast(value);
        }
        public int pop_front() {
            if(queue.isEmpty()) return -1;
            if(queue.peek().equals(deque.peekFirst()))
                deque.pollFirst();
            return queue.poll();
        }

    }
}
