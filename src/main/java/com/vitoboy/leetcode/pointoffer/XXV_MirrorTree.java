package com.vitoboy.leetcode.pointoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/6/30 01:00
 * @Version: 1.0
 *
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class XXV_MirrorTree {

    public static void main(String[] args) {
        XXV_MirrorTree mirrorTree = new XXV_MirrorTree();

        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        node7.left = new TreeNode(6);
        node7.right = new TreeNode(9);
        TreeNode node = new TreeNode(4);
        node.left = node2;
        node.right = node7;

        TreeNode mirNode = mirrorTree.mirrorTree(node);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(mirNode);
        while (queue.size() > 0) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }



    }

    /**
     * 递归实现 二叉树的镜像
     *
     * @param root      树的根结点
     * @return
     *  镜像二叉树
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode mirLeft = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = mirLeft;
        return root;
    }
}
