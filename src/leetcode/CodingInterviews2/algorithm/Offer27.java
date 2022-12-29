package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2022-09-17 上午9:19
 *剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 限制：
 * 0 <= 节点个数 <= 1000
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Offer27 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
/*栈
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了5.26%的用户
 */
@Leetcode("栈")
    public TreeNode mirrorTree1(TreeNode root) {
        if(root==null)
            return null;
        Deque stack =new ArrayDeque();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode t= (TreeNode) stack.pop();
            if(t.left != null)
                stack.add(t.left);
            if(t.right != null)
                stack.add(t.right);
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;
        }
        return root;
    }
/*递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了69.60%的用户
 */
@Leetcode("递归")
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
