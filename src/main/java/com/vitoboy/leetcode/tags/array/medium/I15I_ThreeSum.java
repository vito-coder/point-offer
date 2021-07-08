package com.vitoboy.leetcode.tags.array.medium;

import java.util.*;

/**
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * 复的三元组。 
 * 
 *  注意：答案中不可以包含重复的三元组。 
 *
 *  示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *  
 * 
 *  示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 *  示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 *  提示：
 *  0 <= nums.length <= 3000 
 *  -10^5 <= nums[i] <= 10^5
 *  
 *  Related Topics 数组 双指针 排序 
 *  👍 3476 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I15I_ThreeSum {
    public static void main(String[] args) {
        I15I_ThreeSum threeSum = new I15I_ThreeSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSumII(nums));
        System.out.println("expect is : [[-1,-1,2],[-1,0,1]]");
        nums = new int[]{-1,0,1,2,-1,-4,-3,-7,-9,3,5,6,8};
        System.out.println(threeSum.threeSumII(nums));
        System.out.println("expect is : [[-9,1,8],[-9,3,6],[-7,-1,8],[-7,1,6],[-7,2,5],[-4,-1,5],[-4,1,3],[-3,0,3],[-3,1,2],[-1,-1,2],[-1,0,1]]");

    }

    /**
     * 				解答成功:
     * 				执行耗时:21 ms,击败了97.80% 的Java用户
     * 				内存消耗:42.4 MB,击败了58.25% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumII(int[] nums){
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, sum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > 0) break;
            if (i>0 && nums[i] == nums[i-1]) continue;
            left = i+1; right = len-1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left+1] == nums[left]) ++left;
                    while (left < right && nums[right-1] == nums[right]) --right;
                    ++left;
                    --right;
                } else if(sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }

        return lists;
    }

    /**
     * 				解答成功:
     * 				执行耗时:2078 ms,击败了4.99% 的Java用户
     * 				内存消耗:43.2 MB,击败了7.38% 的Java用户
     *
     * 太慢了....
     * 太复杂了...
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<Integer> mines = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) zero.add(0);
            else if (num < 0) mines.add(num);
            else positive.add(num);
        }
        List<List<Integer>> lists = new ArrayList<>();
        if (zero.size() >= 3) {
            lists.add(Arrays.asList(0,0,0));
            if (mines.isEmpty() || positive.isEmpty()) return lists;
            mergeMinesAndPositive(lists, mines, positive, true);
        } else if (zero.size() >= 1) {
            if (mines.isEmpty() || positive.isEmpty()) return lists;
            mergeMinesAndPositive(lists, mines, positive, true);
        } else {
            if (mines.isEmpty() || positive.isEmpty()) return lists;
            mergeMinesAndPositive(lists, mines, positive, false);
        }

        return lists;
    }

    private void mergeMinesAndPositive(List<List<Integer>> lists, List<Integer> mines, List<Integer> positive, boolean hasZero) {
        mines.sort((o1, o2) -> {return o2-o1;});
        positive.sort((o1, o2) -> {return o1-o2;});
        if (hasZero) {
            useZeroMerge(mines, positive, lists);
            noZeroMerge(mines, positive, lists);
        } else {
            noZeroMerge(mines, positive, lists);
        }
    }

    /**
     * 有一个零时, 满足题目要求时, 则必有 -i, 0, i
     */
    private void useZeroMerge(List<Integer> mines, List<Integer> positive, List<List<Integer>> lists) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j=0, len = mines.size(), pl = positive.size(); i < len; i++) {
            if (set.contains(mines.get(i))) continue;
            if (j < pl) {
                if (mines.get(i) + positive.get(j) == 0) {
                    set.add(mines.get(i));
                    lists.add(Arrays.asList(mines.get(i), positive.get(j), 0));
                    j++;
                } else if (mines.get(i) + positive.get(j) < 0) {
                    int tmp = mines.get(i) + positive.get(j);
                    while (tmp < 0 && j < pl-1) {
                        j++;
                        tmp = mines.get(i) + positive.get(j);
                    }
                    if (tmp == 0) {
                        lists.add(Arrays.asList(mines.get(i), positive.get(j), 0));
                        set.add(mines.get(i));
                        j++;
                    } else if(tmp > 0) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    set.add(mines.get(i));
                }
            }
        }
    }

    /**
     * 只有正数与负数, 没有零时, 则有两种情况: -i, -j, k 或 -i, j, k
     */
    private void noZeroMerge(List<Integer> mines, List<Integer> positive, List<List<Integer>> lists) {
        Set<Integer> singleSet = new HashSet<>();
        Set<ThreeSum> threeSumSet = new HashSet<>();
        int count = 0, total = 0;
        for (Integer mine : mines) {
            if (singleSet.contains(mine)) continue;
            singleSet.add(mine);
            for (int i = 0, len = positive.size(); i < len; i++) {
                count = positive.get(i);
                for (int j = i+1; j < len; j++) {
                    total = mine + count + positive.get(j);
                    if (total == 0) {
                        List<Integer> list = Arrays.asList(mine, count, positive.get(j));
                        ThreeSum sum = getThreeSum(list);
                        if (threeSumSet.contains(sum)) continue;
                        threeSumSet.add(sum);
                        lists.add(list);
                        break;
                    } else if (total > 0) {
                        break;
                    }
                }
            }
        }
        for (Integer integer : positive) {
            if (singleSet.contains(integer)) continue;
            singleSet.add(integer);
            for (int i = 0, len = mines.size(); i < len; i++) {
                count = mines.get(i);
                for (int j = i+1; j < len; j++) {
                    total = integer + count + mines.get(j);
                    if (total == 0) {
                        List<Integer> list = Arrays.asList(count, mines.get(j), integer);
                        ThreeSum sum = getThreeSum(list);
                        if (threeSumSet.contains(sum)) continue;
                        threeSumSet.add(sum);
                        lists.add(list);
                        break;
                    } else if (total < 0) {
                        break;
                    }
                }
            }
        }

    }

    /**
     * 通过list, 生成一个组合对象
     */
    private ThreeSum getThreeSum(List<Integer> list) {
        list.sort((o1, o2) -> {return o1-o2;});
        return new ThreeSum(list.get(0), list.get(1), list.get(2));
    }

    /**
     * 定义一个对象, 哈希用的, 记录三个数 : 小, 中, 大
     */
    class ThreeSum {
        Integer small;
        Integer mid;
        Integer big;
        public ThreeSum(){
        }
        public ThreeSum(int small, int mid, int big){
            this.small = small;
            this.mid = mid;
            this.big = big;
        }

        public Integer getSmall() {
            return small;
        }

        public void setSmall(Integer small) {
            this.small = small;
        }

        public Integer getMid() {
            return mid;
        }

        public void setMid(Integer mid) {
            this.mid = mid;
        }

        public Integer getBig() {
            return big;
        }

        public void setBig(Integer big) {
            this.big = big;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ThreeSum threeSum = (ThreeSum) o;
            return Objects.equals(small, threeSum.small) &&
                    Objects.equals(mid, threeSum.mid) &&
                    Objects.equals(big, threeSum.big);
        }

        @Override
        public int hashCode() {
            return Objects.hash(small, mid, big);
        }
    }
}
