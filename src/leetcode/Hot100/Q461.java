package leetcode.Hot100;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-21 8:00
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * 提示：
 * 0 <= x, y <= 231 - 1
 */
public class Q461 {
    @Leetcode("n&(n-1)")
    public int hammingDistance(int x, int y) {
        int tmp=x^y;
        int counnt=0;
        while(tmp!=0){
            tmp&=tmp-1;
            counnt++;
        }
        return counnt;
    }
}
