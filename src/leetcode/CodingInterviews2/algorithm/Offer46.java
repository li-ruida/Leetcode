package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-12-30 11:14
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 提示：
 * 0 <= num < 231
 */
public class Offer46 {
@Leetcode("动态规划")
    public int translateNum(int num) {
        String str=String.valueOf(num);
        int len= str.length();
        int []dp=new int[len+1];
        dp[0]=1;dp[1]=1;//空字符与单字符
        for (int i = 2; i <= len; i++) {
            String tmp=str.substring(i-2,i);//dp[i]需要看dp[i-1]和dp[i-2]两项
            if (tmp.compareTo("10")>=0 && tmp.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else {
                dp[i]=dp[i-1];
            }
        }
        return dp[len];
    }
//简化版本,只维护两个变量,代替dp[],节省O(n)空间

//    class Solution {
//        public int translateNum(int num) {
//            String s = String.valueOf(num);
//            int a = 1, b = 1;
//            for(int i = 2; i <= s.length(); i++) {
//                String tmp = s.substring(i - 2, i);
//                int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
//                b = a;
//                a = c;
//            }
//            return a;
//        }
//    }


}
