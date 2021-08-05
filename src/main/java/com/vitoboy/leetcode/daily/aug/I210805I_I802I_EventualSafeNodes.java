package com.vitoboy.leetcode.daily.aug;

import java.util.*;

/**
 * @problem leetcode
 * @description 802.找到最终的安全状态
 * 
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。 
 * 
 *  对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。 
 * 
 *  返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
 * 
 *  该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
 * 满足 (i, j) 是图的一条有向边。 
 *
 *  示例 1：
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 *  
 * 
 *  示例 2：
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 *
 *  提示：
 *  n == graph.length 
 *  1 <= n <= 10^4
 *  0 <= graph[i].length <= n 
 *  graph[i] 按严格递增顺序排列。 
 *  图中可能包含自环。 
 *  图中边的数目在范围 [1, 4 * 10^4] 内。
 *
 *  Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
 *  👍 180 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/5
 */
public class I210805I_I802I_EventualSafeNodes {
    public static void main(String[] args) {
        I210805I_I802I_EventualSafeNodes safeNodes = new I210805I_I802I_EventualSafeNodes();
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(safeNodes.eventualSafeNodes(graph));
        System.out.println("expect is : [2,4,5,6]");
        graph = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(safeNodes.eventualSafeNodes(graph));
        System.out.println("expect is : [4]");
        graph = new int[][]{{},{0,2,3,4},{3},{4},{}};
        System.out.println(safeNodes.eventualSafeNodes(graph));
        System.out.println("expect is : [0,1,2,3,4]");
    }

    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了100.00% 的Java用户
     * 				内存消耗:48.5 MB,击败了25.74% 的Java用户
     *
     * 时间复杂度: O(N+M)
     * 空间复杂度: O(N)
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph){
        List<Integer> list = new ArrayList<>();
        int len = graph.length;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            boolean safe = safeNode(graph, color, i);
            if (safe) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean safeNode(int[][] graph, int[] color, int idx){
        if (color[idx] > 0) {
            return color[idx] == 2;
        }
        color[idx] = 1;
        for (int y : graph[idx]) {
            if (!safeNode(graph, color, y)){
                return false;
            }
        }
        color[idx] = 2;
        return true;
    }

    /**
     * 超时
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodesTLE(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        int n = graph.length;
        // 记录成功的节点
        Set<Integer> sucSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(i, graph[i]);
            if (graph[i] == null || graph[i].length == 0) {
                sucSet.add(i);
            }
        }
        // 记录失败的节点
        Set<Integer> errSet = new HashSet<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            // 节点在失败的集合中, 跳过
            if (errSet.contains(entry.getKey())) continue;
            // 节点在成功的集合中, 跳过
            if (sucSet.contains(entry.getKey())) continue;
            // 深度搜索记录以当前节点为起点的所有节点
            Set<Integer> set = new HashSet<>();
            set.add(entry.getKey());
            // 深度搜索检查节点是否能到达终点
            boolean check = dfs(entry.getValue(), set, errSet, sucSet, map);
            if (check) {
                // 记录成功的节点
                sucSet.add(entry.getKey());
            }else {
                // 记录失败的节点
                errSet.add(entry.getKey());
            }
        }
        // 所有节点组装返回
        ans.addAll(sucSet);
        ans.sort((o1, o2) -> {return o1-o2;});
        return ans;
    }

    private boolean dfs(int[] side, Set<Integer> set, Set<Integer> errSet, Set<Integer> sucSet, Map<Integer, int[]> map) {
        // 当前节点没有指向任何其它节点
        if (side == null || side.length == 0) {
            return true;
        }
        boolean check = true;
        // 遍历当前节点的所有指向的节点
        for (int i = 0; i < side.length; i++) {
            // 子节点存在于深度集合中, 即之前存在过, 现在再次出现, 说明出现环, 则当前节点为失败节点
            if (set.contains(side[i])) {
                errSet.add(side[i]);
                return false;
            }
            // 子节点存在于失败节点中, 直接返回
            if (errSet.contains(side[i])) return false;
            // 获取子节点的孙子节点数组
            int[] val = map.getOrDefault(side[i], null);
            // 当前子结点没有孙子节点, 则当前子节点为成功的节点
            if (val == null || val.length == 0) {
                sucSet.add(side[i]);
                continue;
            }
            Set<Integer> curSet = new HashSet<>(set);
            curSet.add(side[i]);
            check = dfs(val, curSet, errSet,sucSet, map);
            if (!check){
                errSet.add(side[i]);
                return false;
            }
        }
        return check;
    }
}
