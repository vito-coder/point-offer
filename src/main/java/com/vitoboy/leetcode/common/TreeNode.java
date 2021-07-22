package com.vitoboy.leetcode.common;

/**
 * @Author: vito
 * @Date: 2020/6/18 22:48
 * @Version: 1.0
 *
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
