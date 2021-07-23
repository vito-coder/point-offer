package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;

/**
 * @problem leetcode
 * @description 1893.检查是否区域内所有整数都被覆盖
 *
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 star
 * ti 到 endi 的 闭区间 。 
 * 
 *  如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。 
 * 
 *  已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了
 * 。
 *
 *  示例 1：
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 *  
 * 
 *  示例 2：
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *
 *  提示：
 *  1 <= ranges.length <= 50 
 *  1 <= starti <= endi <= 50 
 *  1 <= left <= right <= 50 
 *  
 *  Related Topics 数组 哈希表 前缀和 
 *  👍 29 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/23
 */
public class I210723I_I1893I_IsCovered {
    public static void main(String[] args) {
        
    }

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了37.39% 的Java用户
     * 				内存消耗:37.9 MB,击败了11.98% 的Java用户
     *
     * 	时间复杂度: O(N)--不算排序, O(N+logN)
     * 	空间复杂度: O(1)
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2)->{return o1[0]-o2[0];});
        for (int[] range : ranges) {
            if (range[0] <= left && range[1] >= left) {
                left = range[1] + 1;
            } else if (range[0] > left-1){
                return false;
            }
            if (left-1 >= right) return true;
        }
        return false;
    }
}
