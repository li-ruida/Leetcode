package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-01-05 9:55
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * 提示:
 * 1 <= numRows <= 30
 */
public class Q118 {
    @Leetcode("数学")
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i)
                    tmp.add(1);
                else
                    tmp.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
            }
            ret.add(tmp);
        }
        return ret;
    }
}
