package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
 *
 *  示例 : 
 * 给定二叉树 
 * 
 *            1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 *
 *  返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
 *
 *  注意：两结点之间的路径长度是以它们之间边的数目表示。 
 *  Related Topics 树 深度优先搜索 二叉树 
 *  👍 739 👎 0
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/12
 */
public class I543I_DiameterOfBinaryTree {
    public static void main(String[] args) {
        I543I_DiameterOfBinaryTree tree = new I543I_DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(tree.diameterOfBinaryTree(root));
        System.out.println("expect is : 3");

    }

    /**
     *
     * 这个算法不好, 太浪费空间与时间
     *
     * 				解答成功:
     * 				执行耗时:17 ms,击败了8.38% 的Java用户
     * 				内存消耗:38.2 MB,击败了76.11% 的Java用户
     *
     * 时间复杂度: O(?)
     * 空间复杂度: O(?)
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int deep = 0;
        if (root.left != null) deep += (deepOfTree(root.left) + 1);
        if (root.right != null) deep += (deepOfTree(root.right)+1);
        return Math.max(deep, Math.max(left, right));
    }

    private int deepOfTree(TreeNode root) {
        if (root == null ||(root.left == null && root.right == null)) return 0;
        else return Math.max(deepOfTree(root.left), deepOfTree(root.right)) + 1;
    }
}
