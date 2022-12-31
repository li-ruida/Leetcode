package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-12-31 16:12
 *
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 */
public class Offer51 {
@Leetcode("归并排序 分治")
    int[] numss, tmp;
    public int reversePairs(int[] nums) {
        numss = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = numss[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                numss[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                numss[k] = tmp[i++];
            else {
                numss[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}
