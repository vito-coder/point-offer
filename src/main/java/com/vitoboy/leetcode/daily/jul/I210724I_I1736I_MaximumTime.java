package com.vitoboy.leetcode.daily.jul;

/**
 * @problem leetcode
 * @description 1736.替换隐藏数字得到的最晚时间
 * 
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。 
 * 
 *  有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。 
 * 
 *  替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。 
 *
 *  示例 1：
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 *
 *  示例 2：
 * 输入：time = "0?:3?"
 * 输出："09:39"
 *
 *  示例 3：
 * 输入：time = "1?:22"
 * 输出："19:22"
 *
 *  提示：
 *  time 的格式为 hh:mm 
 *  题目数据保证你可以由输入的字符串生成有效的时间 
 *  
 *  Related Topics 字符串 
 *  👍 46 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/24
 */
public class I210724I_I1736I_MaximumTime {
    public static void main(String[] args) {
        I210724I_I1736I_MaximumTime time = new I210724I_I1736I_MaximumTime();
        String t = "2?:?0";
        System.out.println(time.maximumTime(t));
        System.out.println("expect is : 23:50");
        t = "0?:3?";
        System.out.println(time.maximumTime(t));
        System.out.println("expect is : 09:39");
        t = "1?:22";
        System.out.println(time.maximumTime(t));
        System.out.println("expect is : 19:22");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了48.51% 的Java用户
     * 				内存消耗:36.9 MB,击败了13.18% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {
        String[] split = time.split(":");
        StringBuilder newTime = new StringBuilder();
        char c = ' ';
        if (split[0].equals("??")) {
            newTime.append("23");
        } else if (split[0].startsWith("?")) {
            c = split[0].charAt(1);
            if (c <= '3') {
                newTime.append("2");
            } else {
                newTime.append("1");
            }
            newTime.append(c);
        } else if (split[0].endsWith("?")) {
            c = split[0].charAt(0);
            newTime.append(c);
            if (c == '2') {
                newTime.append('3');
            } else {
                newTime.append('9');
            }
        } else {
            newTime.append(split[0]);
        }
        newTime.append(":");
        if (split[1].equals("??")) {
            newTime.append("59");
        } else if (split[1].startsWith("?")) {
            newTime.append("5").append(split[1].charAt(1));
        } else if (split[1].endsWith("?")) {
            newTime.append(split[1].charAt(0)).append('9');
        } else {
            newTime.append(split[1]);
        }
        return newTime.toString();
    }
}
