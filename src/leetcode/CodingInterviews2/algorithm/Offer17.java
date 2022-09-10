package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-10 上午8:58
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Offer17 {
/*暴力,不考虑大数
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：49.2 MB, 在所有 Java 提交中击败了35.56%的用户
 */
@Leetcode("暴力,不考虑大数")
    public int[] printNumbers1(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
/*DFS 考虑大数
执行用时：7 ms, 在所有 Java 提交中击败了13.80%的用户
内存消耗：49.2 MB, 在所有 Java 提交中击败了41.12%的用户
 */
@Leetcode("DFS 考虑大数")
    int[] res;
    int nine = 0, count = 0, start, m;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        m = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == m) {
            String s = String.valueOf(num).substring(start);//截去多余的0
            if(!s.equals("0"))
                res[count++] = Integer.parseInt(s);
            if(m - start == nine)
                start--;
            return;
        }
        for(char i : loop) {
            if(i == '9')
                nine++;//轮数,第一次一轮9
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
    @Test
    public void test(){
        System.out.println(printNumbers(8));
    }
}
