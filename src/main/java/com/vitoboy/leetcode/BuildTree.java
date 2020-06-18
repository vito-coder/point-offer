package com.vitoboy.leetcode;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/6/18 22:52
 * @Version: 1.0
 *
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class BuildTree {
    public static void main(String[] args) {

    }

    /**
     * 使用递归实现
     *
     * 重建一个二叉树, 有几个条件
     * 1.知道前, 中序遍历
     * 2.中序遍历的结果去掉根结点后的左右两部分, 分别是左子树的中序遍历和右子树的中序遍历
     * 3.前序遍历去掉根结点后, 剩下部分也可以分成两部分, 第一部分与中序遍历去掉根结点的左部分长度一致, 第二部分与中序遍历去掉根结点的右部分长度一致
     * 4.前序遍历去掉根结点后, 第一部分是左子树, 第二部分是右子树
     * 5.也就是说前序遍历和中序遍历同时去掉根结点后, 剩下的两部分又分别组成左子树的前序遍历和中序遍历, 和右子树的的前序遍历和中序遍历
     *
     * 根据上面的规律, 可以找到重建二叉树的思路
     *
     * @param preorder  前序遍历的结果
     * @param inorder   中序遍历的结果
     * @return
     *  重建成功的二叉树
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length == 1 || inorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == node.val) {
                int[] leftPreorder = Arrays.copyOfRange(preorder, 1, i+1);
                int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
                int[] rightInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
                int[] rightPreorder = Arrays.copyOfRange(preorder, i+1, preorder.length);
                node.left = buildTree(leftPreorder, leftInorder);
                node.right = buildTree(rightPreorder, rightInorder);
                return node;
            }
        }
        return node;
    }
}
