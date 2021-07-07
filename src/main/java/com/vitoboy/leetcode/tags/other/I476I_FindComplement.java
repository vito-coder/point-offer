package com.vitoboy.leetcode.tags.other;

/**
 * 
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。 
 *
 *  示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *  
 * 
 *  示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *  提示：
 *  给定的整数 num 保证在 32 位带符号整数的范围内。 
 *  num >= 1 
 *  你可以假定二进制数不包含前导零位。 
 *  本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同 
 *  
 *  Related Topics 位运算 
 *  👍 214 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I476I_FindComplement {
    public static void main(String[] args) {
        I476I_FindComplement complement = new I476I_FindComplement();
        System.out.println(complement.findComplement(1));
        System.out.println("expect is : 0");
        System.out.println(complement.findComplement(5));
        System.out.println("expect is : 2");
        System.out.println(complement.findComplement(15));
        System.out.println("expect is : 0");
        System.out.println(complement.findComplement(63));
        System.out.println("expect is : 0");

    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35 MB,击败了89.02% 的Java用户
     *
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int tmp = num, base = 0;
        while (tmp > 0) {
            base = (base << 1) + 1;
            tmp = tmp >> 1;
        }
        return num ^ base;
    }
}
