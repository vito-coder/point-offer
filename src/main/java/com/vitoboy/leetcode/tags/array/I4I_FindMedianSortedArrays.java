package com.vitoboy.leetcode.tags.array;

/**
 * @author vito
 * @version 1.0
 * @date 2021/6/3
 */
public class I4I_FindMedianSortedArrays {
    public static void main(String[] args) {

    }


    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了82.44% 的Java用户
     * 				内存消耗:39.8 MB,击败了31.75% 的Java用户
     *
     * 	时间复杂度: O(n) 需要遍历两数组总和的一半
     * 	空间复杂度: O(1) 需要固定的变量来计算最终的结果
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null) {
            int n = nums2.length;
            if(n % 2 == 0) {
                return (nums2[n/2] + nums2[n/2 - 1])/2.0;
            } else {
                return (double)nums2[n/2];
            }
        }
        if (nums2 == null) {
            int m = nums1.length;
            if(m % 2 == 0) {
                return (nums1[m/2] + nums1[m/2 - 1])/2.0;
            } else {
                return (double)nums1[m/2];
            }
        }
        int m = nums1.length, n = nums2.length, n1 = 0, n2 = 0;
        boolean two = (m+n) % 2 == 0;
        double res = 0.0;
        for (int i = 0; i < (m + n)/2 + 1 ; i++) {
            if(n2 < n && n1 < m) {
                if (nums1[n1] < nums2[n2]) {
                    if (two && (i >= (m + n) / 2 - 1)) {
                        res += nums1[n1];
                    }
                    if (!two && i == (m + n) / 2) {
                        return nums1[n1];
                    }
                    n1++;
                } else {
                    if (two && (i >= (m + n) / 2 - 1)) {
                        res += nums2[n2];
                    }
                    if (!two && i == (m + n) / 2) {
                        return nums2[n2];
                    }
                    n2++;
                }
            } else if(n1 < m) {
                if (two && (i >= (m + n) / 2 - 1)) {
                    res += nums1[n1];
                }
                if (!two && i == (m + n) / 2) {
                    return nums1[n1];
                }
                n1++;
            } else if(n2 < n) {
                if (two && (i >= (m + n) / 2 - 1)) {
                    res += nums2[n2];
                }
                if (!two && i == (m + n) / 2) {
                    return nums2[n2];
                }
                n2++;
            }
        }
        return res/2;
    }
}
