package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-03 下午7:01
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Offer05 {
/*暴力
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了10.51%的用户
 */
@Leetcode("暴力")
    public String replaceSpace(String s) {
        char []temp=s.toCharArray();
        char []ans=new char[s.length()*3];
        int i=0;
        for(char c:temp){
            if(c!=' '){
                ans[i++]=c;
            }
            else {
                ans[i++]='%';ans[i++]='2';ans[i++]='0';
            }
        }
        return new String(ans,0,i);
    }
/*

执行用时：2 ms, 在所有 Java 提交中击败了10.05%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了26.03%的用户
 */
@Leetcode("库函数")
    public String replaceSpace1(String s) {
        return s.replaceAll(" ","%20");
    }
}
