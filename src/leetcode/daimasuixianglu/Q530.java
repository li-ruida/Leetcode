package leetcode.daimasuixianglu;

/**
 * @author lrd
 * @date 2023-07-20 8:27
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 */
public class Q530 {
    int pre;    // 前一个节点的值
    int ans;    // 记录最小绝对差

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;    // 设置ans为int数据类型最大值
        pre = -1;   // 初始值设为-1，表示前一个节点还未被遍历到
        dfs(root);  // 递归遍历整个二叉搜索树
        return ans; // 返回最小绝对差
    }

    public void dfs(TreeNode root) {
        if (root == null) { // 如果当前节点为空，返回
            return;
        }
        dfs(root.left); // 遍历当前节点的左子树
        if (pre == -1) { // 如果前一个节点还未被遍历到，则当前节点的值就是前一个节点的值
            pre = root.val;
        } else { // 如果前一个节点已经被遍历到，则计算当前节点值与前一个节点值的绝对差，并更新ans
            ans = Math.min(ans, root.val - pre);
            pre = root.val; // 更新前一个节点的值
        }
        dfs(root.right);    // 遍历当前节点的右子树
    }
}
