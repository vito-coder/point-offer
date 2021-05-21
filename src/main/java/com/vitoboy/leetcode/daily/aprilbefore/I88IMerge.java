package com.vitoboy.leetcode.daily.aprilbefore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
 * ms2 的元素。
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * Related Topics 数组 双指针
 * 👍 867 👎 0
 *
 * @Author: vito
 * @Date: 2021/4/5 下午5:03
 * @Version: 1.0
 */
public class I88IMerge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] large = new int[]{1, 2, 3, 0, 0, 0};
        int[] small = new int[]{2, 5, 6};
        merge.mergeUpdate(large, 3, small, 3);
        System.out.println("result is : " + Arrays.toString(large));
        System.out.println("expect is : [1,2,2,3,5,6]");
        large = new int[]{1};
        small = new int[0];
        merge.mergeUpdate(large, 1, small, 0);
        System.out.println("result is : " + Arrays.toString(large));
        System.out.println("expect is : [1]");
        large = new int[]{0};
        small = new int[]{1};
        merge.mergeUpdate(large, 0, small, 1);
        System.out.println("result is : " + Arrays.toString(large));
        System.out.println("expect is : [1]");
        large = new int[]{2, 0};
        small = new int[]{1};
        merge.mergeUpdate(large, 1, small, 1);
        System.out.println("result is : " + Arrays.toString(large));
        System.out.println("expect is : [1, 2]");

    }

    interface IMerge {
        void merge(int[] nums1, int m, int[] nums2, int n);
    }

    /**
     * 数组1: [1,2,3,4,0,0,0]
     * 数组2: [3,4,6]
     *
     * 从题目得知, 两数组是单调递增的(指定范围内, 即m, n), 所以最大的数一定在最后
     * 考虑从两数组的后面往前遍历, 并依次比较, 比较的结果直接存储到数组1中, 即为题目要求
     *
     * 由于每个数组都遍历一遍, 时间复杂度为: O(m+n)
     * 使用的变量固定多, 空间复垦度为: O(1)
     *
     *
     *
     * 执行用时： 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.3 MB, 在所有 Java 提交中击败了 95.24% 的用户
     */
    static class Merge implements IMerge {

        /**
         * 自己的写法
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums2 == null || nums2.length == 0 || n <= 0) {
                return;
            }
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            int len = m+n, d1 = m-1, d2 = n-1;
            for (int i = len-1; i >= 0; i--) {
                if (d1 < 0 && d2 >= 0) {
                    nums1[i] = nums2[d2];
                    d2--;
                    continue;
                } else if (d1 >= 0 && d2 < 0) {
                    break;
                }
                if (nums1[d1] > nums2[d2]) {
                    nums1[i] = nums1[d1];
                    d1--;
                } else {
                    nums1[i] = nums2[d2];
                    d2--;
                }
            }

        }

        public void mergeUpdate(int[] nums1, int m, int[] nums2, int n) {
            if (n > 0) {
                int len = m + n;
                int p1 = m-1, p2= n-1;
                for (int i = len-1; i >=0 && p2 >=0 ; i--) {
                    if (p1 < 0) {
                        nums1[i] = nums2[p2--];
                        continue;
                    }
                    nums1[i] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
                }
            }
        }
    }
}
