package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.Arrays;

/**
 * @author lrd
 * @date 2022-12-05 17:46
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 限制：0
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        myquicksort(arr,0,arr.length-1);
        return Arrays.copyOf(arr, k);

    }
    /*
    从右开始找到第一个比基准值小的元素
    从左开始找到第一个比基准值大的元素
    直到左右遍历到同一个位置,即为基准值的正确的位置
    然后开始分治递归
     */
@Leetcode("快速排序")
    void myquicksort(int []arr,int l,int r){
        if(l>=r)
            return;
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l])
                j--;
            while (i < j && arr[i] <= arr[l])
                i++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        int temp=arr[i];
        arr[i]=arr[l];
        arr[l]=temp;
        myquicksort(arr, l, i - 1);
        myquicksort(arr, i + 1, r);
    }
}
