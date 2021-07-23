package com.vitoboy.leetcode.tags.string;

/**
 * @problem leetcode
 * @description 551.学生出勤记录I
 * 
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
 *
 *  'A' : Absent，缺勤 
 *  'L' : Late，迟到 
 *  'P' : Present，到场 
 *
 *  如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
 * 
 *  你需要根据这个学生的出勤记录判断他是否会被奖赏。 
 * 
 *  示例 1:
 *  输入: "PPALLP"
 * 输出: True
 *
 *  示例 2:
 *  输入: "PPALLL"
 * 输出: False
 *  
 *  Related Topics 字符串 
 *  👍 76 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/23
 */
public class I551I_CheckRecord {
    public static void main(String[] args) {
        I551I_CheckRecord record = new I551I_CheckRecord();
        String s = "PPALLP";
        System.out.println(record.checkRecordII(s));
        System.out.println("expect is : true");
        s = "PPALLL";
        System.out.println(record.checkRecordII(s));
        System.out.println("expect is : false");
        s = "PPALLA";
        System.out.println(record.checkRecordII(s));
        System.out.println("expect is : false");
        s = "PPALLPLLPLLPLLP";
        System.out.println(record.checkRecordII(s));
        System.out.println("expect is : true");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.3 MB,击败了86.35% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int lateCount = 0, absentCount =0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A':
                    if (absentCount > 0) return false;
                    absentCount++;
                    lateCount = 0;
                    break;
                case 'L':
                    if (lateCount >= 2) return false;
                    lateCount++;
                    break;
                default:
                    lateCount = 0;
            }
        }
        return true;
    }

    /**
     * 官方题解之一
     *
     * @param s
     * @return
     */
    public boolean checkRecordII(String s) {
        return !((s.indexOf('A') != s.lastIndexOf('A')) || (s.indexOf("LLL") != -1));
    }
}
