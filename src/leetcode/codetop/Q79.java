package leetcode.codetop;

/**
 * @author lrd
 * @date 2023-04-09 11:18
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class Q79 {
    boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        int xlen=board.length,ylen=board[0].length;
        visited =new boolean[xlen][ylen];
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                boolean flag=dfs(board,word,i,j,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int i,int j,int index){
        if(board[i][j]!=word.charAt(index))
            return false;
        else if(index==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        boolean result=false;
        int xi[]=new int[]{0,1,0,-1};
        int yi[]=new int[]{1,0,-1,0};
        for (int k = 0; k < 4; k++) {
            int nexti=xi[k]+i,nextj=yi[k]+j;
            if(nexti>=0&&nexti<board.length&&nextj>=0&&nextj<board[0].length){
                if(!visited[nexti][nextj]){
                    boolean flag=dfs(board,word,nexti,nextj,index+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;
        return result;
    }
}
