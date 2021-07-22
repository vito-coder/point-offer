package com.vitoboy.leetcode.pointoffer;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * @Author: vito
 * @Date: 2020/7/2 12:48
 * @Version: 1.0
 *
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 *
 */
public class LV_II_BalancedTree {
    public static void main(String[] args) {
        // todo
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        // todo
        return false;
    }
}
