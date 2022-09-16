package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-16 上午8:24
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * 0 <= 节点个数 <= 10000
 */
public class Offer26 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：43.6 MB, 在所有 Java 提交中击败了65.71%的用户
 */
@Leetcode("递归")
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
                                        //包含头结点的子结构    左子树/右子树的子结构
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null)
            return true;
        if(A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
