package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.*;

/**
 * 
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
 * 
 *  假定 BST 有如下定义：
 *  结点左子树中所含结点的值小于等于当前结点的值 
 *  结点右子树中所含结点的值大于等于当前结点的值 
 *  左子树和右子树都是二叉搜索树 
 *  
 * 
 *  例如： 
 * 给定 BST [1,null,2,2], 
 * 
 *     1
 *     \
 *      2
 *     /
 *    2
 *  返回[2].
 *  提示：如果众数超过1个，不需考虑输出顺序 
 * 
 *  进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
 *  Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
 *  👍 321 👎 0
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/8
 */
public class I501I_FindMode {
    public static void main(String[] args) {
        I501I_FindMode mode = new I501I_FindMode();
        TreeNode root = new TreeNode(1, null, new TreeNode(2,new TreeNode(2), null));
        System.out.println(Arrays.toString(mode.findMode(root)));
        System.out.println("expect is : [2]");
        root.left = new TreeNode(1);
        System.out.println(Arrays.toString(mode.findMode(root)));
        System.out.println("expect is : [1,2]");
    }

    /**
     * 考虑一下, 使用中序遍历, 为什么是考虑中序遍历?
     *
     * @param root
     * @return
     */
    public int[] findModeII(TreeNode root) {

        return null;
    }


    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了19.82% 的Java用户
     * 				内存消耗:40 MB,击败了17.63% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{root.val};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(root.val, 1);
        countElement(root.left, map);
        countElement(root.right, map);
        List<Integer> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>(map.values());
        count.sort((o1, o2) -> {return o1-o2;});
        int max = count.get(count.size()-1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        if (!list.isEmpty()) {
            int[] ans = new int[list.size()];
            for (int i = 0, len = list.size(); i < len; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
        return new int[0];
    }


    private void countElement(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        countElement(node.left, map);
        countElement(node.right, map);
    }
}
