package leetcode.SelectTopInterviewQuestions;


import leetcode.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lrd
 * @date 2023-01-03 10:47
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */
public class Q101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    @Leetcode("递归")
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    boolean check(TreeNode p,TreeNode q){
        if(p==null && q ==null)
            return true;
        else if (p==null ||q==null)
            return false;
        return p.val==q.val&& check(p.left,q.right)&&check(p.right,q.left);
    }
    @Leetcode("迭代")
    boolean check1(TreeNode p,TreeNode q){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p=queue.poll();
            q=queue.poll();
            if(p==null&&q==null)
                continue;
            else if ((p==null||q==null)||(p.val!=q.val))
                return false;
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
