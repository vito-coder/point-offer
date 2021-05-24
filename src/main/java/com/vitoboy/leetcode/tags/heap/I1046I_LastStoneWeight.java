package com.vitoboy.leetcode.tags.heap;

import com.sun.org.apache.bcel.internal.generic.FSTORE;

import java.util.*;

/**
 * 
 * 有一堆石头，每块石头的重量都是正整数。 
 * 
 *  每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
 *
 *  如果 x == y，那么两块石头都会被完全粉碎； 
 *  如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
 *
 *  最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
 *
 *  示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
 *
 *  提示：
 *  1 <= stones.length <= 30 
 *  1 <= stones[i] <= 1000 
 *  
 *  Related Topics 堆 贪心算法 
 *  👍 161 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/24 下午4:22
 * @Version: 1.0
 */
public class I1046I_LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};

        I1046I_LastStoneWeight lastStoneWeight = new I1046I_LastStoneWeight();
        lastStoneWeight.lastStoneWeightII(stones);
        System.out.println();
    }


    /**
     *
     *
     * 				解答成功:
     * 				执行耗时:2 ms,击败了53.31% 的Java用户
     * 				内存消耗:35.8 MB,击败了56.99% 的Java用户
     *
     *
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/last-stone-weight/solution/zui-hou-yi-kuai-shi-tou-de-zhong-liang-b-xgsx/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.8 MB,击败了56.99% 的Java用户
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length-1;
        for (int i = 0; i < stones.length - 2; i++) {
            Arrays.sort(stones);
            if (stones[len] > stones[len-1]) {
                stones[len-1] = stones[len] - stones[len-1];
            } else {
                i++;
                stones[len-1] = 0;
            }
            stones[len] = 0;
        }

        return stones[len];
    }
}
