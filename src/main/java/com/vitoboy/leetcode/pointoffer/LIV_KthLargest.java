package com.vitoboy.leetcode;

import java.util.LinkedList;

/**
 * @Author: vito
 * @Date: 2020/7/2 11:55
 * @Version: 1.0
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class LIV_KthLargest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        node3.right = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node3.left = node2;
        root.left = node3;

        LIV_KthLargest largest = new LIV_KthLargest();
        System.out.println(largest.kthLargest(root, 3));
    }

    public int kthLargest(TreeNode root, int k) {
        if (root == null|| k == 0) return 0;
        LinkedList<Integer> list = new LinkedList<>();
        addNode(root, k, list);
        return list.peekLast();
    }

    public void addNode(TreeNode root, int k, LinkedList<Integer> list) {
        if (root == null) return;
        if (list.size() >= k) return;
        if (root.right == null && root.left == null) {
            list.add(root.val);
            return;
        }
        if (root.right != null) addNode(root.right, k, list);
        int len = list.size();
        if (len >= k) return;
        list.add(root.val);
        if (len+1 >= k) return;
        if (root.left != null) addNode(root.left, k, list);
    }
}
