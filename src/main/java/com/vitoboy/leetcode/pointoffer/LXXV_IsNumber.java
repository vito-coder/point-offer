package com.vitoboy.leetcode;



/**
 * @Author: vito
 * @Date: 2020/8/11 22:35
 * @Version: 1.0
 *
 * 面试题20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class LXXV_IsNumber {

    public static void main(String[] args) {
        LXXV_IsNumber number = new LXXV_IsNumber();
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
