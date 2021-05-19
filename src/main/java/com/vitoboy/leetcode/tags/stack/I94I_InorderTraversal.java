package com.vitoboy.leetcode.tags.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
 *
 *  示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *  
 * 
 *  示例 2：
 * 输入：root = []
 * 输出：[]
 *  
 * 
 *  示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *  
 * 
 *  示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 *  
 * 
 *  示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *  提示：
 *
 *  树中节点数目在范围 [0, 100] 内 
 *  -100 <= Node.val <= 100
 * 
 *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
 *  Related Topics 栈 树 哈希表 
 *  👍 955 👎 0
 * 
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/19 下午11:31
 * @Version: 1.0
 */
public class I94I_InorderTraversal {
    public static void main(String[] args) {

    }

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<Integer>(1);
            list.add(root.val);
            return list;
        }
        List<Integer> list = new ArrayList<Integer>();
        ergodic(root.left, list);
        list.add(root.val);
        ergodic(root.right, list);
        return list;
    }

    public void ergodic(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if (root.left != null) {
            ergodic(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            ergodic(root.right, list);
        }
    }
}
