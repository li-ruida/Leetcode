package leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2023-02-22 9:52
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 */
public class Q232 {
    class MyQueue {
        Deque<Integer> stack1,stack2;
        public MyQueue() {
            stack1=new ArrayDeque<>();
            stack2=new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            int tmp=0;
            while (!stack1.isEmpty()){
                stack2.push(stack1.peek());
                tmp=stack1.pop();
            }
            if(!stack2.isEmpty())
                stack2.pop();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return tmp;
        }

        public int peek() {
            int tmp=0;
            while (!stack1.isEmpty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
            if(!stack2.isEmpty())
                tmp=stack2.peek();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return tmp;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
