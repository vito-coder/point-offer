package com.vitoboy.leetcode.tags.tree;


import com.vitoboy.leetcode.common.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。 
 * 
 *  说明: 叶子节点是指没有子节点的节点。 
 * 
 *  示例: 
 * 
 *  输入:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
 *  Related Topics 树 深度优先搜索 字符串 二叉树 
 *  👍 522 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/29
 */
public class I257I_BinaryTreePaths {
    public static void main(String[] args) {
        I257I_BinaryTreePaths binaryTreePaths = new I257I_BinaryTreePaths();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(binaryTreePaths.binaryTreePathsII(root));

    }

    /**
     * 				解答成功:
     * 				执行耗时:12 ms,击败了17.65% 的Java用户
     * 				内存消耗:38.5 MB,击败了65.51% 的Java用户
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        String path = root.val + "->";
        if (root.left != null) {
            savePaths(path, root.left, list);
        }
        if (root.right != null) {
            savePaths(path, root.right, list);
        }
        return list;
    }

    private void savePaths(String pre, TreeNode node, List<String> list) {
        if (node.left == null && node.right == null) {
            list.add(pre + node.val);
        } else {
            pre = pre + node.val + "->";
            if (node.left != null) {
                savePaths(pre, node.left, list);
            }
            if (node.right != null) {
                savePaths(pre, node.right, list);
            }
        }
    }


    /**
     * 小优化
     *
     *
     * 				解答成功:
     * 				执行耗时:15 ms,击败了9.77% 的Java用户
     * 				内存消耗:38.5 MB,击败了76.38% 的Java用户
     *
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePathsII(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) {
            List<String> list = new ArrayList<>();
            list.add(root.val + "");
            return list;
        }
        List<String> list = new ArrayList<>();
        Map<TreeNode, String> dataMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        String path = root.val + "->";
        if (root.left != null) {
            stack.add(root.left);
            dataMap.put(root.left, path);
        }
        if (root.right != null) {
            stack.add(root.right);
            dataMap.put(root.right, path);
        }
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            String pre = dataMap.get(node);
            if (node.left == null && node.right == null) {
                list.add(pre + node.val);
            } else {
                pre = pre + node.val + "->";
                if (node.left != null) {
                    stack.add(node.left);
                    dataMap.put(node.left, pre);
                }
                if (node.right != null) {
                    stack.add(node.right);
                    dataMap.put(node.right, pre);
                }
            }
        }

        return list;
    }
}
