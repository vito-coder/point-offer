package com.vitoboy.leetcode.tags.string;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。 
 * 
 *  字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
 * 
 *  请找出在 t 中被添加的字母。 
 *
 * 
 *  示例 1：
 *  输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *  
 * 
 *  示例 2：
 *  输入：s = "", t = "y"
 * 输出："y"
 *  
 * 
 *  示例 3：
 *  输入：s = "a", t = "aa"
 * 输出："a"
 *  
 * 
 *  示例 4：
 *  输入：s = "ae", t = "aea"
 * 输出："a"
 * 
 *  提示：
 *  0 <= s.length <= 1000 
 *  t.length == s.length + 1 
 *  s 和 t 只包含小写字母 
 *  
 *  Related Topics 位运算 哈希表 字符串 排序 
 *  👍 264 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I389I_FindTheDifference {
    public static void main(String[] args) {
        I389I_FindTheDifference difference = new I389I_FindTheDifference();
        String s = "a", t = "ab";
        System.out.println(difference.findTheDifferenceBit(s, t));
        System.out.println("expect is : 'b'");
        s = "abcd"; t = "abcde";
        System.out.println(difference.findTheDifferenceBit(s, t));
        System.out.println("expect is : 'e'");
        s = ""; t = "a";
        System.out.println(difference.findTheDifferenceBit(s, t));
        System.out.println("expect is : 'a'");
        s = "a"; t = "aa";
        System.out.println(difference.findTheDifferenceBit(s, t));
        System.out.println("expect is : 'a'");
        s = "ae"; t = "aea";
        System.out.println(difference.findTheDifferenceBit(s, t));
        System.out.println("expect is : 'a'");
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了80.55% 的Java用户
     * 				内存消耗:36.6 MB,击败了87.26% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        int[] schar = new int[26], tchar = new int[26];
        for (int i = 0, len = t.length(), sl = s.length(); i < len; i++) {
            if (sl > i) {
                schar[s.charAt(i)-'a']++;
            }
            tchar[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (schar[i] != tchar[i]) return (char)('a'+i);
        }
        return ' ';
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了80.55% 的Java用户
     * 				内存消耗:36.6 MB,击败了90.87% 的Java用户
     *
     * 和求解
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceSum(String s, String t) {
        int ssum = 0, tsum = 0;
        for (int i = 0, len = t.length(), sl = s.length(); i < len; i++) {
            if (sl > i) {
                ssum += s.charAt(i);
            }
            tsum += t.charAt(i);
        }
        return (char)(tsum-ssum);
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了80.55% 的Java用户
     * 				内存消耗:36.6 MB,击败了92.63% 的Java用户
     *
     * 位运算
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceBit(String s, String t) {
        int res = t.charAt(t.length()-1);
        for (int i = 0, sl = s.length(); i < sl; i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return (char)res;
    }
}
