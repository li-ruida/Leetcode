package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-03-05 15:44
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Q54 {
    @Leetcode("模拟")
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int left=0,right=matrix[0].length-1,top=0,bottom= matrix.length-1;
        while (true){
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if(++top>bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if(left>--right)
                break;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            if(top>--bottom)
                break;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if(++left>right)
                break;
        }
        return ans;
    }
}
