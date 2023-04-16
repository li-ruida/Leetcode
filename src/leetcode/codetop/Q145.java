package leetcode.codetop;

import leetcode.Leetcode;

import java.util.*;

/**
 * @author lrd
 * @date 2023-04-16 9:11
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Q145 {
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
    @Leetcode("递归")
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal1(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        dfs(root.right);
        ans.add(root.val);
    }
    @Leetcode("迭代")
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}










