package leetcode.CodingInterviews2.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2022-09-08 上午10:21
 *剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
*/
public class Offer12 {
/*
回溯
执行用时：169 ms, 在所有 Java 提交中击败了6.75%的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了51.49%的用户
 */
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean  [][] visited=new boolean[m][n];
        boolean flag=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag=check(board,visited,word,0,i,j);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board, boolean[][] visited,String s,int k,int i,int j){
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;//递归中设置为true
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited,s, k + 1,newi, newj);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;//递归结束设置为false
        return result;
    }
/*
dfs
执行用时：66 ms, 在所有 Java 提交中击败了51.62%的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了84.86%的用户
 */
    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) //越界或不相等
            return false;
        if(k == word.length - 1) //相等且最后一位
            return true;
        board[i][j] = '\0';//访问前做标记
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];//访问后恢复
        return res;
    }

}
