package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
 *
 *  如果剩余字符少于 k 个，则将剩余字符全部反转。 
 *  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
 *
 *  示例:
 *  输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 *  提示：
 *  该字符串只包含小写英文字母。 
 *  给定字符串的长度和 k 在 [1, 10000] 范围内。 
 *  
 *  Related Topics 双指针 字符串 
 *  👍 130 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/12
 */
public class I541I_ReverseStr {
    public static void main(String[] args) {
        I541I_ReverseStr str = new I541I_ReverseStr();
        System.out.println(str.reverseStr("abcdefg", 2));
        System.out.println("expect is : bacdfeg");
        System.out.println(str.reverseStr("abcdefg", 8));
        System.out.println("expect is : gfedcba");
    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.52% 的Java用户
     * 				内存消耗:38.6 MB,击败了26.22% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        char tmp = ' ';
        for (int i = 0, len = chars.length; i < len; i+=2*k) {
            if (i+k <= len) {
                int des = i+k-1;
                for (int j = i; j < i+k/2; j++, des--) {
                    tmp = chars[j];
                    chars[j] = chars[des];
                    chars[des] = tmp;
                }
            } else {
                int des = len-1;
                for (int j = i; j < i+(len-i)/2; j++,des--) {
                    tmp = chars[j];
                    chars[j] = chars[des];
                    chars[des] = tmp;
                }
            }
        }

        return new String(chars);
    }
}
