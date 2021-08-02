package com.vitoboy.leetcode.tags.tree;

import com.vitoboy.leetcode.common.TreeNode;

/**
 * @problem leetcode
 * @description 562.二叉树的坡度
 * 
 * 给定一个二叉树，计算 整个树 的坡度 。 
 * 
 *  一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一
 * 样。空结点的坡度是 0 。 
 * 
 *  整个树 的坡度就是其所有节点的坡度之和。 
 *
 *  示例 1：
 * 输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 *  
 * 
 *  示例 2：
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 1
 * 6 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 *  
 * 
 *  示例 3：
 * 输入：root = [21,7,14,1,1,2,2,3,3]
 * 输出：9
 *
 *  提示：
 *  树中节点数目的范围在 [0, 104] 内 
 *  -1000 <= Node.val <= 1000 
 *  
 *  Related Topics 树 深度优先搜索 二叉树 
 *  👍 140 👎 0
 *
 * @author vito
 * @version 1.0
 * @date 2021/8/2
 */
public class I563I_FindTilt {
    public static void main(String[] args) {
        I563I_FindTilt tilt = new I563I_FindTilt();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(tilt.findTilt(root));
        System.out.println("expect : 1");
        root = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, null, new TreeNode(7))
                );
        System.out.println(tilt.findTilt(root));
        System.out.println("expect is : 15");
        root = new TreeNode(21,
                new TreeNode(7, new TreeNode(1, new TreeNode(3), new TreeNode(3)), new TreeNode(1)),
                new TreeNode(14, new TreeNode(2), new TreeNode(2))
                );
        System.out.println(tilt.findTilt(root));
        System.out.println("expect is : 9");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了45.70% 的Java用户
     * 				内存消耗:39 MB,击败了5.05% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int left[] = dfsOfTreeTiltAndSum(root.left);
        int right[] = dfsOfTreeTiltAndSum(root.right);
        return Math.abs(left[0]-right[0])+left[1]+right[1];
    }

    int[] dfsOfTreeTiltAndSum(TreeNode node) {
        if (node == null) return new int[2];
        if (node.left == null && node.right == null) return new int[]{node.val, 0};
        int left[] = dfsOfTreeTiltAndSum(node.left);
        int right[] = dfsOfTreeTiltAndSum(node.right);
        int [] ans = new int[]{left[0]+right[0]+node.val, Math.abs(left[0]-right[0])+left[1]+right[1]};
        return ans;
    }
}
