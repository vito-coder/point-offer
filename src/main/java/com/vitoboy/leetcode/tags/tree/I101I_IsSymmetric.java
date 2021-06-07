package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.pointoffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。 
 * 
 *  
 * 
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
 * 
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 *  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
 * 
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 *  进阶： 
 * 
 *  你可以运用递归和迭代两种方法解决这个问题吗？ 
 *  Related Topics 树 深度优先搜索 广度优先搜索 
 *  👍 1402 👎 0
 *
 *
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/2
 */
public class I101I_IsSymmetric {
    public static void main(String[] args) {
        I101I_IsSymmetric symmetric = new I101I_IsSymmetric();
        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(2, null, new TreeNode(3));
        System.out.println(symmetric.isSymmetric(new TreeNode(1, left, right)));

    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了28.23% 的Java用户
     * 				内存消耗:37.7 MB,击败了15.35% 的Java用户
     *
     * 自己实现
     * 时间复杂度: O(N) 需要遍历一遍所有节点
     * 空间复杂度: O(log2N) 最多需要保存所有叶子节点的变量
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        TreeNode left, right;
        while (!queue.isEmpty()) {
            left = queue.remove();
            right = queue.remove();
            if (left == null && right == null) continue;
            if ((left == null || right == null) || (left.val != right.val)) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
