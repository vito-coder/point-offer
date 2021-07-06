package com.vitoboy.leetcode.tags.string;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
 * 
 *  示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *  
 * 
 *  示例 2:
 * 输入: "aba"
 * 输出: False
 *  
 * 
 *  示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *  
 *  Related Topics 字符串 字符串匹配 
 *  👍 508 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/6
 */
public class I459I_RepeatedSubStringPattern {
    public static void main(String[] args) {
        I459I_RepeatedSubStringPattern pattern = new I459I_RepeatedSubStringPattern();
        String s = "abab";
        System.out.println(pattern.repeatedSubstringPatternII(s));
        System.out.println("expect is : true");
        s = "aba";
        System.out.println(pattern.repeatedSubstringPatternII(s));
        System.out.println("expect is : false");
        s = "abcabcabcabc" ;
        System.out.println(pattern.repeatedSubstringPatternII(s));
        System.out.println("expect is : true");
        s = "aa" ;
        System.out.println(pattern.repeatedSubstringPatternII(s));
        System.out.println("expect is : true");

    }

    /**
     * 				解答成功:
     * 				执行耗时:67 ms,击败了49.75% 的Java用户
     * 				内存消耗:39 MB,击败了39.84% 的Java用户
     *
     * 时间复杂度: O(N) ?
     * 空间复杂度: O(N) ?
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        for (int i = 1, len = s.length()/2; i <= len; i++) {
            String sub = s.substring(0, i);
            if(s.length() % sub.length() != 0) continue;
            boolean res = false;
            for (int j = sub.length(), subl = sub.length(), sl = s.length(); j+subl <= sl; j=j+subl) {
                if (!sub.equals(s.substring(j, j+subl))){
                    res = false;
                    break;
                }else {
                    res = true;
                }
            }
            if (res) return true;
        }
        return false;
    }


    /**
     * 				解答成功:
     * 				执行耗时:13 ms,击败了72.19% 的Java用户
     * 				内存消耗:39.1 MB,击败了21.78% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * 参考官方题解
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatternII(String s) {
        if (s == null || s.length() < 2) return false;
        boolean res = false;
        for (int i = 1, len = s.length(); i*2 <= len; i++) {
            if (len % i != 0) continue;
            for (int j = i; j < len;) {
                int k = 0;
                while (k<i) {
                    if (s.charAt(k) != s.charAt(j+k)){
                        res = false;
                        break;
                    } else {
                        res = true;
                    }
                    k++;
                }
                if (res) j+=i;
                else break;
            }
            if (res) return res;
        }
        return res;
    }
}
