package com.vitoboy.leetcode.daily.jul;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @problem leetcode
 * @description 671.二叉树中第二小的节点
 * 
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
 * 个。 
 * 
 *  更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
 * 
 *  给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 *  
 * 
 *  示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 *  提示：
 *  树中节点数目在范围 [1, 25] 内 
 *  1 <= Node.val <= 231 - 1 
 *  对于树中每个节点 root.val == min(root.left.val, root.right.val) 
 *  
 *  Related Topics 树 深度优先搜索 二叉树 
 *  👍 171 👎 0
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/27
 */
public class I210727I_I671I_FindSecondMinimumValue {
    public static void main(String[] args) {
        I210727I_I671I_FindSecondMinimumValue minimumValue = new I210727I_I671I_FindSecondMinimumValue();
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(minimumValue.findSecondMinimumValue(root));
        System.out.println("expect is : 5");
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.7 MB,击败了48.58% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(NlogN)
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int min = Integer.MAX_VALUE, secondMin = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (min == Integer.MAX_VALUE) {
                min = cur.val;
            } else if(cur.val > min){
                if (secondMin == -1) {
                    secondMin = cur.val;
                } else {
                    secondMin = Math.min(secondMin, cur.val);
                }
            } else if (cur.val < min) {
                secondMin = min;
                min = cur.val;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return secondMin;
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.8 MB,击败了32.64% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     */
    int min = Integer.MAX_VALUE;
    int secondMin = -1;
    public int findSecondMinimumValueDeepSearch(TreeNode root) {
        if (root == null || root.left == null) return -1;
        min = Integer.MAX_VALUE;
        secondMin = -1;
        deepSearch(root);
        return secondMin;
    }

    private void deepSearch(TreeNode root) {
        if (root == null) return;
        if (min == Integer.MAX_VALUE){
            min = root.val;
        } else if(root.val > min){
            if (secondMin == -1) {
                secondMin = root.val;
            } else {
                secondMin = Math.min(secondMin, root.val);
            }
        } else if (root.val < min) {
            secondMin = min;
            min = root.val;
        }
        deepSearch(root.left);
        deepSearch(root.right);
    }
}
