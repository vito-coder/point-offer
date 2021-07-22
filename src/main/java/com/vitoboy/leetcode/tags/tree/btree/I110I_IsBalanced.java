package com.vitoboy.leetcode.tags.tree.btree;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。 
 * 
 *  本题中，一棵高度平衡二叉树定义为： 
 * 
 *  
 *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
 *  
 *
 *  示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *  
 * 
 *  示例 3：
 * 输入：root = []
 * 输出：true
 *  
 *
 *  提示：
 *  树中的节点数在范围 [0, 5000] 内 
 *  -104 <= Node.val <= 104 
 *  
 *  Related Topics 树 深度优先搜索 递归 
 *  👍 704 👎 0
 *
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/11
 */
public class I110I_IsBalanced {
    public static void main(String[] args) {

    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.99% 的Java用户
     * 				内存消耗:38.5 MB,击败了57.36% 的Java用户
     *
     * 计算树的高度少算了当前层
     * 时间复杂度: O(N^2) 需要两遍历, 一遍算深度, 一遍算是否为平衡二叉树
     * 空间复杂度: O(H) 需要树的高度
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int left = deepth(root.left);
        int right = deepth(root.right);
        if (left == right || Math.abs(left-right) < 2) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int deepth(TreeNode node) {
        if (node == null ) return 0;
        if((node.left == null && node.right == null)) return 1;
        return Math.max(deepth(node.left), deepth(node.right)) + 1;
    }
}
