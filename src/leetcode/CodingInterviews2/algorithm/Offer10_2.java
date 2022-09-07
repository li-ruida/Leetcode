package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-07 上午11:48
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Offer10_2 {
/*todo:动态规划
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了29.33%的用户
 */
    static final int MOD = 1000000007;
    public int numWays(int n) {
        int ans=0;
        int t0=1,t1=1;
        if(n<2)
            return 1;
        for (int i=2;i<=n;i++){
            ans=(t0+t1)%MOD;
            t0=t1;
            t1=ans;
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(numWays(2));
    }
/*todo:快速幂
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了32.37%的用户
 */
static final int MOD1 = 1000000007;
    public int numWays1(int n) {
        if (n < 2) {
            return 1;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);//乘n次
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};//结果矩阵初始化为对角矩阵
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD1);
            }
        }
        return c;
    }
}
