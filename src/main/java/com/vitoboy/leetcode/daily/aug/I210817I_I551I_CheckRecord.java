package com.vitoboy.leetcode.daily.aug;

/**
 * @problem leetcode
 * @description 551.学生出勤记录 I
 * 
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符： 
 *
 *  'A'：Absent，缺勤 
 *  'L'：Late，迟到 
 *  'P'：Present，到场 
 *
 *  如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
 *
 *  按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
 *  学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。 
 *
 *  如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * 
 *  示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 *  
 * 
 *  示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *
 *  提示：
 *  1 <= s.length <= 1000 
 *  s[i] 为 'A'、'L' 或 'P' 
 *  
 *  Related Topics 字符串 
 *  👍 89 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/17
 */
public class I210817I_I551I_CheckRecord {

    public static void main(String[] args) {
        I210817I_I551I_CheckRecord record = new I210817I_I551I_CheckRecord();
        String s = "PPALLP";
        System.out.println(record.checkRecord(s));
        System.out.println("expect is : true");
        s = "PPALLL";
        System.out.println(record.checkRecord(s));
        System.out.println("expect is : false");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.3 MB,击败了82.79% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        boolean absent = false;
        int lateCount = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if ('A' == s.charAt(i)) {
                if (absent) return false;
                else {
                    absent = true;
                    lateCount = 0;
                }
            } else if ('L' == s.charAt(i)) {
                if (lateCount >= 2) return false;
                else lateCount++;
            } else {
                lateCount = 0;
            }
        }
        return true;
    }
}
