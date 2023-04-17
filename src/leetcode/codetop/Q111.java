package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-04-18 7:30
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Q111 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    @Leetcode("深度优先搜索")
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int ans=Integer.MAX_VALUE;
        if(root.left!=null){
            ans=Math.min(minDepth(root.left),ans);
        }
        if(root.right!=null){
            ans=Math.min(minDepth(root.right),ans);
        }
        return ans+1;
    }

}
