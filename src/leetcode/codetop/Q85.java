package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author lrd
 * @date 2023-05-23 8:49
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * https://leetcode.cn/problems/maximal-rectangle/solutions/1861698/by-ac_oier-k02i/
 */
public class Q85 {
    @Leetcode("前缀和 单调栈")
    public int maximalRectangle(char[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        int[][] sum = new int[n + 10][m + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = mat[i - 1][j - 1] == '0' ? 0 : sum[i - 1][j] + 1;
            }
        }
        int[] l = new int[m + 10], r = new int[m + 10];
        for (int i = 1; i <= n; i++) {
            int[] cur = sum[i];
            Arrays.fill(l, 0); Arrays.fill(r, m + 1);
            Deque<Integer> d = new ArrayDeque<>();
            for (int j = 1; j <= m; j++) {
                while (!d.isEmpty() && cur[d.peekLast()] > cur[j]) r[d.pollLast()] = j;
                d.addLast(j);
            }
            d.clear();
            for (int j = m; j >= 1; j--) {
                while (!d.isEmpty() && cur[d.peekLast()] > cur[j]) l[d.pollLast()] = j;
                d.addLast(j);
            }
            for (int j = 1; j <= m; j++) ans = Math.max(ans, cur[j] * (r[j] - l[j] - 1));
        }
        return ans;
    }
}
