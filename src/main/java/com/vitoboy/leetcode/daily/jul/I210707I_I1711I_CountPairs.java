package com.vitoboy.leetcode.daily.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。 
 * 
 *  你可以搭配 任意 两道餐品做一顿大餐。 
 * 
 *  给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
 * 餐 的数量。结果需要对 10^9 + 7 取余。
 * 
 *  注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *  
 * 
 *  示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
 *
 *  提示：
 *  1 <= deliciousness.length <= 105 
 *  0 <= deliciousness[i] <= 220 
 *  
 *  Related Topics 数组 哈希表 
 *  👍 48 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I210707I_I1711I_CountPairs {
    public static void main(String[] args) {
        I210707I_I1711I_CountPairs countPairs = new I210707I_I1711I_CountPairs();
        int[] deliciousness = new int[]{1,3,5,7,9};
        System.out.println(countPairs.countPairsII(deliciousness));
        System.out.println("expect is : 4");
        deliciousness = new int[]{1,1,1,3,3,3,7};
        System.out.println(countPairs.countPairsII(deliciousness));
        System.out.println("expect is : 15");
        deliciousness = new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        System.out.println(countPairs.countPairsII(deliciousness));
        System.out.println("expect is : 12");

    }

    /**
     * 官方题解
     *
     * 使用哈希, 记录每个元素出现的次数
     *
     * 				解答成功:
     * 				执行耗时:132 ms,击败了72.88% 的Java用户
     * 				内存消耗:46.4 MB,击败了99.66% 的Java用户
     *
     * 	时间复杂度: O(
     *
     * @param deliciousness
     * @return
     */
    public int countPairsII(int[] deliciousness) {
        int count = 0, maxSum = 0, tmp = 0, mod = 1000000007;
        for (int i : deliciousness) {
            maxSum = Math.max(maxSum, i);
        }
        maxSum = maxSum * 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = deliciousness.length; i < len; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                tmp = map.getOrDefault(sum-val, 0);
                count = (count + tmp) % mod;
            }
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        return count;
    }

    /**
     * 超时...
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        int res = 0, tmp = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0, len = deliciousness.length; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                tmp = deliciousness[i] + deliciousness[j];
                if (map.containsKey(tmp)) {
                    if (map.get(tmp)) {
                        res++;
                        res = res % 1000000007;
                    }
                } else {
                    if (isTwoPower(tmp)) {
                        map.put(tmp, true);
                        res++;
                        res = res % 1000000007;
                    } else {
                        map.put(tmp, false);
                    }
                }
            }
        }
        return res;
    }

    private boolean isTwoPower(int n) {
        if (n < 1) return false;
        int tmp = 0;
        while (n > 0) {
            tmp = n & 1;
            n = n >> 1;
            if (tmp == 1) {
                if (n == 0) return true;
                else return false;
            }
        }
        return false;
    }
}
