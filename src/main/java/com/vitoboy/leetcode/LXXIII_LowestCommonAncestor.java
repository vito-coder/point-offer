package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/7/27 09:54
 * @Version: 1.0
 *
 *
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LXXIII_LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        node4.left = new TreeNode(3);
        node4.right = new TreeNode(5);
        node8.left = new TreeNode(7);
        node8.right = new TreeNode(9);
        node2.left = new TreeNode(0);
        node2.right = node4;
        root.left = node2;
        root.right = node8;

        LXXIII_LowestCommonAncestor commonAncestor = new LXXIII_LowestCommonAncestor();
        System.out.println(commonAncestor.lowestCommonAncestor(root, node2, node8).val);
        System.out.println(commonAncestor.lowestCommonAncestor(root, node2, node4).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. p , q < root
        // 2. p, q > root
        // 3. p > root > q || p< root < q
        if (p.val == root.val || q.val == root.val) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
