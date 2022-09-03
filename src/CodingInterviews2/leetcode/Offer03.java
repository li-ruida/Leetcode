package CodingInterviews2.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lrd
 * @date 2022-09-03 下午5:07
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：
 *
 * 2 <= n <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer03 {

/*HashSet
执行用时：4 ms, 在所有 Java 提交中击败了58.62%的用户
内存消耗：51.1 MB, 在所有 Java 提交中击败了12.24%的用户
 */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
/*设置标记
执行用时：1 ms, 在所有 Java 提交中击败了79.91%的用户
内存消耗：48.2 MB, 在所有 Java 提交中击败了99.74%的用户
 */
    public int findRepeatNumber1(int[] nums) {
        int repeat=-1;
        int count=nums.length;
        byte []arr=new byte[count+1];
        for (int i=0;i<count;i++){
            if(arr[nums[i]]==0)
                arr[nums[i]]=1;
            else
                return nums[i];
        }
        return repeat;
    }
    @Test
    public void test1(){
        int []nums=new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(nums));
    }

}
