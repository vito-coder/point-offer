package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/7/2 12:12
 * @Version: 1.0
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 */
public class LV_MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(15);
        node.right = new TreeNode(7);
        root.right = node;

        LV_MaxDepth depth = new LV_MaxDepth();
        System.out.println(depth.maxDepth(root));
    }

    /**
     * 使用递归实现(相当于二叉树的后序遍历)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth + 1;
    }
}
