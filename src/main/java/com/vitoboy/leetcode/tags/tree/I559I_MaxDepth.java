package com.vitoboy.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @problem leetcode
 * @description 559.N叉树的最大深度
 * 
 * 给定一个 N 叉树，找到其最大深度。 
 * 
 *  最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
 * 
 *  N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
 *
 *  示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *  
 * 
 *  示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
 * null,13,null,null,14]
 * 输出：5
 *
 *  提示：
 *  树的深度不会超过 1000 。 
 *  树的节点数目位于 [0, 104] 之间。 
 *  
 *  Related Topics 树 深度优先搜索 广度优先搜索 
 *  👍 179 👎 0
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/23
 */
public class I559I_MaxDepth {
    public static void main(String[] args) {
        
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了31.87% 的Java用户
     * 				内存消耗:38.1 MB,击败了96.28% 的Java用户
     *
     * 时间复杂度: O(N);
     * 空间复杂度: O(logN)
     *
     *
     * 迭代法
     *
     * @param root
     * @return
     */
    public int maxDepthIteration(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;
        Stack<List<Node>> stack = new Stack<>();
        int count = 0;
        stack.add(root.children);
        while (stack.size() > 0) {
            count++;
            List<Node> childs = stack.pop();
            List<Node> tmp = new ArrayList<>();
            for (Node child : childs) {
                if (child.children != null) {
                    tmp.addAll(child.children);
                }
            }
            if (tmp.size() > 0) {
                stack.add(tmp);
            }
        }
        return count;
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.1 MB,击败了97.82% 的Java用户
     *
     * 递归实现
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(maxDepth(child), max);
        }
        return max+1;
    }
}
