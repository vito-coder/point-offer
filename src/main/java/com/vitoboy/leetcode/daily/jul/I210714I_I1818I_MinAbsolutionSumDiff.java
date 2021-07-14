package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。 
 * 
 *  数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
 * ）。 
 * 
 *  你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
 * 
 *  在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。 
 * 
 *  |x| 定义为：
 *  如果 x >= 0 ，值为 x ，或者 
 *  如果 x <= 0 ，值为 -x 
 *
 *  示例 1：
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 *  
 * 
 *  示例 2：
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 *  
 * 
 *  示例 3：
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *
 *  提示：
 *  n == nums1.length 
 *  n == nums2.length 
 *  1 <= n <= 10^5
 *  1 <= nums1[i], nums2[i] <= 10^5
 *  
 *  Related Topics 贪心 数组 二分查找 有序集合 
 *  👍 45 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/14
 */
public class I210714I_I1818I_MinAbsolutionSumDiff {
    public static void main(String[] args) {
        I210714I_I1818I_MinAbsolutionSumDiff diff = new I210714I_I1818I_MinAbsolutionSumDiff();
        int[] nums1 = new int[]{1,7,5}, nums2 = new int[]{2,3,5};
        System.out.println(diff.minAbsoluteSumDiff(nums1, nums2));
        System.out.println("expect is : 3");
        nums1 = new int[]{2,4,6,8,10};
        nums2 = new int[]{2,4,6,8,10};
        System.out.println(diff.minAbsoluteSumDiff(nums1, nums2));
        System.out.println("expect is : 0");
        nums1 = new int[]{1,10,4,4,2,7};
        nums2 = new int[]{9,3,5,1,7,4};
        System.out.println(diff.minAbsoluteSumDiff(nums1, nums2));
        System.out.println("expect is : 20");
        nums1 = new int[]{1,7,5,6,23,38,19,35,1234};
        nums2 = new int[]{2,3,5,9,24,113, 7234,384,99999};
        System.out.println(diff.minAbsoluteSumDiff(nums1, nums2));
        System.out.println("expect is : 105198");
    }

    /**
     * 				解答成功:
     * 				执行耗时:67 ms,击败了78.40% 的Java用户
     * 				内存消耗:55.8 MB,击败了57.11% 的Java用户
     *
     * 时间复杂度：对 sorted 进行拷贝并排序的复杂度为 O(nlogn)；遍历处理数组时会一边统计，一边尝试二分，找最合适的替换数值，复杂度为 O(nlogn)。整体复杂度为 O(nlogn)
     * 空间复杂度：使用 sorted 数组需要 O(n) 的空间复杂度，同时排序过程中会使用 O(logn) 的空间复杂度；整体复杂度为 O(n+logn)
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference/solution/gong-shui-san-xie-tong-guo-er-fen-zhao-z-vrmq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0, mod = 1000000007, maxDiff = 0;
        int len = nums1.length;
        int[] rec = new int[len];
        System.arraycopy(nums1, 0, rec, 0, len);
        Arrays.sort(rec);
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(nums1[i]-nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(rec, nums2[i]);
            if (j < len) {
                maxDiff = Math.max(maxDiff, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - rec[j-1]));
            }
        }
        return (sum - maxDiff + mod) % mod;
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        if (nums[high] < target) {
            return high+1;
        }
        int mid = 0;
        while (low < high) {
            mid = (high-low)/2 + low;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    
}
