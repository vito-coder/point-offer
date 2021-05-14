package com.vitoboy.leetcode.daily;

import java.util.Arrays;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
 * 
 *  它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
 * ，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
 * 
 *  给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 *  
 * 
 *  示例 2： 
 * 
 *  输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  3 <= n < 105 
 *  n 是奇数。 
 *  encoded.length == n - 1 
 *  
 *  Related Topics 位运算 
 *  👍 86 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/11 下午4:12
 * @Version: 1.0
 */
public class I1734IDecode {
    public static void main(String[] args) {

        System.out.println(1^2);
        System.out.println(2^3);
        int[] encode = new int[]{3,1};
        System.out.println(Arrays.toString(decode(encode)));
        encode = new int[]{6,5,4,6};
        System.out.println(Arrays.toString(decode(encode)));
        encode = new int[]{2,1};
        System.out.println(Arrays.toString(decode(encode)));
    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了98.67% 的Java用户
     * 				内存消耗:59.6 MB,击败了92.67% 的Java用户
     *
     * @param encoded
     * @return
     */
    public static int[] decode(int[] encoded) {
        int[] decode = new int[encoded.length + 1];
        int total = 0;
        for (int i = 1; i <= decode.length; i++) {
            total ^= i;
        }
        // 除第一个元素外的其它元素的异或值
        int exclude = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            exclude ^= encoded[i];
        }
        // 得到第一个元素
        decode[0] = total ^ exclude;
        for (int i = 1; i < decode.length; i++) {
            decode[i] = decode[i-1] ^ encoded[i-1];
        }
        return decode;

    }


    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了30.00% 的Java用户
     * 				内存消耗:59.5 MB,击败了97.33% 的Java用户
     *
     * 				解答成功:
     * 				执行耗时:3 ms,击败了98.67% 的Java用户
     * 				内存消耗:59.8 MB,击败了72.00% 的Java用户
     *
     * @param encoded
     * @return
     */
    public static int[] decodeII(int[] encoded) {
        int length = encoded.length + 1;
        //把1到n中间的所有数字都异或一遍
        int allXor = ((length + 1) / 2) % 2;
        int even = 0;
        //数组encoded中第偶数个元素都异或一遍
        for (int i = 1; i < length - 1; i += 2) {
            even ^= encoded[i];
        }

        int[] res = new int[length];
        //求出第一个值，后面就简单了
        res[0] = allXor ^ even;
        for (int i = 0; i < length - 1; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }
}
