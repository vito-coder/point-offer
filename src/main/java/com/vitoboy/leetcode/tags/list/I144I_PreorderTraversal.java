package com.vitoboy.leetcode.tags.list;

import com.vitoboy.leetcode.pointoffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * 输出：[1,2]
 *  
 * 
 *  示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 *  提示：
 *  树中节点数目在范围 [0, 100] 内 
 *  -100 <= Node.val <= 100 
 *  
 * 
 *  
 * 
 *  进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
 *  Related Topics 栈 树 
 *  👍 578 👎 0
 *
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/11
 */
public class I144I_PreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了48.44% 的Java用户
     * 				内存消耗:36.6 MB,击败了73.46% 的Java用户
     * 			
     * 	迭代法/广度优先
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            list.add(node.val);
            if (node.right != null) {
                nodes.addFirst(node.right);
            }
            if (node.left != null) {
                nodes.addFirst(node.left);
            }
        }
        return list;
    }
    
    
}
