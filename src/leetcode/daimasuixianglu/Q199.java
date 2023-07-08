package leetcode.daimasuixianglu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lrd
 * @date 2023-07-08 19:27
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * 输入: []
 * 输出: []
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Q199 {
    List<Integer> ans=new ArrayList<>();
    Deque<TreeNode> list=new ArrayDeque<>();
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return ans;
    }
    void bfs(TreeNode root){
        if(root==null)
            return;
        list.offer(root);
        while (!list.isEmpty()){
            ans.add(list.peekLast().val);
            int cursize=list.size();
            for (int i = 0; i < cursize; i++) {
                TreeNode tmp=list.pollFirst();
                if(tmp.left!=null)
                    list.offer(tmp.left);
                if(tmp.right!=null)
                    list.offer(tmp.right);
            }
        }
    }
}
