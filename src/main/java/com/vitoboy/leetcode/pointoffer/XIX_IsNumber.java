package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/28 19:03
 * @Version: 1.0
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class XIX_IsNumber {

    public static void main(String[] args) {
        XIX_IsNumber number = new XIX_IsNumber();
        String[] test = new String[]{"+100","5e2","-123","3.1416","-1E-16","0123", "00000", "1 ", ".1", "1.234",
                "-123.123", "+213e234"};
        for (String num : test) {
            System.out.println(number.isNumber(num));
        }

        test = new String[] {"12e","1a3.14","1.2.3","+-5","12e+5.4", "..2", "2..","-.123"};
        System.out.println("===================");
        for (String num : test) {
            System.out.println(number.isNumber(num));
        }

    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] chars = s.trim().toCharArray();
        char zero = '0', nine = '9';
        boolean hasE = false;
        boolean hasPoint = false;
        boolean num = false;
        for (int i = 0; i < chars.length; i++) {
            char ci = chars[i];
            if (ci == '+' || ci == '-') {
                if (i == 0) {
                    continue;
                } else {
                    if (chars[i-1] == 'e' || chars[i-1] == 'E') continue;
                    else return false;
                }
            } else if (ci == '.') {
                if (hasE) return false;
                if (i > 0 && chars[i-1] >= zero && chars[i-1] <= nine && !hasPoint && num) {
                    hasPoint = true;
                    continue;
                }else if (i == 0){
                    hasPoint = true;
                    continue;
                } else {
                    return false;
                }
            } else if (ci == 'E' || ci == 'e') {
                if (i > 0 && chars[i-1] >= zero && chars[i-1] <= nine && !hasE && num) {
                    hasE = true;
                    if (i == chars.length-1) return false;
                    continue;
                } else {
                    return false;
                }
            } else if (ci >= zero && ci <= nine){
                num = true;
            } else {
                return false;
            }
        }
        return num;
    }
}
