package com.vitoboy.leetcode.daily.jul;

import java.util.*;

/**
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。 
 * 
 *  每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示： 
 *
 *  lefti 是第 i 座建筑物左边缘的 x 坐标。 
 *  righti 是第 i 座建筑物右边缘的 x 坐标。 
 *  heighti 是第 i 座建筑物的高度。 
 *  
 * 
 *  天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
 * 列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。 
 * 
 *  注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答
 * 案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...] 
 *
 *  示例 1：
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。 
 * 
 *  示例 2：
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 *
 *  提示：
 *  1 <= buildings.length <= 10^4
 *  0 <= lefti < righti <= 2^31 - 1
 *  1 <= heighti <= 2^31 - 1
 *  buildings 按 lefti 非递减排序 
 *  
 *  Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列） 
 *  👍 436 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/13
 */
public class I210713I_I218I_GetSkyline {
    public static void main(String[] args) {
        
    }

    class Node implements Comparable{
        int high;
        boolean begin;
        public Node(int _high, boolean _begin) {
            high = _high;
            begin = _begin;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return high == node.high &&
                    begin == node.begin;
        }

        @Override
        public int hashCode() {
            return Objects.hash(high, begin);
        }

        @Override
        public int compareTo(Object o) {
            if (o == this) return 0;
            Node node = (Node)o;
            if (high == node.high) {
                return 1;
            } else {
                if (begin) {
                    if (node.begin) return 0;
                    return 1;
                } else {
                    if (!node.begin) return 0;
                    return -1;
                }
            }
        }
    }

    /**
     * todo 重做
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 倒序<x, [start/end, high]>
        TreeMap<Integer, SortedSet<Node>> pointHighMap = new TreeMap<>(((o1, o2) -> {return o2-o1;}));
        // <x, high>
        TreeMap<Integer, Integer> beginMap = new TreeMap<>();
        TreeMap<Integer, Integer> endMap = new TreeMap<>();
        for (int[] building : buildings) {
            int high = building[2], begin = building[0], end = building[1];
            beginMap.put(begin, high);
            endMap.put(end, high);
            SortedSet<Node> beginSet = pointHighMap.getOrDefault(begin, new TreeSet<>());
            beginSet.add(new Node(high, true));
            SortedSet<Node> endSet = pointHighMap.getOrDefault(end, new TreeSet<>());
            endSet.add(new Node(end, false));
        }
        return calculateSkyLine(pointHighMap, beginMap, endMap);
    }

    private List<List<Integer>> calculateSkyLine(TreeMap<Integer, SortedSet<Node>> pointHighMap,
                                                 TreeMap<Integer, Integer> beginMap,
                                                 TreeMap<Integer, Integer> endMap) {
        List<List<Integer>> lists = new ArrayList<>();
        int maxHigh = 0;
        Node cur = null;
        for (Map.Entry<Integer, SortedSet<Node>> entry : pointHighMap.entrySet()) {
            int x = entry.getKey();
            SortedSet<Node> sortedSet = entry.getValue();
            if (lists.isEmpty()) {
                cur = sortedSet.first();
                sortedSet.remove(cur);
                maxHigh = Math.max(cur.high, maxHigh);
                lists.add(Arrays.asList(x, 0));
            } else {

            }
        }

        return lists;
    }

}
