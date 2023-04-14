package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-04-14 9:04
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * 示例 1:
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: 1
 * 提示:
 * 1 <= k <= n <= 109
 */
public class Q440 {
    @Leetcode("字典树")
    public int findKthNumber(int n, int k) {
        int curr = 1;//从1开始，1是字典序最小的
        k--;//如果k=1，则不进入下面的循环，直接返回1，否则说明1不是目标，找第k-1个小的数
        while (k > 0) {
            int steps = count(curr, n);//steps=当前节点curr下有多少比n小的子节点(包括n)
            if (steps <= k) {//不够，需要去邻近节点找
                curr++;//+1意味着到达了邻近兄弟节点
                k = k - steps;
                //意味着前面的steps个数包含在在curr节点下，接下来进入兄弟节点找第k-steps小的数
            } else {//否则，在curr下
                k--;//减去当前节点
                curr = curr * 10;//从最左侧开始搜寻
            }
        }
        return curr;
    }

    public static int count(int curr, int n) {//计算节点curr下有多少比n小的子节点
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {//当前层有符合要求的节点
            steps += Math.min(last, n) - first + 1;//汇入
            first = first * 10;//进入到下一层
            last = last * 10 + 9;//进入到下一层
        }
        return steps;
    }
}
