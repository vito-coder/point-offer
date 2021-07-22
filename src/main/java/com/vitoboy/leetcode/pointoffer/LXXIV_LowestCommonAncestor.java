package com.vitoboy.leetcode.pointoffer;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/7/28 12:49
 * @Version: 1.0
 * <p>
 * 面试题68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LXXIV_LowestCommonAncestor {
    public static void main(String[] args) {
        LXXIV_LowestCommonAncestor commonAncestor = new LXXIV_LowestCommonAncestor();
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(8);
        node2.left = new TreeNode(7);
        node2.right = new TreeNode(4);
        node5.right = node2;
        node5.left = new TreeNode(6);
        root.left = node5;
        root.right = node1;

        System.out.println(commonAncestor.lowestCommonAncestor(root, node5, node1).val);
    }

    public TreeNode lowestCommonAncestorBySelf(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val == q.val) return p;
        if (p.val == root.val) {
            if (findSubNode(root, q)) return root;
        } else if (q.val == root.val) {
            if (findSubNode(root, p)) return root;
        }
        if ((root.left.val == p.val && root.right.val == q.val) ||
                (root.left.val == q.val && root.right.val == p.val)) return root;
        TreeNode node = lowestCommonAncestor(root.right, p, q);
        if (node != null) return node;
        node = lowestCommonAncestor(root.left, p, q);
        if (node != null) return node;
        return root;

    }

    public boolean findSubNode(TreeNode root, TreeNode target) {
        if (root.val == target.val) return true;
        boolean find = false;
        if (root.right != null) find = findSubNode(root.right, target);
        if (!find && root.left != null) find = findSubNode(root.left, target);
        return find;
    }


    /**
     * 递归解析：
     * 
     * 终止条件：
     * 当越过叶节点，则直接返回 null ；
     * 当 root 等于 p, qp,q ，则直接返回 root ；
     * 
     * 递推工作：
     * 开启递归左子节点，返回值记为 left ；
     * 开启递归右子节点，返回值记为 right ；
     * 
     * 返回值： 根据 left 和 right ，可展开为四种情况；
     * 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 当 left 和 right 同时不为空 ：说明 p, qp,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     * 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     * p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     * p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
