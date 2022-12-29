package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-09 上午10:27
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
public class Offer14_2 {
/*数学
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了26.39%的用户
 */
@Leetcode("数学")
    public static int MOD=1000000007;
    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;
       int p=n/3;
       int q=n%3;
       if(q==0)
           return (int) f(p)%MOD;
       else if (q == 1)
           return (int) ((f(p-1)%MOD*4)%MOD);
       else
           return (int) f( p) * 2%MOD;
    }
    public long f(int n){
        long ans=1;
        while (n>0){
            --n;
            ans=(ans*3)%MOD;
        }
        return ans;
    }
/*
快速幂
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38 MB, 在所有 Java 提交中击败了86.44%的用户
 */
@Leetcode("快速幂")
    public int cuttingRope1(int n) {
        if(n < 4){
            return n-1;
        }
        int cnt3 = n / 3;
        if(n % 3 == 0){
            return (int)mypow(3, cnt3);
        } else if(n % 3 == 1){
            return (int)((mypow(3, cnt3 - 1) * 4) % MOD);
        } else {
            return (int)((mypow(3, cnt3) * 2) % MOD);
        }
    }
    private long mypow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= MOD;
            }
            base *= base;
            base %= MOD;
            num >>= 1;
        }
        return res;
    }




/*dp
long溢出 BigInteger
 */
@Leetcode("dp溢出")
    public int cuttingRope2(int n) {
        if (n<=3)
            return n-1;
        long []dp=new long[n+2];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            long tempMax=0;
            tempMax=Math.max(Math.max(2*(i-2),(dp[i-2]%MOD)*2%MOD),Math.max(3*(i-3),(dp[i-3]%MOD)*3%MOD));
            dp[i]=tempMax%MOD;
        }
        return (int) (dp[n]%MOD);
    }
    @Test
    public void test(){
        System.out.println(cuttingRope(2));//1
        System.out.println(cuttingRope(3));//2
        System.out.println(cuttingRope(10));//36
        System.out.println(cuttingRope(120));//953271190
        System.out.println(cuttingRope(127));//439254203
    }
}
