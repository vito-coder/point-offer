package com.vitoboy.leetcode.daily.jul;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem leetcode
 * @description 863.二叉树中所有距离为K的结点
 * 
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
 * 
 *  返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
 *
 *  示例 1：
 *  输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *  提示：
 *  给定的树是非空的。 
 *  树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
 *  目标结点 target 是树上的结点。 
 *  0 <= K <= 1000. 
 *  
 *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
 *  👍 321 👎 0
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/28
 */
public class I210728I_I863I_DistanceK {
    public static void main(String[] args) {
        I210728I_I863I_DistanceK distance = new I210728I_I863I_DistanceK();
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode target = root.left;
//        System.out.println(distance.distanceK(root, target, 2));
//        System.out.println("expect is : [7,4,1]");
//        target = target.right.right;
//        System.out.println(distance.distanceK(root, target, 2));
//        System.out.println("expect is : [7,5]");
//        root = new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))));
        target = root.right;
        System.out.println(distance.distanceK(root, target, 2));
        System.out.println("expect is : [3]");
    }


    /**
     * 				解答成功:
     * 				执行耗时:13 ms,击败了99.66% 的Java用户
     * 				内存消耗:38.6 MB,击败了24.86% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     */
    int distance = -1;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        distance = -1;
        TreeNode node = findTarget(root, target.val, -1, k, list);
        addSubTreeNode(node.left,0, k, list);
        addSubTreeNode(node.right,0, k, list);
        return list;
    }

    /**
     * 查询目标节点距离root节点的距离
     * 同时, 查询
     * @param node          当前节点
     * @param target        目标节点值(题目说明是唯一值)
     * @param dist          当前节点距离root节点的距离
     * @param kDist         题目要求的距离目标节点的距离
     * @param list          返回集合
     * @return
     *      返回目标节点
     */
    private TreeNode findTarget(TreeNode node, int target, int dist, int kDist, List<Integer> list) {
        // 如果是空节点, 直接返回
        if (node == null) return null;
        // 更新当前节点距离root节点的距离
        ++dist;
        // 如果当前节点与目标节点值相等
        if (node.val == target) {
            // 记录目标节点距离root节点的距离
            distance = dist;
            if (kDist == 0) {
                list.add(node.val);
            }
            return node;
        } else {
            // 当前节点值与目标节点值不等, 递归搜索左节点
            TreeNode find = findTarget(node.left, target, dist,kDist, list);
            // 目标节点在左节占
            if (find != null) {
                // 计算当前节点与目标节点的距离
                int diff = distance - dist;
                // 满足题目要求, 记录到集合
                if (diff == kDist) {
                    list.add(node.val);
                } else if (diff < kDist) {
                    // 这里可以考虑当前节点的左节点即是目标节点时, 有:
                    //              cur
                    //              / \
                    //  (target)left   right
                    //  则: 右节点距离左节点的距离为: dist(cur,left)+dist(cur, right)
                    //  而:  dist(cur,left) = dist(root, cur.left) - dist(root, cur) = distance - dist
                    //  注: 父节点与root节点的距离 一定 小于 子节点与root节点的距离
                    //
                    // 距离小于题目要求的距离, 查询右子树上满足题目要求的节点
                    addDistanceValue(node.right, diff, kDist, list);
                }
            } else {
                // 同理, 如果目标节点不在左节点时, 查询右节点
                find = findTarget(node.right, target, dist, kDist, list);
                if (find != null) {
                    int diff = distance - dist;
                    if (diff == kDist) {
                        list.add(node.val);
                    } else if (diff < kDist) {
                        addDistanceValue(node.left, diff, kDist, list);
                    }
                }
            }
            return find;
        }
    }

    /**
     * 查询与目标节点相同的父节点的子节点距离目标节点的距离
     *                  parent(diff = dist(root, target) - dist(root, parent))
     *                 /      \
     *      child(diff+1)      ...
     *             /             \
     *  grandchild(diff+2)        target
     *
     * @param node          当前节点
     * @param diff          父亲节点距离目标节点的距离
     * @param kDist         题目要求的节点距离
     * @param list          满足要求的目标集合
     */
    private void addDistanceValue(TreeNode node, int diff, int kDist, List<Integer> list) {
        // 当前结点为空, 直接返回
        if(node == null) return;
        // 计算当前结点与目标结点的距离
        ++diff;
        // 如果当前结点与目标结点的距离与题目要求一致, 记录到集合中
        if (diff == kDist) {
            list.add(node.val);
        } else if (diff < kDist) {
            // 当前结点与目标结点的距离小于要求的距离, 分别计算当前结点的子结点是否满足要求
            if (node.left != null) {
                addDistanceValue(node.left, diff, kDist, list);
            }
            if (node.right != null) {
                addDistanceValue(node.right, diff, kDist, list);
            }
        }
    }

    /**
     * 计算目标结点的子结点距离目标结点的距离
     *
     * @param node      目标结点的子结点
     * @param dist      子结点的父结点距离目标结点的距离
     * @param kDist     要求的距离
     * @param list      满足条件的结点值的集合
     */
    private void addSubTreeNode(TreeNode node, int dist, int kDist, List<Integer> list) {
        // 当前结点为空, 直接返回
        if (node == null) return;
        // 计算当前结点距离目标结点的距离
        ++dist;
        // 距离满足, 则记录到集合中
        if (dist == kDist) {
            list.add(node.val);
        } else if (dist < kDist) {
            // 如果距离不足, 则计算孙子结点距离目标结点的距离
            addSubTreeNode(node.left, dist, kDist, list);
            addSubTreeNode(node.right, dist, kDist, list);
        }
        // 如果距离大于目标距离, 不处理
    }

}
