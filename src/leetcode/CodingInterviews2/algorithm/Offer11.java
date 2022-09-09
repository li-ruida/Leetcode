package leetcode.CodingInterviews2.algorithm;

import java.util.Arrays;

/**
 * @author lrd
 * @date 2022-09-07 下午3:39
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 示例 1：
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 * 提示：
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Offer11 {
/*
二分查找
O(logn)
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41.4 MB, 在所有 Java 提交中击败了31.65%的用户
 */
@Leetcode("二分查找")
    public int minArray(int[] numbers) {
        int l=0,m=0;
        int r=numbers.length-1;
        while (l<=r){
            m=(l+r)/2;
            if(numbers[m]>numbers[r]){
                l=m+1;
            }
            else if(numbers[m]<numbers[r]){
                r=m;
            }
            else {
                r--;
            }
        }
        return numbers[m];
    }
/*
快排之后返回第一个
O(nlogn)
 */

}
