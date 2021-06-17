package com.vitoboy.leetcode.daily.jun;

/**
 * 
 * 有效数字（按顺序）可以分成以下几个部分： 
 *
 *  一个 小数 或者 整数 
 *  （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
 *
 *  小数（按顺序）可以分成以下几个部分： 
 *
 *  （可选）一个符号字符（'+' 或 '-'） 
 *  下述格式之一：
 *  
 *  至少一位数字，后面跟着一个点 '.' 
 *  至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
 *  一个点 '.' ，后面跟着至少一位数字 
 *  
 *
 *  整数（按顺序）可以分成以下几个部分： 
 *
 *  （可选）一个符号字符（'+' 或 '-'） 
 *  至少一位数字 
 *
 *  部分有效数字列举如下： 
 *
 *  ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
 *  "53.5e93", "-123.456e789"] 
 *
 *  部分无效数字列举如下： 
 *
 *  ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
 *
 *  给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
 * 
 *
 *  示例 1：
 * 输入：s = "0"
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：s = "e"
 * 输出：false
 *  
 * 
 *  示例 3：
 * 输入：s = "."
 * 输出：false
 *  
 * 
 *  示例 4：
 * 输入：s = ".1"
 * 输出：true
 *
 * 
 *  提示：
 *  1 <= s.length <= 20 
 *  s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
 *  
 *  Related Topics 数学 字符串 
 *  👍 236 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/16
 */
public class I210617I_I65I_IsNumber {
    public static void main(String[] args) {
        I210617I_I65I_IsNumber number = new I210617I_I65I_IsNumber();
        String[] strings = new String[]{"-234.","0", "234e-234",".1", "2",".234e45", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
                "53.5e93","-123.456e789"};
        System.out.println("result is 'true' : begin");
        for (String string : strings) {
            System.out.println(number.isNumber(string));
        }
        System.out.println("result is 'true' : end");
        System.out.println("\n");
        strings = new String[]{"abc", "1a","e345.3", ".e345","0..", ".-4", "e123E354", "e",".", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        System.out.println("result is 'false': begin");
        for (String string : strings) {
            System.out.println(number.isNumber(string));
        }
        System.out.println("result is 'false' : end");

    }

    /**
     * 				解答成功:
     * 				执行耗时:5 ms,击败了43.00% 的Java用户
     * 				内存消耗:38.2 MB,击败了94.54% 的Java用户
     *
     * 	时间复杂度: O(N) 最少需要遍历一次字符串(String的自还方法不算时间复杂度的话)
     * 	空间复杂度: O(1) 只使用常数变量作为临时变量记录一些信息
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        String[] strings = hasValE(s);
        if(strings == null) return isLittleNumber(s) || isIntNumber(s);
        if (strings.length == 1) {
            return isLittleNumber(s) || isIntNumber(s);
        } else if(strings.length == 2) {
            return (isLittleNumber(strings[0]) || isIntNumber(strings[0])) && isIntNumber(strings[1]);
        }
        return false;
    }

    private boolean isLittleNumber(String s) {
        if (s.indexOf('.') >= 0 && s.indexOf('.',s.indexOf('.')+1) < 0) {
            String[] strings = s.split("\\.");
            if(strings.length == 1) {
                return isIntNumber(strings[0]);
            }
            if(strings.length > 2 || strings.length <= 0) {
                return false;
            }
            if(strings[0].length() == 0) {
                return isIntNumber(strings[1]) && !isOperator(strings[1].charAt(0));
            } else if(strings[0].length() == 1 ) {
                char c = strings[0].charAt(0);
                if (isOperator(c) && isIntNumber(strings[1])) {
                    return true;
                } else if (isDigit(c)){
                    if (strings[1].length() == 0) return true;
                    return isIntNumber(strings[1]);
                }
            } else {
                if (strings[1].length() == 0) return isIntNumber(strings[0]);
                return isIntNumber(strings[0]) && isIntNumber(strings[1]);
            }
        }
        return false;
    }

    private boolean isIntNumber(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return isDigit(s.charAt(0));
        char c = s.charAt(0);
        if (isDigit(c) || isOperator(c)) {
            char[] chars = s.toCharArray();
            for (int i=1; i<chars.length; i++) {
                if (!isDigit(chars[i])) return false;
            }
            return true;
        }
        return false;
    }

    private String[] hasValE(String s) {
        int index = s.indexOf('E');
        if (index < 0) {
            index = s.indexOf('e');
            if (index < 0) return null;
            if (s.indexOf('e', index+1) > 0) return new String[]{"e", "e", "e"};
            return s.split("e");
        } else {
            if (s.indexOf('e') >= 0) return new String[]{"e", "e", "e"};
            if (s.indexOf('E', index+1) >= 0) return new String[]{"e", "e", "e"};
            return s.split("E");
        }
    }

    private boolean isOperator(char c) {
        switch (c) {
            case '+': return true;
            case '-': return true;
            default:
                return false;
        }
    }

    private boolean isDigit(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': return true;
            default:
                return false;
        }
    }
}
