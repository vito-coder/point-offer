package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/28 19:01
 * @Version: 1.0
 *
 * 剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 *
 *
 */
public class XVIII_IsMatch {
    public static void main(String[] args) {
        XVIII_IsMatch match = new XVIII_IsMatch();
//        System.out.println(match.isMatch("aa", "a"));
        System.out.println(match.isMatch("aa", "aa"));
//        System.out.println(match.isMatch("aa", "a*"));
        System.out.println(match.isMatch("ab", ".*"));
        System.out.println(match.isMatch("ab", ".*c"));
//        System.out.println(match.isMatch("aab", "c*a*b"));
//        System.out.println(match.isMatch("mississippi", "mis*is*p*."));
        // "mississippi"
        //"mis*is*ip*."
//        System.out.println(match.isMatch("mississippi", "mis*is*ip*."));

    }

    /**
     * 状态信息:
     * 匹配成功几个字符--succ
     * 上一次匹配成功的字符--prec
     * 除第一个匹配成功的字符外, 第二个匹配第一个字符成功的位置--secindex
     *
     *
     *
     *
     * 算法
     * 1.取p字符串的第 i 个字符 pi
     * 2.判断是否为'.'字符么?
     *      是, 判断succ < s字符串的长度, 且 i<p.lenth - 2,
     *          是, 保存已经匹配的状态信息(succ++, ), 取p字符串的第 i+1 个字符, 执行第1步
     *          不是, 返回true
     *      不是, 执行第3步
     * 3.判断是否为'*'字符么?
     *      是, 判断 succ < s字符串的长度, 且 ( prec =?= s(succ) || prec == '.')
     *          是, 保存已经匹配的状态信息(succ++, ), 取p字符串的第 i+1 个字符, 执行第1步
     *          不是
     *      不是,执行第4步
     * 4.判断pi字符 == s(succ)?
     *      相等,
     *      不相等,
     *
     * @param s     源字符串
     * @param p     匹配的字符串
     * @return
     *  返回匹配的结果
     */
    public boolean isMatch(String s, String p) {
        if (s == null ) return false;
        if (s.length() == 0 && p != null) return true;
        if (p == null) return false;
        int n = s.length(), m = p.length();
        int[] buff = new int[]{0,0,0};
        for (int i = 0; i < m; i++) {
            if (buff[0] < n) {
                char pic = p.charAt(i);
                if (pic == '*') {
                    // 匹配成功的上一个字符值为0, 说明没有匹配成功过, 直接下一次匹配
                    if (buff[1] == 0) continue;
                    // 匹配成功状态数组的上一个字符值不为0, 说明已经匹配成功过一次
                    // 取上次匹配成功的字符值, 与下次要匹配的字符比较
                    pic = (char) buff[1];
                    boolean loop = true;
                    while (loop) {
                        if (buff[0] >= n) break;
                        if (pic == '.') {
                            buff[0]++;
                            buff[1] = pic;
                            if (buff[2] == 0 && buff[0] > 1) buff[2] = i ;
                            i++;
                            if (i<m) {
                                pic = p.charAt(i);
                                if (pic == '*') {i--;loop = false; break;}
                            }
                            continue;
                        }
                        if (pic == s.charAt(buff[0])) {
                            buff[0]++;
                            buff[1] = pic;
                            if (buff[2] == 0 && buff[0] > 1) buff[2] = i ;
                            i++;
                            if (i<m) {
                                pic = p.charAt(i);
                                if (pic == '*') {i--;loop = false; break;}
                            }
                        } else {
                            // 之前记录的相同
                            loop = false;
                            if (buff[2] != 0) {
                                buff[0] = 1;
                                buff[1] = p.charAt(buff[2]);
                                i = buff[2];
                                buff[2] = 0;
                                pic = p.charAt(i);
                                if (pic == '*') { i--;break;}
                            } else {
                                buff[0] = 0;
                                buff[1] = 0;
                            }
                        }
                    }
                    if (loop) return true;
                    continue;
                }
                if (pic == '.') {
                    buff[0]++;
                    buff[1] = pic;
                    if (buff[2] == 0 && buff[0] > 1) buff[2] = i ;
                    continue;
                }
                if (pic == s.charAt(buff[0])) {
                    buff[0]++;
                    buff[1] = pic;
                    if (buff[2] == 0 && buff[0] > 1) buff[2] = i ;
                } else {
                    // 之前记录的相同
                    if (buff[2] != 0) {
                        buff[0] = 1;
                        buff[1] = p.charAt(buff[2]);
                        i = buff[2];
                        buff[2] = 0;
                    } else {
                        buff[0] = 0;
                        buff[1] = 0;
                    }
                }
            }else return true;
        }
        if (buff[0] == n ) return true;
        return false;
    }
}
