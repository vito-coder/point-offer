package com.vitoboy.leetcode.daily.jul;

/**
 * @problem leetcode
 * @description 171.表列序号
 * 
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
 *
 *  例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *     ...
 * 
 *  示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 *  
 * 
 *  示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 *  
 * 
 *  示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701 
 * 
 *  示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 *
 *  提示：
 *  1 <= columnTitle.length <= 7 
 *  columnTitle 仅由大写英文组成 
 *  columnTitle 在范围 ["A", "FXSHRXW"] 内 
 *  
 *  Related Topics 数学 字符串 
 *  👍 259 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/30
 */
public class I210730I_I171I_TitleToNumber {
    public static void main(String[] args) {
        I210730I_I171I_TitleToNumber number = new I210730I_I171I_TitleToNumber();
        String columnTitle = "A";
        System.out.println(number.titleToNumber(columnTitle));
        System.out.println("expect is : 1");
        columnTitle = "AB";
        System.out.println(number.titleToNumber(columnTitle));
        System.out.println("expect is : 28");
        columnTitle = "ZY";
        System.out.println(number.titleToNumber(columnTitle));
        System.out.println("expect is : 701");
        columnTitle = "FXSHRXW";
        System.out.println(number.titleToNumber(columnTitle));
        System.out.println("expect is : 2147483647");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.2 MB,击败了83.99% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0, len = columnTitle.length(); i < len; i++) {
            int ci = getCharInt(columnTitle.charAt(i));
            ans = ans * 26 + (ci);
        }
        return ans;
    }

    private int getCharInt(char c) {
        return c - 'A' + 1;
    }
}
