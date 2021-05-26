package com.vitoboy.leetcode.pointoffer;

import java.util.*;

/**
 * @Author: vito
 * @Date: 2020/6/30 19:18
 * @Version: 1.0
 *
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class XXXI_LevelOrder {
    public static void main(String[] args) {
        XXXI_LevelOrder levelOrder = new XXXI_LevelOrder();
        TreeNode node20 = new TreeNode(20);
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = node20;
        List list = levelOrder.levelOrder(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    /**
     * 使用队列打印每层树的结点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null){
            List<List<Integer>> lists = new LinkedList<>();
            List<Integer> level = new LinkedList<>();
            level.add(root.val);
            lists.add(level);
            return lists;
        }
        Queue<TreeNode> uplevel = new LinkedList<>();
        Queue<TreeNode> downLevel = new LinkedList<>();
        uplevel.add(root);
        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        while (!uplevel.isEmpty()) {
            TreeNode node = uplevel.poll();
            if (node != null) {
                levelList.add(node.val);
                if (node.left != null) downLevel.add(node.left);
                if (node.right != null) downLevel.add(node.right);
                if (uplevel.isEmpty()) {
                    uplevel = downLevel;
                    downLevel = new LinkedList<>();
                    totalList.add(levelList);
                    levelList = new ArrayList<>();
                }
            }
        }
        return totalList;
    }
}
