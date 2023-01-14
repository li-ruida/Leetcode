package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-14 8:40
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 * 提示：
 * 0 <= n <= 104
 *
 * 5的个数小于2的个数
 */
public class Q172 {
    @Leetcode("数学")
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

}
