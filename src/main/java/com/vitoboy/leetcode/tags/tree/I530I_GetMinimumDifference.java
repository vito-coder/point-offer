package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
 *
 *  示例： 
 * 
 *  输入：
 * 
 *    1
 *     \
 *      3
 *     /
 *    2
 * 
 * 输出：1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *  提示：
 *  树中至少有 2 个节点。 
 *  本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
 * 相同 
 *  
 *  Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 
 *  👍 259 👎 0
 *
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/12
 */
public class I530I_GetMinimumDifference {
    public static void main(String[] args) {
        I530I_GetMinimumDifference difference = new I530I_GetMinimumDifference();
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(difference.getMinimumDifference(root));
        difference = new I530I_GetMinimumDifference();
        root = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        System.out.println(difference.getMinimumDifference(root));
        root = new TreeNode(543, new TreeNode(384, null, new TreeNode(445)), new TreeNode(652, null, new TreeNode(699)));
        System.out.println(difference.getMinimumDifference(root));
    }

    Integer last = null;
    Integer min = null;

    /**
     * 中序遍历 + 判断差值
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了72.88% 的Java用户
     * 				内存消耗:38.1 MB,击败了59.19% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        last = null; min = Integer.MAX_VALUE;
        midSearch(root.left);
        if (last == null) last = root.val;
        else {
            min = Math.min(min, Math.abs(last-root.val));
            last = root.val;
        }
        midSearch(root.right);
        return min;
    }

    private void midSearch(TreeNode node) {
        if (node == null) return;
        midSearch(node.left);
        if (last == null) last = node.val;
        else {
            min = Math.min(min, Math.abs(last-node.val));
            last = node.val;
        }
        midSearch(node.right);
    }
}
