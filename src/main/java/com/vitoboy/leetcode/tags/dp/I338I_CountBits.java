package com.vitoboy.leetcode.tags.dp;

import java.util.Arrays;

/**
 * 
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
 * 
 *  示例 1: 
 * 
 *  输入: 2
 * 输出: [0,1,1] 
 * 
 *  示例 2: 
 * 
 *  输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 *  输入: 10
 *  输出: [0,1,1,2,1,2,2,3,1,2,2]
 * 
 *  进阶: 
 * 
 *  
 *  给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
 *  要求算法的空间复杂度为O(n)。 
 *  你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
 *  
 *  Related Topics 位运算 动态规划 
 *  👍 734 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/25
 */
public class I338I_CountBits {

    public static void main(String[] args) {
        I338I_CountBits countBits = new I338I_CountBits();
        System.out.println("result is : " + Arrays.toString(countBits.countBits(2)));
        System.out.println("expect is : [0,1,1]");
        System.out.println("result is : " + Arrays.toString(countBits.countBits(5)));
        System.out.println("expect is : [0,1,1,2,1,2] ");
        System.out.println("result is : " + Arrays.toString(countBits.countBits(10)));
        System.out.println("expect is : [0,1,1,2,1,2,2,3,1,2,2]");

    }


    /**
     * n[i] = n[i/2]+i%2
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.95% 的Java用户
     * 				内存消耗:42.7 MB,击败了47.79% 的Java用户
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i/2] + i%2;
        }
        return res;
    }


    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.95% 的Java用户
     * 				内存消耗:42.4 MB,击败了91.97% 的Java用户
     *
     * @param num
     * @return
     */
    public int[] countBitsII(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }


}
