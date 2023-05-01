package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-05-01 8:20
 * 958. 二叉树的完全性检验
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2h 节点之间的最后一级 h 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * 提示：
 * 树的结点数在范围  [1, 100] 内。
 * 1 <= Node.val <= 1000
 */
class TreeNode {
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
class ANode {  // Annotated Node
    TreeNode node;
    int code;
    ANode(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}

public class Q958 {
    @Leetcode("BFS")
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i-1).code == nodes.size();
    }

}
