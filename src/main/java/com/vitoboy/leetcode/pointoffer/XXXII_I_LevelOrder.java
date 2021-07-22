package com.vitoboy.leetcode.pointoffer;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author: vito
 * @Date: 2020/6/30 18:36
 * @Version: 1.0
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class XXXII_I_LevelOrder {
    public static void main(String[] args) {
        XXXII_I_LevelOrder levelOrder = new XXXII_I_LevelOrder();
        TreeNode node20 = new TreeNode(20);
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = node20;
        System.out.println(Arrays.toString(levelOrder.levelOrder(node)));

    }


    /**
     * 使用队列实现从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null ) return new int[0];
        if (root.right == null && root.left == null) return new int[]{root.val};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 测试用例里老是提示下标越界..., 改10000就好了
        int[] total = new int[10000];
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                total[count] = node.val;
                count++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return Arrays.copyOfRange(total, 0, count);
    }
}
