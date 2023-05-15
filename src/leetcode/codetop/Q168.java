package leetcode.codetop;

/**
 * @author lrd
 * @date 2023-05-15 11:47
 * 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * 提示：
 * 1 <= columnNumber <= 231 - 1
 */
public class Q168 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

}
