package com.vitoboy.leetcode.tags.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * 给定两个数组，编写一个函数来计算它们的交集。 
 *
 *  示例 1：
 *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *  
 * 
 *  示例 2:
 *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9] 
 *
 *  说明：
 *  输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
 *  我们可以不考虑输出结果的顺序。 
 *  
 * 
 *  进阶：
 *  如果给定的数组已经排好序呢？你将如何优化你的算法？ 
 *  如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
 *  如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
 *  
 *  Related Topics 数组 哈希表 双指针 二分查找 排序 
 *  👍 511 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I350I_Intersect {
    public static void main(String[] args) {
        I350I_Intersect intersect = new I350I_Intersect();
        int[] num1 = new int[]{1,2,2,1}, num2 = new int[]{2,2};
        int[] arr = intersect.intersect(num1, num2);
        System.out.println(Arrays.toString(arr));
        System.out.println("expcet is : [2,2]");
        num1 = new int[]{4,9,5};
        num2 = new int[]{9,4,9,8,4};
        arr = intersect.intersect(num1, num2);
        System.out.println(Arrays.toString(arr));
        System.out.println("expcet is : [4,9]");
        
    }

    /**
     * 				解答成功:
     * 				执行耗时:5 ms,击败了19.97% 的Java用户
     * 				内存消耗:38.3 MB,击败了93.78% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(N)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0, len = Math.max(l1,l2); i < len; i++) {
            if (l1 > i) {
                if (map1.containsKey(nums1[i])) {
                    map1.put(nums1[i], 1+map1.get(nums1[i]));
                } else {
                    map1.put(nums1[i], 1);
                }
            }
            if (l2 > i) {
                if (map2.containsKey(nums2[i])) {
                    map2.put(nums2[i], 1+map2.get(nums2[i]));
                } else {
                    map2.put(nums2[i], 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int len = Math.min(entry.getValue(), map2.get(entry.getKey()));
                for (int i = 0; i < len; i++) {
                    list.add(entry.getKey());
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
