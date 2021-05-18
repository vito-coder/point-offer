package com.vitoboy.leetcode.daily;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
 * 
 *  如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
 * 
 *  我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
 * 
 *  只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
 * 
 *  
 * 
 *  示例 1： 
 *  
 * 
 *  
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *  
 * 
 *  示例 2： 
 *  
 * 
 *  
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 
 *  
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  二叉树的节点数介于 2 到 100 之间。 
 *  每个节点的值都是唯一的、范围为 1 到 100 的整数。 
 *  
 * 
 *  
 *  Related Topics 树 广度优先搜索 
 *  👍 185 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/17 下午5:42
 * @Version: 1.0
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class I210517I_I993IIsCousins {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, new TreeNode(4));
        TreeNode node3 = new TreeNode(3, null, new TreeNode(5));
        TreeNode node = new TreeNode(1, node2, node3);
        I210517I_I993IIsCousins isCousins = new I210517I_I993IIsCousins();
        System.out.println(isCousins.isCousins(node, 5, 4));

        TreeNode node4 = new TreeNode(4, new TreeNode(5), null);
        node3 = new TreeNode(3, null, node4);
        node = new TreeNode(1, new TreeNode(2, null, node3), null);
        System.out.println(isCousins.isCousins(node, 3, 4));

    }


    /**
     * 使用层序遍历
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了58.57% 的Java用户
     * 				内存消耗:35.9 MB,击败了92.16% 的Java用户
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int level = 0;
        int count = 1;
        while (count > 0 && nodeQueue.size() > 0) {
            level++;  // 层级
            TreeNode findX = null;  // x的父节点
            TreeNode findY = null;  // y的父节点
            for (int i = 0; i < count; i++) {
                TreeNode node = nodeQueue.poll();
                if (node == null) {
                    return false;
                }
                if (node.left != null) {
                    if (node.left.val == x) {
                        // 找到x的节点, 记录x的父节点
                        findX = node;
                    } else if (node.left.val == y) {
                        // 找到y的节点, 记录y的父节点
                        findY = node;
                    }
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        // 找到x的节点, 记录x的父节点
                        findX = node;
                    } else if (node.right.val == y) {
                        // 找到y的节点, 记录y的父节点
                        findY = node;
                    }
                    nodeQueue.add(node.right);
                }
                // x的父节点存在, y的父节点存在, 且 x和y的父节点不同, 且当前不是第一层时, 则找到堂兄节点
                if (findX != null && findY != null && findX != findY && level > 1) {
                    return true;
                }
            }
            count = nodeQueue.size();
        }
        return false;
    }


    /**
     * 处理时间在0ms
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousinsOnline(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        if(x==root.val||y==root.val){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = new TreeNode();
        TreeNode yParent = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isX = false;
            boolean isY = false;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    if(node.left.val==x){
                        xParent = node;
                    }
                    if(node.left.val==y){
                        yParent = node;
                    }
                }
                if(node.right!=null){
                    queue.add(node.right);
                    if(node.right.val==x){
                        xParent = node;
                    }
                    if(node.right.val==y){
                        yParent = node;
                    }
                }
                if(x==node.val){isX=true;}
                if(y==node.val){isY=true;}
            }
            if((isX && !isY) || (!isX&&isY)){
                return false;
            }
            if(isX && isY){
                break;
            }
        }
        if(xParent==yParent){
            return false;
        }
        return true;

    }




}
