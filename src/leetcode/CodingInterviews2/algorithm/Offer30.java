package leetcode.CodingInterviews2.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lrd
 * @date 2022-09-20 上午8:41
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 */
public class Offer30 {
/*
辅助栈
执行用时：13 ms, 在所有 Java 提交中击败了59.98%的用户
内存消耗：43.2 MB, 在所有 Java 提交中击败了90.74%的用户
 */
@Leetcode("辅助栈")
    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int min() {
            return minStack.peek();
        }


    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
