package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.pointoffer.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。 
 * 
 *  示例： 
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
 *
 *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
 *  👍 319 👎 0
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I404I_SunOfLeftLeaves {
    public static void main(String[] args) {
        I404I_SunOfLeftLeaves leftLeaves = new I404I_SunOfLeftLeaves();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(leftLeaves.sumOfLeftLeaves(root));
        System.out.println("expect is : 24");

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.2 MB,击败了50.12% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(1)
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        if (isLeave(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeave(TreeNode node) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
