package com.vitoboy.leetcode.daily.may;

import java.util.*;

/**
 * 
 * 给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 rig
 * ht（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR n
 * ums[right] 。 
 * 
 *  返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3] 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= k <= nums.length <= 2000 
 *  0 <= nums[i] < 210 
 *  
 *  Related Topics 动态规划 
 *  👍 52 👎 0
 * 
 * 
 * @author vito
 * @date 2021/5/25
 * @version 1.0
 */
public class I210525I_I1787I_MinChanges {
    public static void main(String[] args) {
        // todo 需要自己在理解题目的基础上, 自己实现

    }

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/solution/shi-suo-you-qu-jian-de-yi-huo-jie-guo-we-uds2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    // x 的范围为 [0, 2^10)
    static final int MAXX = 1 << 10;
    // 极大值，为了防止整数溢出选择 INT_MAX / 2
    static final int INFTY = Integer.MAX_VALUE / 2;

    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAXX];
        Arrays.fill(f, INFTY);
        // 边界条件 f(-1,0)=0
        f[0] = 0;

        for (int i = 0; i < k; ++i) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                ++size;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAXX];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < MAXX; ++mask) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), countx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < MAXX; ++j) {
                g[j] += size;
            }
            f = g;
        }

        return f[0];
    }


}
