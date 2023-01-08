package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2023-01-08 9:48
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Q29{
    @Leetcode("二分查找")
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        int flag=1;
        if(dividend<0)
            flag*=-1;
        if(divisor<0)
            flag*=-1;
        long dividend1=(long) dividend;
        long divisor1=(long) divisor;
        dividend1=Math.abs(dividend1);
        divisor1=Math.abs(divisor1);
        long left=0,right=dividend1;
        while (left<right){
            long mid=(long)(left+right+1)/2;
            if(mid*divisor1>dividend1){
                right=mid-1;
            }
            else {
                left=mid;
            }
        }
        return (int)(left*flag);
    }
    @Test
    public void test(){
        System.out.println(divide(-2147483648,2));
    }
}

