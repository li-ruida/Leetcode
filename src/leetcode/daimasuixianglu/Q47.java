package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lrd
 * @date 2023-08-04 8:56
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Q47 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    boolean vis[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis=new boolean[nums.length];
        Arrays.sort(nums);
        f(nums,0);
        return ans;
    }
    public void f(int []nums, int idx){
        if (idx== nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            f(nums,  idx + 1);
            vis[i] = false;
            perm.remove(idx);
        }
            
    }
}
