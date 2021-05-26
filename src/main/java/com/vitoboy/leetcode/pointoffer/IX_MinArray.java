package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/6/19 15:23
 * @Version: 1.0
 * <p>
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
 * 该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class IX_MinArray {


    public static void main(String[] args) {
        int[] test = new int[]{3, 4, 5, 1, 2};
        int[] test2 = new int[]{2, 2, 2, 0, 1};
        int[] test3 = new int[]{1,3,5};
        int[] test4 = new int[]{1,3};
        int[] test5 = new int[]{3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3};

//        System.out.println(minArray(test));
//
//        System.out.println(minArray(test2));
//
//        System.out.println(minArray(test3));

        System.out.println(minNumberInRotateArrayFaster(test5));


    }

    public static int runawayMinArray(int[] numbers) {
        int end = numbers.length;
        if (end == 0 ) return 0;
        if (end == 1) return numbers[0];
        for (int i = 1; i < end; i++) {
            if (numbers[i] < numbers[i-1]) return numbers[i];
        }
        return numbers[0];
    }

    /**
     *
     作者：jyd
     链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];


    }


    /**
     * 会出问题 使用测试用例: [2,2,2,0,1]
     * @param numbers
     * @return
     */
    public static int minNumberInRotateArrayFaster(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        } else if (numbers.length == 1) {
            return numbers[0];
        }
        int index = numbers.length / 2;
        int len = index;
        while (len >= 1) {
            if (numbers[index] > numbers[0]){
                if (numbers[index + 1] < numbers[0]) return numbers[index + 1];
                index = index + len / 2;
                len = len / 2;
            } else if (numbers[index] < numbers[0]) {
                if (numbers[index-1] <numbers[0]) {
                    len = len / 2;
                    index = index - len;
                } else {
                    return numbers[index];
                }
            } else {
                return numbers[0];
            }
        }
        return numbers[0];
    }
}
