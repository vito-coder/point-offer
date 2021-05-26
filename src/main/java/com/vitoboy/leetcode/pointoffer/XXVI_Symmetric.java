package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/6/30 01:18
 * @Version: 1.0
 *
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class XXVI_Symmetric {

    public static void main(String[] args) {
        XXVI_Symmetric symmetric = new XXVI_Symmetric();
        TreeNode node = new TreeNode(1);
        TreeNode noder2 = new TreeNode(1);
        TreeNode nodel2 = new TreeNode(1);
        noder2.right = new TreeNode(3);
        noder2.left = new TreeNode(4);
        nodel2.right = new TreeNode(4);
        nodel2.left = new TreeNode(3);
        node.left = nodel2;
        node.right = noder2;


        System.out.println(symmetric.isSymmetric(new TreeNode(1)));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mirrorCheckTree(root.left, root.right);
    }

    public boolean mirrorCheckTree(TreeNode left, TreeNode right) {
        if (left == null && right == null ) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return mirrorCheckTree(left.left, right.right) && mirrorCheckTree(left.right, right.left);
    }
}
