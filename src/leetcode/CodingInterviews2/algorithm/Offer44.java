package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-12-12 9:29
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 限制：
 * 0 <= n < 2^31
 */
public class Offer44 {
@Leetcode("找规律")
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { //找到数字的位数轮次
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 从数字 start开始的第 n 个数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';

    }
    /*
    数字范围 经历数字的位数和
    1-9 9*1*1
    10-99 9*10*2
    100-999 9*100*3


    0 1 2 3 4 5
    10 11 12
     */

}
