package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-06-12 8:17
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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int n= matrix.length,m=matrix[0].length;
        int top=0,bottom=n-1,l=0,r=m-1;
        while (true){
            for (int i = l; i <= r; i++) {
                ans.add(matrix[top][i]);
            }
            if(++top>bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][r]);
            }
            if(--r<l)
                break;
            for (int i = r; i >=l; i--) {
                ans.add(matrix[bottom][i]);
            }
            if(--bottom<top)
                break;
            for (int i = bottom; i >=top; i--) {
                ans.add(matrix[i][l]);
            }
            if(++l>r)
                break;
        }

        return ans;
    }
}
