package com.vitoboy.leetcode.daily.aug;

import java.util.*;

/**
 * @problem leetcode
 * @description 访问所有节点的最短路径
 *
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。 
 * 
 *  给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。 
 * 
 *  返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。 
 *
 *  示例 1：
 *              0
 *            / | \
 *           1  2  3
 * 输入：graph = [[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一种可能的路径为 [1,0,2,0,3] 
 * 
 *  示例 2：
 *            2 -- 1 -- 0
 *            | \  |
 *            |  \|
 *            3   4
 * 输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一种可能的路径为 [0,1,4,2,3]
 *
 *  提示：
 *  n == graph.length 
 *  1 <= n <= 12 
 *  0 <= graph[i].length < n 
 *  graph[i] 不包含 i 
 *  如果 graph[a] 包含 b ，那么 graph[b] 也包含 a 
 *  输入的图总是连通图 
 *  
 *  Related Topics 位运算 广度优先搜索 图 动态规划 状态压缩 
 *  👍 161 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/6
 */
public class I210806I_I847I_ShortestPathLength {
    public static void main(String[] args) {
        I210806I_I847I_ShortestPathLength pathLength = new I210806I_I847I_ShortestPathLength();
        int[][] graph = new int[][]{{1,2,3},{0},{0},{0}};
        System.out.println(pathLength.shortestPathLength(graph));
        System.out.println("expect is : 4");
        graph = new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(pathLength.shortestPathLength(graph));
        System.out.println("expect is : 4");
    }

    /**
     * graph[i] 不包含 i
     * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
     *
     * todo
     *
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {

        return 0;
    }

    public int shortestPathLengthTLEII(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<String> pathRecord = new HashSet<>();
        List<Integer> start = new ArrayList<>();
        List<Integer> allNode = new ArrayList<>();
        int len = graph.length;
        for (int i = 0; i < len ; i++) {
            if (graph[i].length == 1) {
                start.add(i);
            }
            map.put(i, graph[i]);
            allNode.add(i);
        }
        int ans = Integer.MAX_VALUE;
        // 万一 start 长度为零呢, 即是一个环型图, 每个节点最少有两条边...
        // 那这个方法一定通不过
        for (Integer integer : start) {
            Set<Integer> set = new HashSet<>(allNode);
            int count = dfsPath(integer, 0, set, map, pathRecord);
            ans = Math.min(ans, count);
        }
        return ans-1;
    }


    private int dfsPath(int start, int count, Set<Integer> allNode, Map<Integer, int[]> map, Set<String> pathRecord) {
        if (count >= 2*map.size()) return count;
        if (allNode.size() == 0) return count;
        count++;
        int tmp = Integer.MAX_VALUE;
        allNode.remove(start);
        int[] childNode = map.get(start);
        for (int i = 0; i < childNode.length; i++) {
            Set<Integer> tmpSet = new HashSet<>(allNode);
            Set<String> record = new HashSet<>(pathRecord);
            String path = start + "->" + childNode[i];
            if (record.contains(path)) {
                continue;
            } else {
                record.add(path);
            }
            tmp = Math.min(dfsPath(childNode[i], count, tmpSet, map, record), tmp);
        }
        return tmp;
    }





    public int shortestPathLengthTLE(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        List<Integer> start = new ArrayList<>();
        List<Integer> allNode = new ArrayList<>();
        int len = graph.length;
        for (int i = 0; i < len ; i++) {
            if (graph[i].length == 1) {
                start.add(i);
            }
            map.put(i, graph[i]);
            allNode.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (Integer integer : start) {
            Set<Integer> set = new HashSet<>(allNode);
            int count = dfs(integer, 0, set, map);
            ans = Math.min(ans, count);
        }
        return ans-1;
    }

    private int dfs(int start, int count, Set<Integer> allNode, Map<Integer, int[]> map) {
        if (count >= 2*map.size()) return count;
        if (allNode.size() == 0) return count;
        count++;
        int tmp = Integer.MAX_VALUE;
        allNode.remove(start);
        int[] childNode = map.get(start);
        for (int i = 0; i < childNode.length; i++) {
            Set<Integer> tmpSet = new HashSet<>(allNode);
            tmp = Math.min(dfs(childNode[i], count, tmpSet, map), tmp);
        }
        return tmp;
    }
}
