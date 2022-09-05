package CodingInterviews2.leetcode;

import org.junit.Test;

import java.security.interfaces.ECKey;
import java.time.temporal.Temporal;

/**
 * @author lrd
 * @date 2022-09-03 下午5:55
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Offer04 {
/*
TODO:二分查找
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：47.7 MB, 在所有 Java 提交中击败了5.66%的用户
 */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0)
            return false;
        int n=matrix[0].length;
        int l;
        int r;
        for (int i = 0; i < m; i++) {
            l=0;
            r=n-1;
            while (l<=r){
                if(matrix[i][(l+r)/2]<target){
                    l=(l+r)/2+1;
                }
                else if(matrix[i][(l+r)/2]>target){
                    r=(l+r)/2-1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
    @Test
    public void test1(){
        int [][]arr=new int[][]{{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int [][]arr1=new int[][]{};
        System.out.println(findNumberIn2DArray(arr, 5));
        System.out.println(findNumberIn2DArray(arr, 20));
    }
}
