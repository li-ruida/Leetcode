package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-12-13 10:13
 */
public class Offer55_2 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
@Leetcode("后续遍历")
    int recur(TreeNode root) {
        if (root == null)
            return 0;
        int left = recur(root.left);
        if (left == -1)
            return -1;
        int right = recur(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
