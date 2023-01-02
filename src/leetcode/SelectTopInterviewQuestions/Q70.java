package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-02 12:08
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 提示：
 * 1 <= n <= 45
 */
public class Q70 {
    @Leetcode("动态规划")
    public int climbStairs(int n) {
        int f0=1,f1=1;
        if(n<2)
            return 1;
        int ans=0;
        for (int i = 2; i <= n; i++) {
            ans=f0+f1;
            f0=f1;
            f1=ans;
        }
        return ans;
    }
}
