package com.vitoboy.leetcode.daily.aug;

import java.util.*;

/**
 * @problem leetcode
 * @description 743.网络延迟时间
 * 
 * 有 n 个网络节点，标记为 1 到 n。 
 * 
 *  给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
 * i 是一个信号从源节点传递到目标节点的时间。 
 * 
 *  现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
 *
 *  示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *  
 * 
 *  示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 *  
 * 
 *  示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 *  提示：
 *  1 <= k <= n <= 100 
 *  1 <= times.length <= 6000 
 *  times[i].length == 3 
 *  1 <= ui, vi <= n 
 *  ui != vi 
 *  0 <= wi <= 100 
 *  所有 (ui, vi) 对都 互不相同（即，不含重复边） 
 *  
 *  Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
 *  👍 312 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/2
 */
public class I210802I_I743I_NetworkDelayTime {
    public static void main(String[] args) {
        I210802I_I743I_NetworkDelayTime delayTime = new I210802I_I743I_NetworkDelayTime();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(delayTime.networkDelayTime(times, 4, 2));
        System.out.println("expect is : 2");
        times = new int[][]{{1,2,1}};
        System.out.println(delayTime.networkDelayTime(times, 2,1));
        System.out.println("expect is : 1");
        times = new int[][]{{1,2,1}};
        System.out.println(delayTime.networkDelayTime(times, 2,2));
        System.out.println("expect is : -1");
        times = new int[][]{{1,2,1},{2,1,3}};
        System.out.println(delayTime.networkDelayTime(times, 2,2));
        System.out.println("expect is : 3");
        times = new int[][]{{1,2,1},{2,3,2},{1,3,2}};
        System.out.println(delayTime.networkDelayTime(times, 3,1));
        System.out.println("expect is : 2");

    }

    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了90.32% 的Java用户
     * 				内存消耗:43 MB,击败了12.66% 的Java用户
     *
     * 朴素 Dijkstra
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE /2;
        int[][] map = new int[n][n];
        for (int[] ints : map) {
            Arrays.fill(ints, INF);
        }
        // 记录在map表里
        for (int[] time : times) {
            int x = time[0]-1, y = time[1]-1;
            map[x][y] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        // 源点标记, 设置距离为0
        dist[k-1] = 0;

        // 记录哪些点已经标记
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            // 未确定边时, 计算最小值
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            // 标记
            used[x] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[x] + map[x][j]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
