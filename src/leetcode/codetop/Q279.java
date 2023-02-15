package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-02-15 8:53
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 提示：
 * 1 <= n <= 104
 */
public class Q279 {
    @Leetcode("动态规划")
    public int numSquares(int n) {
        int []f=new int[n+1];
        f[0]=0;
        for (int i = 1; i <= n; i++) {
            int minn=Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn=Math.min(minn,f[i-j*j]);
            }
            f[i]=minn+1;
        }
        return f[n];
    }
}
