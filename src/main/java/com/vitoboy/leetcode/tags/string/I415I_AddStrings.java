package com.vitoboy.leetcode.tags.string;

import com.sun.deploy.util.StringUtils;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
 *
 *  提示：
 *  num1 和num2 的长度都小于 5100 
 *  num1 和num2 都只包含数字 0-9 
 *  num1 和num2 都不包含任何前导零 
 *  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
 *  
 *  Related Topics 数学 字符串 模拟 
 *  👍 387 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I415I_AddStrings {
    public static void main(String[] args) {
        I415I_AddStrings strings = new I415I_AddStrings();
        String num1 = "0", num2 = "0";
        System.out.println(strings.addStrings(num1, num2));

    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了99.72% 的Java用户
     * 				内存消耗:38.1 MB,击败了94.09% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int len = Math.max(l1, l2);
        char[] chars = new char[]{'0', '0'};
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            if (l1 > i && l2 > i) {
                chars = add(num1.charAt(l1-i-1), num2.charAt(l2-i-1), chars[0]);
                str.append(chars[1]);
                continue;
            }
            if (l1 > i) {
                chars = add(num1.charAt(l1-i-1), chars[0], '0');
                str.append(chars[1]);
                continue;
            }
            if (l2 > i) {
                chars = add(num2.charAt(l2-i-1), chars[0], '0');
                str.append(chars[1]);
            }
            if (i == len) {
                chars = add('0', chars[0], '0');
                if (chars[1] > '0') str.append(chars[1]);
            }
        }
        return str.reverse().toString();
    }

    private char[] add(char c1, char c2, char c3) {
        char[] chars = new char[2];
        int res = (c1 - '0') + (c2 - '0') + (c3 - '0');
        if (res >= 10) {
            chars[0] = '1';
            chars[1] = (char)(res % 10 + '0');
        } else {
            chars[0] = '0';
            chars[1] = (char)(res + '0');
        }
        return chars;
    }
}
