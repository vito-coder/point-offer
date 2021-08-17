package com.vitoboy.leetcode.tags.dp.hard;

/**
 * @problem leetcode
 * @description 10.正则表达式
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
 *
 *  '.' 匹配任意单个字符 
 *  '*' 匹配零个或多个前面的那一个元素 
 *
 *  所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
 *
 *  示例 1：
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *  
 * 
 *  示例 2:
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *  
 * 
 *  示例 3：
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *  
 * 
 *  示例 4：
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *  
 * 
 *  示例 5：
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false 
 *
 *  提示：
 *  0 <= s.length <= 20 
 *  0 <= p.length <= 30 
 *  s 可能为空，且只包含从 a-z 的小写字母。 
 *  p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
 *  保证每次出现字符 * 时，前面都匹配到有效的字符 
 *  
 *  Related Topics 递归 字符串 动态规划 
 *  👍 2298 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/13
 */
public class I10I_IsMatch {
    public static void main(String[] args) {
        I10I_IsMatch match = new I10I_IsMatch();
        String s = "aa", p = "a";
        System.out.println(match.isMatch(s, p));
        System.out.println("expect is : false");
        s = "aa";
        p = "a*";
        System.out.println(match.isMatch(s, p));
        System.out.println("expect is : true");
        s = "ab";
        p = ".*";
        System.out.println(match.isMatch(s, p));
        System.out.println("expect is : true");
        s = "aab";
        p = "c*a*b";
        System.out.println(match.isMatch(s, p));
        System.out.println("expect is : true");
    }


    /**
     * todo
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) return false;
        if (p.contains(".*")) return true;
        while (p.startsWith("*")) {
            p = p.substring(1);
        }
        if (p.length() == 0) return false;
        int pi = 0, pl = p.length();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (pi >= pl) return false;
            char pc = p.charAt(pi);
            if (pc == '.') {
                pi++;
                continue;
            }
            if (pc == '*') {
                if (p.charAt(pi - 1) != s.charAt(i)) {
                    return isMatch(s, p.substring(1));
                }
            } else if (pc != s.charAt(i)){
                return isMatch(s, p.substring(1));
            }
            pi++;
        }

        return true;
    }
}
