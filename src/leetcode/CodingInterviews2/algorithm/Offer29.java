package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-09-19 上午9:01
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Offer29 {
/*模拟
执行用时：1 ms, 在所有 Java 提交中击败了63.06%的用户
内存消耗：43.4 MB, 在所有 Java 提交中击败了39.74%的用户
 */
@Leetcode("模拟")
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++)
                res[x++] = matrix[t][i]; // left to right.
            if (++t > b)
                break;
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r)
                break;
            for (int i = r; i >= l; i--)
                res[x++] = matrix[b][i]; // right to left.
            if (t > --b)
                break;
            for (int i = b; i >= t; i--)
                res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r)
                break;
        }
        return res;
    }


}
