package com.vitoboy.leetcode.tags.string;

import java.util.Arrays;

/**
 * 
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
 * 
 *  不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
 * 
 *  你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
 * 
 *  示例 1： 
 *  输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *  
 * 
 *  示例 2： 
 *  输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"] 
 *  Related Topics 递归 双指针 字符串 
 *  👍 420 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I344I_ReverseString {
    public static void main(String[] args) {
        I344I_ReverseString reverseString = new I344I_ReverseString();
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
        System.out.println("expcet is : ['o','l','l','e','h']");
        s = new char[]{'H','a','n','n','a','h'};
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
        System.out.println("expcet is : ['h','a','n','n','a','H']");

    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:45 MB,击败了63.63% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     */
    public void reverseString(char[] s) {
        char tmp = ' ';
        for (int i = 0, len=s.length-1; i < len; i++, len--) {
            tmp = s[i];
            s[i] = s[len];
            s[len] = tmp;
        }
    }
}
