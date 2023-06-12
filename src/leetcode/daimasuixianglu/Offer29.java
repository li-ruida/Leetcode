package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author lrd
 * @date 2023-06-12 8:48
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
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int n= matrix.length;
        if(n==0)
            return new int[0];
        int m=matrix[0].length;
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

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
