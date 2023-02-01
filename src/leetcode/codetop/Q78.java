package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-02-01 9:35
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Q78 {
    @Leetcode("字典排序 二进制排序")
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {//将每一位是否出现用0 1表示
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
    @Leetcode("递归")
    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());//结果加入空集
        for(int num:nums){
            List<List<Integer>> newSubsets=new ArrayList<>();
            for (List<Integer> subset:ans){
                List<Integer> newSubset=new ArrayList<>(subset);//复制结果中已经存在的子集
                newSubset.add(num);//加入当前数字
                newSubsets.add(newSubset);//加入输出结果
            }
            ans.addAll(newSubsets);
        }
        return ans;
    }
    @Leetcode("DFS")
     //List<List<Integer>> ans = new ArrayList<>();
     List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets2(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }
    private void dfs(int i) {//选或不选
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        // 不选 nums[i]
        dfs(i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
    private void dfs2(int i) {//选哪个数
        ans.add(new ArrayList<>(path)); // 固定答案
        if (i == nums.length) return;
        for (int j = i; j < nums.length; ++j) { // 枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }

}
