package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;

/**
 * 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
 * 
 *  示例:
 *  输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0] 
 * 
 *  说明:
 *  必须在原数组上操作，不能拷贝额外的数组。 
 *  尽量减少操作次数。 
 *  
 *  Related Topics 数组 双指针 
 *  👍 1104 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I283I_MoveZeroes {
    public static void main(String[] args) {
        I283I_MoveZeroes moveZeroes = new I283I_MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12,0,0,234,3,4,5,0,3,4,5};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.4 MB,击败了92.27% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, fast = -1, slow=-1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (fast == -1) {
                    slow = i;
                }
                fast = i;
            } else {
                if (slow != -1) {
                    nums[slow] = nums[i];
                    nums[i] = 0;
                    fast = i;
                    slow++;
                }
            }
        }

    }
}
