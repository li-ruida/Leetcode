package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-13 上午8:30
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 数值（按顺序）可以分成以下几个部分：
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * 输入：s = "    .1  "
 * 输出：true
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 */
public class Offer20 {
/*有限状态自动机
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了81.71%的用户
 */
@Leetcode("有限状态自动机")
    public boolean isNumber(String s) {
        if(s.trim()==null||s.trim().length()==0)//空字符串或长度为0
            return false;
        char []str=s.trim().toCharArray();//去除首尾空格,转换为字符数组
        int n=str.length;

        boolean fuhao1 = false,fuhao2 = false,shuzi=false,xiaoshudian= false,e= false,zhishu= false;
        for (int i = 0; i < n; i++) {
            if(str[i]==' ')
                return false;
            else if(str[i]=='+'||str[i]=='-'){
                if(shuzi==false&&e==false){
                    if(xiaoshudian==false){
                        if(fuhao1==false){
                            fuhao1=true;
                        }
                        else
                            return false;
                    }
                    else
                        return false;

                }
                else if(shuzi==true&&e==true)
                    if(zhishu==false){
                        if(fuhao2==false){
                            fuhao2=true;
                        }
                        else
                            return false;
                    }
                    else
                        return false;

                else if((shuzi=true&&e==false)||(shuzi==false&&e==true))//有数字但是没e 或相反 出现正负号为false
                    return false;
            }
            else if(str[i]=='e'||str[i]=='E'){
                if(e==false){
                    if(shuzi==true)
                        e=true;
                    else
                        return false;
                }
                else
                    return false;
            }
            else if(str[i]>='0'&&str[i]<='9'){
                if(e==false)
                    shuzi=true;
                else{
                    zhishu=true;
                }

            }
            else if(str[i]=='.'){
                if(xiaoshudian==false){
                    if(e==false){
                        xiaoshudian=true;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
            else //其他字符
                return false;

        }
        if(shuzi==false&&xiaoshudian==true)
            return false;
        if(e==true&&zhishu==false)
            return false;
        return true;
    }
    @Test
    public void test(){
        System.out.print(isNumber(".-4")+" ");//false

        System.out.println();
        System.out.println();
        System.out.print(isNumber("0")+" ");//true
        System.out.print(isNumber("e")+" ");
        System.out.print(isNumber(".")+" ");
        System.out.print(isNumber("    .1")+" ");//true
        System.out.println();
        System.out.println();

        String []s1=new String[] {"+100","5e2", "-123", "3.1416", "-1E-16", "0123"};
        String []s2=new String[] {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
        for (String s:s1){
            boolean ans=isNumber(s);
            System.out.print(ans+" ");
        }
        System.out.println();
        for (String s:s2){
            System.out.print(isNumber(s)+" ");
        }
    }
}
