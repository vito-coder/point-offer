package com.vitoboy.leetcode.tags.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem leetcode 
 * @description 6.Z字形变换
 * 
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 *  比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R 
 * 
 *  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
 * 
 *  请你实现这个将字符串进行指定行数变换的函数： 
 *
 * string convert(string s, int numRows); 
 *
 *  示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *  
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *  示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *  提示：
 *  1 <= s.length <= 1000 
 *  s 由英文字母（小写和大写）、',' 和 '.' 组成 
 *  1 <= numRows <= 1000 
 *  
 *  Related Topics 字符串 
 *  👍 1234 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/13
 */
public class I6I_Convert {
    public static void main(String[] args) {
        I6I_Convert iConvert = new I6I_Convert();
        System.out.println(iConvert.convert("PAYPALISHIRING", 4));
        System.out.println("expect is : PINALSIGYAHRPI");
        System.out.println(iConvert.convert("PAYPALISHIRING", 3));
        System.out.println("expect is : PAHNAPLSIIGYIR");

    }

    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了69.69% 的Java用户
     * 				内存消耗:38.6 MB,击败了79.77% 的Java用户
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        List<StringBuilder> lists = new ArrayList<>();
        boolean direct = true;
        int col = 0, row = 0;
        for (int i = 0; i < len; i++) {
            if (direct) {
                if (row == numRows-1) {
                    direct = false;
                    StringBuilder builder = lists.size() == numRows ? lists.get(row) : new StringBuilder();
                    builder.append(s.charAt(i));
                    row--;
                    if (lists.size() != numRows) lists.add(builder);
                } else {
                    StringBuilder builder = lists.size() == numRows ? lists.get(row) : new StringBuilder();
                    builder.append(s.charAt(i));
                    row++;
                    if (lists.size() != numRows) lists.add(builder);
                }
            } else {
                if (row == 0) {
                    direct = true;
                    lists.get(row).append(s.charAt(i));
                    row++;
                } else {
                    lists.get(row).append(s.charAt(i));
                    row--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder builder : lists) {
            ans.append(new String(builder));
        }
        return ans.toString();

    }
}
