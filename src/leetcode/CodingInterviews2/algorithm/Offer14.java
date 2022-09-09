package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-09 上午8:42
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
public class Offer14 {
/*数学
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了54.11%的用户

任意数字拆为可2和3
2*2*2<3*3
4拆为2*2
5以上优先拆出3
 */
    public int cuttingRope1(int n) {
        if(n<=3)
            return n-1;

        int p = n / 3;
        int q = n % 3;
        if (q == 0) {
            return (int) Math.pow(3, p);
        } else if (q == 1) {
            return (int) Math.pow(3, p - 1) * 4;
        } else {
            return (int) Math.pow(3, p) * 2;
        }

    }

/*动态规划
执行用时：1 ms, 在所有 Java 提交中击败了45.82%的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了38.83%的用户
 */
    public int cuttingRope(int n) {
        int []dp=new int[n+5];
        for (int i = 2; i <= n; i++) {//从2开始到n切割
            int tempMax=0;
            for (int j = 1; j < i; j++) {
                tempMax=Math.max(tempMax,Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = tempMax;
        }
        return dp[n];
    }
/*
dp优化
 */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(3));
        System.out.println(cuttingRope(10));
    }
}
