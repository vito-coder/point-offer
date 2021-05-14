package com.vitoboy.leetcode.daily;

/**
 *给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
 *
 * 
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
 *s 贡献此图。 
 *
 * 示例: 
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 *输出: 6 
 * Related Topics 栈 数组 双指针 
 * 👍 158 👎 0
 * 
 * @Author: vito
 * @Date: 2021/4/2 下午3:09
 * @Version: 1.0
 */
public class Interview17_21Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        ITrap trap = new Trap();
        System.out.println("result is : " + trap.trap(height));
        System.out.println("expect is : 6");

    }

    interface ITrap {
        int trap(int[] height);
    }

    /**
     * 看完官方题解后, 自己实现最简单易懂的双指针法
     *
     * ----> 最高  <----
     * 两边向中间走, 直到两边都最高且下标一致
     *
     * 				解答成功:
     * 				执行耗时:2 ms,击败了35.87% 的Java用户
     * 				内存消耗:38 MB,击败了75.51% 的Java用户
     */
    static class Trap implements ITrap{

        @Override
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }
            int left = 0, right = height.length -1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    sum += leftMax - height[left];
                    left++;
                } else {
                    sum += rightMax - height[right];
                    right--;
                }
            }
            return sum;
        }
    }
}
