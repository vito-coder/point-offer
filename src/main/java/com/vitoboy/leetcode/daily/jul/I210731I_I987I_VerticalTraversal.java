package com.vitoboy.leetcode.daily.jul;

import com.vitoboy.leetcode.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @problem leetcode
 * @description 987.二叉树的垂序遍历
 * 
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。 
 * 
 *  对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的
 * 根结点位于 (0, 0) 。 
 * 
 *  二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则
 * 按结点的值从小到大进行排序。 
 * 
 *  返回二叉树的 垂序遍历 序列。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。 
 * 
 *  示例 2：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 *           1 在上面，所以它出现在前面。
 *           5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *  
 * 
 *  示例 3：
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。 
 *
 *  提示：
 *  树中结点数目总数在范围 [1, 1000] 内 
 *  0 <= Node.val <= 1000 
 *  
 *  Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
 *  👍 150 👎 0
 *
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/31
 */
public class I210731I_I987I_VerticalTraversal {
    public static void main(String[] args) {
        I210731I_I987I_VerticalTraversal traversal = new I210731I_I987I_VerticalTraversal();
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(traversal.verticalTraversal(root));
        System.out.println("expect is : [[9],[3,15],[20],[7]]");

    }

    class TmpNode implements Comparable<TmpNode>{
        int level;
        int index;
        int val;
        TreeNode node;
        public TmpNode(){};

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(TmpNode o) {
            if (this.level < o.level){
                return -1;
            } else if (this.level > o.level) {
                return 1;
            } else {
                return Integer.compare(this.val, o.val);
            }
        }
    }

    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了50.15% 的Java用户
     * 				内存消耗:38.8 MB,击败了22.29% 的Java用户
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<TmpNode>> map = new HashMap<>();
        TmpNode node = creatNode(root, 0, 0);
        List<TmpNode> zeroList = new ArrayList<>();
        zeroList.add(node);
        map.put(0, zeroList);
        dfs(root.left, -1, 1, map);
        dfs(root.right, 1, 1, map);
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(((o1, o2) -> {return o1-o2;}));
        for (Integer key : keyList) {
            List<TmpNode> list = map.get(key);
            Collections.sort(list);
            ans.add(list.stream().map(TmpNode::getVal).collect(Collectors.toList()));
        }
        return ans;
    }


    private void dfs(TreeNode node, int drict, int level, Map<Integer, List<TmpNode>> map) {
        if (node == null) return;
        List<TmpNode> list = map.getOrDefault(drict, new ArrayList<>());
        list.add(creatNode(node, drict, level));
        map.put(drict, list);
        dfs(node.left, drict-1, level+1, map);
        dfs(node.right, drict+1, level+1, map);
    }

    private TmpNode creatNode(TreeNode node, int index, int level){
        TmpNode tmpNode = new TmpNode();
        tmpNode.node = node;
        tmpNode.level = level;
        tmpNode.index = index;
        tmpNode.val = node.val;
        return tmpNode;
    }
}
