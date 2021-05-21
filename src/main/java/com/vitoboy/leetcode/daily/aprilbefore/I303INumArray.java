package com.vitoboy.leetcode.daily.aprilbefore;

/**
 * 
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。 
 * 
 *  
 *  
 *  实现 NumArray 类： 
 * 
 *  
 *  NumArray(int[] nums) 使用数组 nums 初始化对象 
 *  int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 s
 * um(nums[i], nums[i + 1], ... , nums[j])） 
 *  
 * 
 *  
 * 
 *  示例： 
 * 
 *  
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * 
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  0 <= nums.length <= 104 
 *  -105 <= nums[i] <= 105 
 *  0 <= i <= j < nums.length 
 *  最多调用 104 次 sumRange 方法 
 *  
 *  
 *  
 *  Related Topics 动态规划 
 *  👍 280 👎 0
 * 
 * @Author: vito
 * @Date: 2021/3/1 下午5:38
 * @Version: 1.0
 */
public class I303INumArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArrInterface numArray = new NumArrayII(nums);
        System.out.println("result : " + numArray.sumRange(0, 2));
        System.out.println("expect : 1");
        System.out.println("result : " + numArray.sumRange(2, 5));
        System.out.println("expect : -1");
        System.out.println("result : " + numArray.sumRange(0, 5));
        System.out.println("expect : -3");
    }
}

interface NumArrInterface {
    int sumRange(int i, int j);
}

/**
 * 				解答成功:
 * 				执行耗时:79 ms,击败了22.76% 的Java用户
 * 				内存消耗:41.4 MB,击败了37.38% 的Java用户
 */
class NumArray implements NumArrInterface{

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    @Override
    public int sumRange(int i, int j) {
        int sum = 0;
        for (; i <= j; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * 				解答成功:
 * 				执行耗时:10 ms,击败了77.14% 的Java用户
 * 				内存消耗:41.3 MB,击败了59.02% 的Java用户
 */
class NumArrayII implements NumArrInterface{

    int[] diff;

    public NumArrayII(int[] nums) {
        diff = new int[nums.length + 1];
        diff[0] = 0;
        for (int i = 1; i < nums.length+1; i++) {
            diff[i] = nums[i-1] + diff[i-1];
        }
    }

    @Override
    public int sumRange(int i, int j) {
        return diff[j+1] - diff[i];
    }
}
