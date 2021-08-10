package com.vitoboy.leetcode.daily.aug;

/**
 * @problem leetcode 
 * @description 457.环形数组是否存在循环
 * 
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数： 
 *
 *  如果 nums[i] 是正数，向前 移动 nums[i] 步 
 *  如果 nums[i] 是负数，向后 移动 nums[i] 步 
 *
 *  因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。 
 * 
 *  数组中的 循环 由长度为 k 的下标序列 seq ： 
 *
 *  遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ... 
 *  所有 nums[seq[j]] 应当不是 全正 就是 全负 
 *  k > 1 
 *
 *  如果 nums 中存在循环，返回 true ；否则，返回 false 。 
 *
 *  示例 1：
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 *  
 * 
 *  示例 2：
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 *
 *  示例 3:
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。 
 *
 *  提示：
 *  1 <= nums.length <= 5000 
 *  -1000 <= nums[i] <= 1000 
 *  nums[i] != 0 
 *
 *  进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？ 
 *  Related Topics 数组 哈希表 双指针 
 *  👍 140 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/7
 */
public class I210807I_I457I_CircularArrayLoop {
    public static void main(String[] args) {
        I210807I_I457I_CircularArrayLoop arrayLoop = new I210807I_I457I_CircularArrayLoop();
        int[] nums = new int[]{2,-1,1,2,2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");
        nums = new int[]{-1,2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : false");
        nums = new int[]{-2,1,-1,-2,-2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : false");
        nums = new int[]{2,1,1,2,2,2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");
        nums = new int[]{2,2,1,2,2,2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");
        nums = new int[]{-1,2,1,2,2,2};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");
        nums = new int[]{-1,-2,-3,-4,-5};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");
        nums = new int[]{1,2,2,-1};
        System.out.println(arrayLoop.circularArrayLoop(nums));
        System.out.println("expect is : true");


    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36 MB,击败了28.51% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        // len --> 数组长度, turn --> 第几轮遍历
        int len = nums.length, turn = 0;
        // 记录每个坐标被访问了几次
        int[] find = new int[len];
        // 防止取坐标越界的保护模, 无论什么数值 + 这个max, 再对数组长度取模, 一定可以不越数组界
        int max = len;
        while (max<10000) {
            max *= 10;
        }
        // 遍历数据
        for (int i = 0; i < len; i++) {
            // 当 且仅当 当前坐标没有被访问, 才判断有没有可能出现由这个坐标开始的循环
            if (find[i] == 0) {
                // 记录当前坐标是第几轮次的访问, 和之前失败的轮次作区别
                find[i] = ++turn;
                // 记录当前数组值是否为正常
                boolean positive = nums[i] > 0 ? true : false;
                // 计算下一个坐标值
                int idx = 0 ;
                // 保证坐标值不会越界
                if(i + nums[i] > 0) {
                    idx = (i+nums[i]) % len;
                }else {
                    idx = (i+nums[i] + max) % len;
                }
                // 循环检查下一坐标值, 如果下一坐标未被标记过, 则继续检查
                while (find[idx] == 0) {
                    // 检查符号是否一致
                    // 符号不一致, 直接没必要继续检查, 保证题目说的, 全正或全负
                    if (positive && nums[idx] < 0) break;
                    else if(!positive && nums[idx] > 0) break;
                    // 标记访问到的坐标(是第几轮访问到的)
                    find[idx] = turn;
                    // 计算下一个坐标
                    if (idx + nums[idx] < 0) {
                        idx = (idx + nums[idx] + max) % len;
                    } else {
                        idx = (idx + nums[idx]) % len;
                    }
                }
                // 判断循环时, 是否为同一轮循环的标记
                if ( find[idx] == turn ) {
                    // 再判断是否是单个坐标循环
                    int nextIdx = (idx + nums[idx] + max ) % len;
                    // 都符合题目要求, 返回true
                    if (idx != nextIdx) return true;
                }
            }
        }
        // 其它情况 , 返回false
        return false;
    }
}
