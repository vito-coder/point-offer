package com.vitoboy.leetcode.tags.array.medium;

/**
 * @problem leetcode
 * @description 11.盛最多水的容器
 * 
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
 * ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
 * 
 *  说明：你不能倾斜容器。 
 *
 *  示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
 * 
 *  示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *  
 * 
 *  示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *  
 * 
 *  示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *
 *  提示：
 *  n = height.length 
 *  2 <= n <= 3 * 104 
 *  0 <= height[i] <= 3 * 104 
 *  
 *  Related Topics 贪心 数组 双指针 
 *  👍 2691 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/13
 */
public class I11I_MaxArea {
    public static void main(String[] args) {
        I11I_MaxArea area = new I11I_MaxArea();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(area.maxArea(height));
        System.out.println("expect is : 49");
        height = new int[]{1,1};
        System.out.println(area.maxArea(height));
        System.out.println("expect is : 1");
        height = new int[]{4,3,2,1,4};
        System.out.println(area.maxArea(height));
        System.out.println("expect is : 16");
        height = new int[]{1,2,1};
        System.out.println(area.maxArea(height));
        System.out.println("expect is : 2");
    }


    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了94.91% 的Java用户
     * 				内存消耗:52.2 MB,击败了5.65% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length-1;
        for (; left < right ;) {
            if (height[left] > height[right]) {
                ans = Math.max(ans, (right-left)*height[right]);
                right--;
            } else {
                ans = Math.max(ans, (right-left)*height[left]);
                left++;
            }
        }
        return ans;
    }
}
