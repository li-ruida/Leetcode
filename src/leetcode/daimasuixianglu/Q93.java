package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-07-30 20:53
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，
 * 且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。
 * 你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 提示：
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class Q93 {
    List<String> ans,temp;

    public List<String> restoreIpAddresses(String s) {
        ans=new ArrayList();
        temp=new ArrayList();
        backTracking(s,0);
        return ans;
    }

    private void backTracking(String s, int begin) {
        if(temp.size()==4){
            if(begin==s.length()){
                ans.add(String.join(".",temp));
            }
            return;
        }
        for(int i=begin;i<begin+3&&i<s.length();++i){
            String sub=s.substring(begin,i+1);
            if(!isRange(sub)){
                continue;
            }
            temp.add(sub);
            backTracking(s,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public boolean isRange(String sub){
        if(sub.length()!=1&&sub.charAt(0)=='0'){
            return false;
        }
        return Integer.parseInt(sub)<=255?true:false;
    }
}
