package com.vitoboy.leetcode.tags.tree.btree;

import com.vitoboy.leetcode.pointoffer.TreeNode;

/**
 * 
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
 * 
 *  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
 * 一个节点也可以是它自己的祖先）。” 
 * 
 *  例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
 * 
 *
 *  示例 1:
 *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6 
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *  
 * 
 *  示例 2:
 *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
 * 
 *  
 * 
 *  说明:
 *  所有节点的值都是唯一的。 
 *  p、q 为不同节点且均存在于给定的二叉搜索树中。 
 *  
 *  Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
 *  👍 608 👎 0
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/28
 */
public class I235I_LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode right = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, left, right);
        I235I_LowestCommonAncestor ancestor = new I235I_LowestCommonAncestor();
        System.out.println(ancestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);

    }


    /**
     * 				解答成功:
     * 				执行耗时:11 ms,击败了13.16% 的Java用户
     * 				内存消耗:39.4 MB,击败了43.85% 的Java用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val) {
            if (existTreeNode(root, q)) {
                return p;
            } else {
                return null;
            }
        } else if (root.val == q.val) {
            if (existTreeNode(root, p)) {
                return root;
            } else {
                return null;
            }
        }
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node == null) {
            node =  lowestCommonAncestor(root.right, p, q);
        }
        if (node == null) {
            if( existTreeNode(root, p) && existTreeNode(root, q)) return root;
        }
        return node;
    }

    private boolean existTreeNode(TreeNode root, TreeNode target){
        if (root == null) return false;
        if (root.val == target.val) return true;
        return existTreeNode(root.left, target) || existTreeNode(root.right, target);
    }
}
