package com.vitoboy.leetcode.pointoffer;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author: vito
 * @Date: 2020/6/30 19:18
 * @Version: 1.0
 *
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class XXXII_III_LevelOrder {
    public static void main(String[] args) {
        XXXII_III_LevelOrder levelOrder = new XXXII_III_LevelOrder();
        TreeNode node20 = new TreeNode(20);
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = node20;
        List list = levelOrder.leverOrderUpdate(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        /**
         *      1
         *     / \
         *    2   3
         *   /     \
         *  4      5
         */
//        TreeNode node = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        node.left = new TreeNode(2);
//        node.left.left = node4;
//        node.left.right = new TreeNode(44);
//        node3.right = new TreeNode(5);
//        node3.left = new TreeNode(55);
//        node.right = node3;
//
//        List list = levelOrder.leverOrderUpdate(node);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
    }

    /**
     * 使用队列打印每层树的结点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        if (root.left == null && root.right == null){
            levelList.add(root.val);
            totalList.add(levelList);
            return totalList;
        }
        Queue<TreeNode> uplevel = new LinkedList<>();
        List<TreeNode> downLevel = new ArrayList<>();
        uplevel.add(root);
        Stack<Integer> stack = new Stack<>();
        boolean path = true;
        while (!uplevel.isEmpty()) {
            TreeNode node = uplevel.poll();
            if (node != null) {
                if (path) {
                    levelList.add(node.val);
                } else {
                    stack.add(node.val);
                }
                if (node.left != null) downLevel.add(node.left);
                if (node.right != null) downLevel.add(node.right);
                if (uplevel.isEmpty()) {
                    uplevel.addAll(downLevel);
                    downLevel = new LinkedList<>();
                    if (path) {
                        totalList.add(levelList);
                    } else {
                        while (!stack.isEmpty()) {
                            levelList.add(stack.pop());
                        }
                        totalList.add(levelList);
                        stack = new Stack<>();
                    }
                    levelList = new ArrayList<>();
                    path = !path;
                }
            }
        }
        return totalList;
    }


    /**
     * 比上面的速度变快了, 上面用时比 6% java用户快
     * 下面代码用时, 比 38% java用户快
     * @param root
     * @return
     */
    public List<List<Integer>> leverOrderUpdate(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        if (root.left == null && root.right == null){
            levelList.add(root.val);
            totalList.add(levelList);
            return totalList;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> sort = new LinkedList<>();
        Stack<TreeNode> reverse = new Stack<>();
        nodes.add(root);
        boolean path = true;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {
                if (path) {
                    levelList.add(node.val);
                } else {
                    levelList.add(reverse.pop().val);
                }
                if (node.left != null) {
                    sort.add(node.left);
                    if (path) reverse.add(node.left);
                }
                if (node.right != null) {
                    sort.add(node.right);
                    if (path) reverse.add(node.right);
                }
                if (nodes.isEmpty()) {
                    nodes = sort;
                    sort = new LinkedList<>();
                    path = !path;
                    totalList.add(levelList);
                    levelList = new ArrayList<>();
                }
            }
        }
        return totalList;
    }


    /**
     * 比 99% java用户快
     * 1. 这里主要是对双端队列不熟悉, 即对LinkedList 不熟悉
     * 2. 二叉树的一些特性, 如, 累加的情况下, 单数层的节点数为单数, 偶数层为双数( 可以用到对2求余 )
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderOfficial(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
