package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-06 上午9:11
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * 提示：
 * 0 <= n <= 100
 */

public class Offer10_1 {
/*
矩阵快速幂
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了42.89%的用户
时间复杂度：O(logn)。
空间复杂度：O(1)。

1     1       f(n-1)      f(n)
          *           =
1     0       f(n-2)      f(n-1)
 */
@Leetcode("矩阵快速幂")
    static final int MOD = 1000000007;
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);//乘n-1次
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
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
/*动态规划
时间复杂度：O(n)。
空间复杂度：O(1)。
 */
@Leetcode("动态规划")
public int fib2(int n) {
    if(n == 0) return 0;
    int fn0 = 0;
    int fn1 = 1;
    int temp;
    for(int i = 2; i <= n; i++){
        temp = fn0 + fn1;
        fn0 = fn1;
        fn1 = temp% 1000000007; // 每次运算都取模 避免越界
    }
    return fn1;
}

/*递归超时
 */
@Leetcode("递归超时")
    public int fib1(int n) {
        if(n<2){
            return n;
        }
        return (fib1(n-1)+fib1(n-2))%1000000008;
    }

}
