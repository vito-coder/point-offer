package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
 * 
 *  注意:
 *  十六进制中所有字母(a-f)都必须是小写。 
 *  十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 *  给定的数确保在32位有符号整数范围内。 
 *  不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
 *
 *  示例 1：
 * 输入: 26
 * 输出: "1a"
 *
 *  示例 2：
 * 输入: -1
 * 输出: "ffffffff"
 *  
 *  Related Topics 位运算 数学 
 *  👍 140 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I405I_ToHex {
    public static void main(String[] args) {
        I405I_ToHex hex = new I405I_ToHex();
        System.out.println(hex.toHex(-1));
        System.out.println("expect is : ffffffff");
        System.out.println(hex.toHex(26));
        System.out.println("expect is : 1a");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.6 MB,击败了66.82% 的Java用户
     *
     * 时间复杂度: O(log16 N)
     * 空间复杂度: O(1)
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(change(num & 15));
            num = num >>> 4;
        }
        return builder.reverse().toString();
    }

    private char change(int n) {
        if (n < 10) return (char)(n+'0');
        switch (n) {
            case 10: return 'a';
            case 11: return 'b';
            case 12: return 'c';
            case 13: return 'd';
            case 14: return 'e';
            case 15: return 'f';
            default:
                return 'f';
        }
    }
}
