package com.vitoboy.leetcode.daily.jul;

import java.util.*;

/**
 * @problem leetcode
 * @description 1104.二叉树寻路
 * 
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
 * 
 *  如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
 * 
 *  而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *                                    1
 *                                 /    \
 *                               3        2
 *                             / \       / \
 *                            4  5      6   7
 *                          / \  / \   / \  / \
 *                        15 14 13 12 11 10 9 8
 *                        ....
 *
 *  给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
 *
 *  示例 1：
 *  输入：label = 14
 * 输出：[1,3,4,14]
 *  
 * 
 *  示例 2：
 *  输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 *  提示：
 *  1 <= label <= 10^6
 *  Related Topics 树 数学 二叉树 
 *  👍 94 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/29
 */
public class I210729I_I1104I_PathInZigZagTree {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(14));
        System.out.println(Integer.toBinaryString(4));
        System.out.println();
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(5));
        System.out.println("\n\n");
        I210729I_I1104I_PathInZigZagTree tree = new I210729I_I1104I_PathInZigZagTree();
        System.out.println(tree.pathInZigZagTree(14));
        System.out.println("expect is : [1,3,4,14]");
        System.out.println(tree.pathInZigZagTree(26));
        System.out.println("expect is : [1,2,6,10,26]");


    }

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了7.93% 的Java用户
     * 				内存消耗:36.4 MB,击败了6.61% 的Java用户
     *
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) return Arrays.asList(1);
        TreeMap<Integer, Integer> map = initMap();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(label);
        while (label > 3) {
            label = label >> 1;
            int key = map.floorKey(label);
            label = label ^ (key-1);
            list.addFirst(label);
        }
        list.addFirst(1);
        return list;
    }

    /**
     * 计算题目给定范围内, 二进制位确定下, 最小二进制对应的二进制少一位的最大值
     * 形如:  <k,v> -> (1000(2), 111(2))
     *
     * @return treeMap
     */
    private TreeMap<Integer, Integer> initMap(){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 1, max = 10000009;
        map.put(0, 0);
        while (i<max) {
            i = i << 1;
            map.put(i, i-1);
        }
        return map;
    }
}
