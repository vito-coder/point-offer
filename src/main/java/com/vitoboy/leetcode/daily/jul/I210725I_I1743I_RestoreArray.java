package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @problem leetcode
 * @description 从相邻元素对还原数组
 * 
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。 
 * 
 *  给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
 *  和 vi 在 nums 中相邻。 
 * 
 *  题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
 * , nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。 
 * 
 *  返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。 
 *
 *  示例 1：
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 *  
 * 
 *  示例 2：
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 *  
 * 
 *  示例 3：
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *
 *  提示：
 *  nums.length == n 
 *  adjacentPairs.length == n - 1 
 *  adjacentPairs[i].length == 2 
 *  2 <= n <= 10^5
 *  -105 <= nums[i], ui, vi <= 105 
 *  题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums 
 *  
 *  Related Topics 数组 哈希表 
 *  👍 88 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/25
 */
public class I210725I_I1743I_RestoreArray {
    public static void main(String[] args) {
        I210725I_I1743I_RestoreArray array = new I210725I_I1743I_RestoreArray();
        int[][] paris = new int[][]{{4,-2},{1,4},{-3,1}};
        System.out.println(Arrays.toString(array.restoreArray(paris)));
        System.out.println("expect is : [-2,4,1,-3] or [-3,1,4,-2]");

    }

    /**
     * 				解答成功:
     * 				执行耗时:62 ms,击败了96.00% 的Java用户
     * 				内存消耗:88.4 MB,击败了48.00% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param adjacentPairs
     * @return
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] par = null;
        for (int i = 0, len = adjacentPairs.length; i < len; i++) {
            int[] tmp = adjacentPairs[i];
            if (map.containsKey(tmp[0])) {
                map.get(tmp[0])[1] = tmp[1];
                if (map.containsKey(tmp[1])) {
                    map.get(tmp[1])[1] = tmp[0];
                } else {
                    par = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
                    par[0] = tmp[0];
                    map.put(tmp[1], par);
                }
            } else {
                par = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
                par[0] = tmp[1];
                map.put(tmp[0], par);
                if (map.containsKey(tmp[1])) {
                    map.get(tmp[1])[1] = tmp[0];
                } else {
                    par = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
                    par[0] = tmp[0];
                    map.put(tmp[1], par);
                }
            }
        }
        int begin = Integer.MIN_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == Integer.MIN_VALUE) {
                begin = entry.getKey();
                break;
            }
        }
        int[] ans = new int[adjacentPairs.length + 1];
        for (int i = 0, len = ans.length; i < len; i++) {
            ans[i] = begin;
            int[] tmp = map.get(begin);
            if (i < 1) {
                begin = tmp[0];
            } else {
                if (tmp[0] != ans[i-1] && tmp[0] != begin && tmp[0] != Integer.MIN_VALUE) {
                    begin = tmp[0];
                } else if (tmp[1] != ans[i-1] && tmp[1] != begin && tmp[1] != Integer.MIN_VALUE) {
                    begin = tmp[1];
                }
            }
        }
        return ans;
    }
    
}
