package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-12-27 9:16
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 分成上下三角
 * b[0] a[1]....a[n]
 * a[0] b[1] a[2] .... a[n-1]
 * a[0] a[1] b[2] a[3]...a[n-1]
 */
public class Offer66 {
@Leetcode("数学")
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0)
            return new int[0];
        int[] b = new int[len];
        b[0]=1;
        for (int i = 1; i < len; i++) {//下三角乘积
            b[i]=b[i-1]*a[i-1];
        }
        int tmp=1;
        for(int i = len - 2; i >= 0; i--) {//上三角乘积
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
