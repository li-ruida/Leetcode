package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-11-21 8:56
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Offer54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int ans,n;
    public int kthLargest(TreeNode root, int k) {
        n=k;
        dfs(root);
        return ans;
    }
    @Leetcode("逆序中序遍历")
    void dfs(TreeNode root){
        if (root==null)
            return;
        dfs(root.right);
        if(n==0)
            return;
        if(--n==0)
            ans=root.val;
        dfs(root.left);
    }
}
