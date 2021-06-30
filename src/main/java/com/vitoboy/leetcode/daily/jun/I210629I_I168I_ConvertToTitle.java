package com.vitoboy.leetcode.daily.jun;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
 * 
 *  例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 *
 * 
 *  示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 *  
 * 
 *  示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 *  
 * 
 *  示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 *  
 * 
 *  示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *
 * 
 *  提示：
 *  1 <= columnNumber <= 2^(31 - 1)
 *  
 *  Related Topics 数学 字符串 
 *  👍 402 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/29
 */
public class I210629I_I168I_ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(701/26);
        I210629I_I168I_ConvertToTitle convertToTitle = new I210629I_I168I_ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(2147483647));

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.6 MB,击败了56.23% 的Java用户
     *
     * 时间复杂度: O(log26 N)
     * 空间复杂度: O(log26 N)
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        int remainder = 0;
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            remainder = (columnNumber-1) % 26;
            columnNumber = (columnNumber-1) / 26;
            builder.append((char)(remainder + 'A'));
        }
        return builder.reverse().toString();
    }
    
    
}
