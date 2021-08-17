package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @problem leetcode
 * @description 572.另一棵树的子树
 *
 *  给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
 * ，返回 false 。 
 * 
 *  二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
 *
 *  示例 1：
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *
 *  提示：
 *  root 树上的节点数量范围是 [1, 2000] 
 *  subRoot 树上的节点数量范围是 [1, 1000] 
 *  -104 <= root.val <= 104 
 *  -104 <= subRoot.val <= 104 
 *
 *  Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
 *  👍 534 👎 0
 *
 *
 * @author vito
 * @version 1.0
 * @date 2021/8/2
 */
public class I572I_IsSubtree {

    public static void main(String[] args) {
        I572I_IsSubtree subtree = new I572I_IsSubtree();
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode sub = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(subtree.isSubtree(root, sub));
        System.out.println("expect is : true");
        root = new TreeNode(3, new TreeNode(4, new TreeNode(1), null), new TreeNode(5, new TreeNode(2), null));
        sub = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(subtree.isSubtree(root, sub));
        System.out.println("expect is : false");
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            if (subRoot == null) return true;
            return false;
        }
        boolean ans = false;
        if (root.val == subRoot.val) {
            ans = isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
            if (ans) return true;
        }
        ans = dfs(root.left, subRoot);
        if (ans) return true;
        return dfs(root.right, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean ans = false;
        if (root.val == subRoot.val) {
            ans = isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
            if (ans) return true;
        }
        ans = dfs(root.left, subRoot);
        if (ans) return ans;
        return dfs(root.right, subRoot);
    }
    
    
}
