package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-03-23 10:22
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * -104 <= xn <= 104
 */
public class Q50 {
    @Leetcode("快速幂")
    public double myPow(double x, int n) {
        if(x == 0.0)
            return 0.0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
