package com.vitoboy.leetcode;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/7/15 17:29
 * @Version: 1.0
 *
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 */
public class LXXI_ConstructArr {
    public static void main(String[] args) {
        LXXI_ConstructArr constructArr = new LXXI_ConstructArr();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = 1;
        }
        arr[arr.length-1] = -156336169;
        System.out.println(Arrays.toString(constructArr.constructArr(arr)));

    }

    /**
     * 一般思路:
     * 两重循环
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length <=1) return a;
        int[] res = new int[a.length];
        int early = 1;
        for (int i = 0; i < a.length; i++) {
            int temp = 1;
            if (i > 0 && a[i] == a[i-1]) {
                res[i] = res[i-1];
                continue;
            } else {
                for (int j = i + 1; j < a.length; j++) {
                    temp *= a[j];
                }
            }
            res[i] = temp * early;
            early *= a[i];
        }
        return res;
    }


    /**
     *
     * 算法流程：
     * 初始化：数组 B ，其中 B[0] = 1 ；辅助变量 tmp = 1 ；
     * 计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i] ；
     * 计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入 B[i] ；
     * 返回 B 。
     *
     * 复杂度分析：
     * 时间复杂度 O(N) ： 其中 N 为数组长度，两轮遍历数组 a ，使用 O(N) 时间。
     * 空间复杂度 O(1) ： 变量 tmp 使用常数大小额外空间（数组 b 作为返回值，不计入复杂度考虑）。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param a
     * @return
     */
    public int[] constructArrOfficial(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
