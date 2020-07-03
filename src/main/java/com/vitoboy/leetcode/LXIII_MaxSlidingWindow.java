package com.vitoboy.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: vito
 * @Date: 2020/7/3 11:26
 * @Version: 1.0
 *
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 */
public class LXIII_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,-2,5,3,6,7};
        LXIII_MaxSlidingWindow maxSlidingWindow = new LXIII_MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, 3)));
//
//        nums = new int[]{1};
//        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, 1)));
//
//        nums = new int[]{1,3,-1,-3,5,3,6,7};
//        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, 3)));
//
        nums = new int[]{7, 2, 4};
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, 2)));


    }

    /**
     * 自己实现, 竟然是双100
     *
     * 思路简单:
     * 1.特殊情况: 数组为空, 数组长度为0, k==0, k==1
     * 2.一般情况下, 可以通过观察窗口在数组的移动, 得到所需存放最大值的数组长度为: nums.length -k +1
     * 3.先求第一个窗口的最大值 maxNum, 及最大值的下标 maxIndex,
     * 4.怎么求下一个窗口的最大值
     *      a.如果下一个窗口的最后一个值, 比当前窗口的最大值大, 那么, 下一个窗口的最大值, 即为下一个窗口的最后一个值
     *      b.如果下一个窗口的最后一个值, 比当前窗口的最大值小, 那么, 看当前窗口的最大值的下标, 是否还处于下一个窗口的下标范围内
     *          I.当前窗口的最大值的下标, 还处理于下一个窗口的下标范围内, 则当前窗口的最大值即为下一个窗口的最大值
     *          II.当前窗口的最大值的下标, 不在下一个窗口的下标范围内, 则需要对下一个窗口重新选取窗口的最大值
     * 5.结束的判断条件, 窗口的下标到达数组的边界
     * 6.返回存放最大值的数组即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 特殊情况, 特殊处理
        if (k == 0 || nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;
        // 定义max数组存放每个窗口的最大值
        int[] max = new int[nums.length -k +1];
        // 定义当前窗口的最新下标
        int index = 0;
        // 已有窗口的最大值maxNum, 及最大值下标maxIndex
        int maxNum = nums[0];
        int maxIndex = 0;
        // 求第一个窗口的最大值maxNum和最大值下标:maxNum
        while (index < k) {
            if (maxNum < nums[index]) {
                maxNum = nums[index];
                maxIndex = index;
            }
            index++;
        }
        // 存储第一个最大值
        max[0] = maxNum;
        // 最大值存储的下标
        int count=1;
        for (; index < nums.length; index++) {
            if (nums[index] > maxNum) {
                maxNum = nums[index];
                maxIndex = index;
            } else {
                // 重新获取窗口的最大值
                if (index - maxIndex >= k){
                    // 窗口的第一个值默认为最大值
                    maxNum = nums[maxIndex+1];
                    maxIndex = maxIndex+1;
                    for (int j = maxIndex+1; j <= index ; j++) {
                        if (nums[j] > maxNum) {
                            maxNum = nums[j];
                            maxIndex = j;
                        }
                    }
                }
            }
            // 继续存储最大值
            max[count] = maxNum;
            // 最大值下标加1
            count++;
        }
        return max;
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowOfficial(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowOfficialII(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if(i >= 0) res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }




}
