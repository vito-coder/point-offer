package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
 *
 *  示例 1：
 *  输入："hello"
 * 输出："holle"
 *
 *  示例 2：
 *  输入："leetcode"
 * 输出："leotcede" 
 *
 *  提示：
 *  元音字母不包含字母 "y" 。 
 *  
 *  Related Topics 双指针 字符串 
 *  👍 160 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I345I_ReverseVowels {
    public static void main(String[] args) {
        I345I_ReverseVowels reverseVowels = new I345I_ReverseVowels();
        String s = "hello";
        System.out.println(reverseVowels.reverseVowels(s));
        System.out.println("expcet is : holle");
        s = "leetcode";
        System.out.println(reverseVowels.reverseVowels(s));
        System.out.println("expcet is :leotcede");
        s = "goodmorningaaa";
        System.out.println(reverseVowels.reverseVowels(s));
        System.out.println("expect is : gaadmarningooo");
        s = "aA";
        System.out.println(reverseVowels.reverseVowels(s));
        System.out.println("expect is : Aa");
    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了91.47% 的Java用户
     * 				内存消耗:38.6 MB,击败了36.07% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() < 1) return s;
        char[] chars = s.toCharArray();
        boolean low = false, high = false;
        char tmp = ' ';
        for (int i = 0, len = chars.length-1; i < len; ) {
            low = isVowele(chars[i]);
            high = isVowele(chars[len]);
            if (low && high) {
                tmp = chars[i];
                chars[i] = chars[len];
                chars[len] = tmp;
                i++;len--;
                continue;
            }
            if (!low && !high) {
                i++;len--;
                continue;
            }
            if (low) {
                len--;
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    private boolean isVowele(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U': return true;
            default:
                return false;
        }
    }
}
