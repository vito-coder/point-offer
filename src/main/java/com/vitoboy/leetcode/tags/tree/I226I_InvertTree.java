package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.pointoffer.TreeNode;

import java.util.Arrays;

/**
 * 
 * 翻转一棵二叉树。 
 * 
 *  示例： 
 * 
 *  输入： 
 * 
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9 
 * 
 *  输出： 
 * 
 *       4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1 
 * 
 *  备注: 
 * 这个问题是受到 Max Howell 的 原问题 启发的 ： 
 * 
 *  谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
 *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
 *  👍 896 👎 0
 *
 *
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/25
 */
public class I226I_InvertTree {
    public static void main(String[] args) {

    }



    /**
     * 递归实现
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36 MB,击败了20.57% 的Java用户
     * 			
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
