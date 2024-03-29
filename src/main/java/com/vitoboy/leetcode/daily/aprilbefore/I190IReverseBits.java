package com.vitoboy.leetcode.daily.aprilbefore;

/**
 *颠倒给定的 32 位无符号整数的二进制位。 
 *
 * 
 *
 * 提示： 
 *
 * 
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
 *还是无符号的，其内部的二进制表示形式都是相同的。 
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -10737418
 *25。 
 *
 *
 * 进阶: 
 *如果多次调用这个函数，你将如何优化你的算法？ 
 *
 * 示例 1：
 *输入：n = 00000010100101000001111010011100
 *输出：964176192 (00111001011110000010100101000000)
 *解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
 *
 * 示例 2：
 *输入：n = 11111111111111111111111111111101
 *输出：3221225471 (10111111111111111111111111111111)
 *解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
 *
 * 
 *
 * 提示：
 * 输入是一个长度为 32 的二进制字符串 
 * 
 * Related Topics 位运算 
 * 👍 345 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/3/29 下午6:19
 * @Version: 1.0
 */
public class I190IReverseBits {
    // 待解决问题
    public static void main(String[] args) {
        ReverseBitsInterface bits = new ReverseBits();
        System.out.println(43261596 ^ 43261595);
        System.out.println(bits.reverseBits(43261596));
        System.out.println("expect is : 964176192");
        System.out.println(bits.reverseBits(-3));
        System.out.println("expect is : -1073741825");


    }

    interface ReverseBitsInterface{
        int reverseBits(int n);
    }

    static class ReverseBits implements ReverseBitsInterface {

        /**
         * 				解答成功:
         * 				执行耗时:1 ms,击败了100.00% 的Java用户
         * 				内存消耗:38.2 MB,击败了43.43% 的Java用户
         * 时间复杂度: O(1)
         * 空间复杂度: O(1)
         *
         * @param n
         * @return
         */
        @Override
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                int bit = n & 1;
                n = n >>> 1;
                res = (res << 1) + bit;
            }
            return res;
        }
    }

}
