package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-10 上午8:28
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
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
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 */
public class Offer16 {

/*快速幂+递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：40.9 MB, 在所有 Java 提交中击败了25.06%的用户
 */
@Leetcode("快速幂+递归")
    public double myPow(double x, int n) {
        double temp=0;
        if(n==0)
            return 1;
        else if (n==1)
            return x;
        else if(n==-1)
            return 1/x;
        temp=myPow(x,n/2);
        return temp*temp*myPow(x,n%2);
    }
    @Test
    public void test(){
        System.out.println(myPow(2,10));
        System.out.println(myPow(2.1,3));
    }
}
