package com.vitoboy.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给你一个整数数组 arr 。 
 * 
 *  现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。 
 * 
 *  a 和 b 定义如下： 
 * 
 *  
 *  a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] 
 *  b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] 
 *  
 * 
 *  注意：^ 表示 按位异或 操作。 
 * 
 *  请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 *  
 * 
 *  示例 2： 
 * 
 *  输入：arr = [1,1,1,1,1] (1,1)--[(0,1,1),(1,2,2),(2,3,3),(3,4,4)], (1,1,1,1)--[(0,1,3),(0,2,3),(0,3,3),(1,2,4),(1,3,4),(1,4,4)]
 * 输出：10
 *  
 * 
 *  示例 3： 
 * 
 *  输入：arr = [2,3]
 * 输出：0
 *  
 * 
 *  示例 4： 
 * 
 *  输入：arr = [1,3,5,7,9]
 * 输出：3
 *  
 * 
 *  示例 5： 
 * 
 *  输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= arr.length <= 300 
 *  1 <= arr[i] <= 10^8 
 *  
 *  Related Topics 位运算 数组 数学 
 *  👍 75 👎 0
 * 
 * @Author: vito
 * @Date: 2021/5/18 上午9:44
 * @Version: 1.0
 */
public class I210518I_I1442ICountTriplets {
    public static void main(String[] args) {
        I210518I_I1442ICountTriplets countTriplets = new I210518I_I1442ICountTriplets();

        int[] arr = new int[]{1,1,1,1,1};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 10");
        arr = new int[]{2,3,1,6,7};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 4");
        arr = new int[]{2,3};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 0");
        arr = new int[]{1,3,5,7,9};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 3");
        arr = new int[]{7,11,12,9,5,2,7,17,22};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 8");
        arr = new int[]{1,1,1,1,1};
        System.out.println("result is : " + countTriplets.countTriplets(arr));
        System.out.println("expcet is : 10");
    }

    /**
     * 由于 求 a == b 的可能性 且:
     *  a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     *  b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     *  又由 a == b 则 a ^ b = 0
     *  则有
     *  a ^ b = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k]  == 0
     *
     *
     *  输入：arr = [1,1,1,1,1] (1,1)--[(0,1,1),(1,2,2),(2,3,3),(3,4,4)], (1,1,1,1)--[(0,1,3),(0,2,3),(0,3,3),(1,2,4),(1,3,4),(1,4,4)]
     *  输出：10
     *
     *  公式:
     *  第一步, 找出所有最小组的可能情况
     *      (k-i) = 1时, 有一种可能 1 * 4(这个数据, k-i=2的有4组)
     *      (k-i) = 2时, 有两种可能 2
     *      (k-i) = 3时, 有六种可能 3 * 2(这个数据, k-i=3的有2组)
     *  第二步, 遍历数组, 从i=0 到 i=n-2
     *      当i=0时, 计算arr[i]^arr[i+1]是否为零, 如果是, 记录到数据里
     *
     *
     *      		解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.8 MB,击败了88.68% 的Java用户
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int[] count = new int[arr.length];
        int trip = 0;
        for (int i = 0; i < len - 1; i++) {
            trip = arr[i];
            for (int j = i+1; j < len; j++) {
                if ((trip ^= arr[j]) == 0) {
                    count[j-i] = ++count[j-i];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                sum += count[i]*i;
            }
        }

        return sum;
    }


    /**
     * 优化版本
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.6 MB,击败了100.00% 的Java用户
     *
     * @param arr
     * @return
     */
    public int countTripletsUpdate(int[] arr) {
        int len = arr.length;
        int sum = 0;
        int trip = 0;
        for (int i = 0; i < len - 1; i++) {
            trip = arr[i];
            for (int j = i+1; j < len; j++) {
                if ((trip ^= arr[j]) == 0) {
                    sum += (j-i);
                }
            }
        }
        return sum;
    }

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/xing-cheng-liang-ge-yi-huo-xiang-deng-sh-jud0/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *     			解答成功:
     * 				执行耗时:2 ms,击败了56.60% 的Java用户
     * 				内存消耗:36.3 MB,击败了28.30% 的Java用户
     *
     * @param arr
     * @return
     */
    public int countTripletsII(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0, s = 0;
        for (int k = 0; k < n; ++k) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        return ans;
    }


}
