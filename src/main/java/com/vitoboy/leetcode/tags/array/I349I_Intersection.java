package com.vitoboy.leetcode.tags.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * 给定两个数组，编写一个函数来计算它们的交集。 
 *
 *  示例 1：
 *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *  
 * 
 *  示例 2：
 *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4] 
 *
 *  说明：
 *  输出结果中的每个元素一定是唯一的。 
 *  我们可以不考虑输出结果的顺序。 
 *  
 *  Related Topics 数组 哈希表 双指针 二分查找 排序 
 *  👍 383 👎 0
 * 
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I349I_Intersection {
    public static void main(String[] args) {
        I349I_Intersection intersection = new I349I_Intersection();
        int[] num1= new int[]{1,2,2,1}, num2 = new int[]{2,2};
        int[] arr = intersection.intersection(num1, num2);
        System.out.println(Arrays.toString(arr));
        System.out.println("expect is : [2]");
        num1= new int[]{4,9,5};
        num2= new int[]{9,4,9,8,4};
        arr = intersection.intersection(num1, num2);
        System.out.println(Arrays.toString(arr));
        System.out.println("expect is : [9,4]");

        
    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了85.00% 的Java用户
     * 				内存消耗:38.4 MB,击败了92.27% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0, len = Math.max(l1,l2); i < len; i++) {
            if (l1 > i) {
                set1.add(nums1[i]);
            }
            if (l2 > i) {
                set2.add(nums2[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)) list.add(integer);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
