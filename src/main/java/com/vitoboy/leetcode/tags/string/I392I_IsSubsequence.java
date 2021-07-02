package com.vitoboy.leetcode.tags.string;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
 * 
 *  字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
 * c"不是）。 
 * 
 *  进阶：
 *  如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
 * 码？ 
 * 
 *  致谢：
 *  特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
 *
 *  示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 *  提示：
 *  0 <= s.length <= 100 
 *  0 <= t.length <= 10^4 
 *  两个字符串都只由小写字符组成。 
 *  
 *  Related Topics 双指针 字符串 动态规划 
 *  👍 467 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I392I_IsSubsequence {
    public static void main(String[] args) {
        I392I_IsSubsequence subsequence = new I392I_IsSubsequence();
        String s = "abc", t = "ahbgdc";
        System.out.println(subsequence.isSubsequence(s, t));
        System.out.println("expect is : true");
        s = "axc"; t = "ahbgdc";
        System.out.println(subsequence.isSubsequence(s, t));
        System.out.println("expect is : false");

    }

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了49.53% 的Java用户
     * 				内存消耗:36.3 MB,击败了62.13% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int sl = s.length(), tl = t.length(), sidx = 0;
        for (int i = 0; i < tl; i++) {
            if (sidx < sl) {
                if (t.charAt(i) == s.charAt(sidx)) {
                    sidx++;
                }
            } else {
                return true;
            }
        }
        return sidx == sl;
    }
}
