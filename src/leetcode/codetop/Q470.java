package leetcode.codetop;

/**
 * @author lrd
 * @date 2023-05-10 10:14
 * 470. 用 Rand7() 实现 Rand10()
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * 示例 1:
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 * 输入: 3
 * 输出: [3,8,10]
 * 提示:
 * 1 <= n <= 105
 *
 *
 * 相乘或者相加 划分并选择等概率时间
 */
public class Q470 {
    public int rand7(){
        return 0;
    }
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
