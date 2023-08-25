package leetcode.daimasuixianglu;

/**
 * @author lrd
 * @date 2023-08-25 9:24
 * 738. 单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 示例 1:
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: n = 332
 * 输出: 299
 * 提示:
 * 0 <= n <= 109
 */
public class Q738 {
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
