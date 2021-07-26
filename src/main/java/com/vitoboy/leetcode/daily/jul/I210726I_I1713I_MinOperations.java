package com.vitoboy.leetcode.daily.jul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @problem leetcode
 * @description 1713.得到子序列的最少操作次数
 *
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。 
 * 
 *  每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,
 * 2] 。你可以在数组最开始或最后面添加整数。 
 * 
 *  请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。 
 * 
 *  一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,
 * 7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。 
 *
 *  示例 1：
 *  输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 *  
 * 
 *  示例 2：
 *  输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * 输出：3
 *
 *  提示：
 *  1 <= target.length, arr.length <= 10^5
 *  1 <= target[i], arr[i] <= 10^9
 *  target 不包含任何重复元素。 
 *  
 *  Related Topics 贪心 数组 哈希表 二分查找 
 *  👍 59 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/26
 */
public class I210726I_I1713I_MinOperations {
    public static void main(String[] args) {
        I210726I_I1713I_MinOperations operations = new I210726I_I1713I_MinOperations();
        int[] target = new int[]{5,1,3};
        int[] arr = new int[]{9,4,2,3,4};
        System.out.println(operations.minOperations(target, arr));
        System.out.println("expect is : 2");
        target = new int[]{6,4,8,1,3,2};
        arr = new int[]{4,7,6,2,3,8,6,1};
        System.out.println(operations.minOperations(target, arr));
        System.out.println("expect is : 3");

    }

    /**
     * 				解答成功:
     * 				执行耗时:87 ms,击败了31.75% 的Java用户
     * 				内存消耗:53.7 MB,击败了68.25% 的Java用户
     *
     * 时间复杂度: O(nlogn + n)
     * 空间复杂度: O(N)
     *
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target, int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = target.length; i < len; i++) {
            map.put(target[i], i);
        }
        for (int i = 0, len = arr.length; i < len; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        // 找到这个list中的最长的递增序列
        int length =  lengthOfLIS(list);
        return target.length - length;
    }

    /**
     * 这个时间复杂度太大, 有O(N^2), 需要转化为 O(NlogN)的时间复杂度才行
     *
     * @param nums
     * @return
     */
    private int lengthOfLIS(List<Integer> nums) {
        int n =nums.size(), len = 0;
        int[] tail = new int[n];
        tail[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            if (tail[len] < nums.get(i)) {
                tail[++len] = nums.get(i);
            } else if (tail[len] > nums.get(i)){
                int low = 0, high = len;
                while (low < high) {
                    int mid = low + (high-low)/2;
                    if (tail[mid] == nums.get(i)) {
                        low = mid;
                        break;
                    }
                    else if (tail[mid] < nums.get(i)) low = mid+1;
                    else high = mid;
                }
                tail[low] = nums.get(i);
            }
        }
        return len+1;
    }
}
