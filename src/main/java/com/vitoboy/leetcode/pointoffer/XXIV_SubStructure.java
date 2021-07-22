package com.vitoboy.leetcode.pointoffer;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * @Author: vito
 * @Date: 2020/6/29 23:48
 * @Version: 1.0
 *
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 */
public class XXIV_SubStructure {

    public static void main(String[] args) {
        XXIV_SubStructure subStructure = new XXIV_SubStructure();
        subStructure.isSubStructure(null, null);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B!=null) && (recov(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recov(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recov(A.left, B.left) && recov(A.right, B.right);
    }
}
