package com.vitoboy.leetcode.daily.may;

import java.util.Stack;

/**
 * 
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
 * 
 *  
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000 
 * 
 *  例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
 * I 。 
 * 
 *  通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 *  减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
 * 
 *  
 *  I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
 *  X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 *  C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
 *  
 * 
 *  给你一个整数，将其转为罗马数字。 
 * 
 *  
 * 
 *  示例 1: 
 * 
 *  
 * 输入: num = 3
 * 输出: "III" 
 * 
 *  示例 2: 
 * 
 *  
 * 输入: num = 4
 * 输出: "IV" 
 * 
 *  示例 3: 
 * 
 *  
 * 输入: num = 9
 * 输出: "IX" 
 * 
 *  示例 4: 
 * 
 *  
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *  
 * 
 *  示例 5: 
 * 
 *  
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4. 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= num <= 3999 
 *  
 *  Related Topics 数学 字符串 
 *  👍 589 👎 0
 * 
 * @Author: vito
 * @Date: 2021/5/14 下午2:50
 * @Version: 1.0
 */
public class I210514I_I12I_IntToRoman {
    public static void main(String[] args) {
        I210514I_I12I_IntToRoman roman = new I210514I_I12I_IntToRoman();
        System.out.println("result is : " + roman.intToRoman(3));
        System.out.println("expect is : 'III'");
        System.out.println("result is : " + roman.intToRoman(4));
        System.out.println("expect is : 'IV'");
        System.out.println("result is : " + roman.intToRoman(9));
        System.out.println("expect is : 'IX'");
        System.out.println("result is : " + roman.intToRoman(58));
        System.out.println("expect is : 'LVIII'");
        System.out.println("result is : " + roman.intToRoman(1994));
        System.out.println("expect is : 'MCMXCIV'");
        System.out.println("result is : " + roman.intToRoman(20));
        System.out.println("expect is : 'XX'");

    }

    /**
     *  				解答成功:
     * 				执行耗时:9 ms,击败了19.10% 的Java用户
     * 				内存消耗:38.2 MB,击败了38.57% 的Java用户
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Stack<String> roman = new Stack<>();
        int level = 1;
        while (num > 0) {
            int digit = num % 10;
            if (level == 1 ) {
                roman.push(getDigitRoman(digit, "I", "V", "X"));
            } else if (level == 10){
                roman.push(getDigitRoman(digit, "X", "L", "C"));
            } else if (level == 100) {
                roman.push(getDigitRoman(digit, "C", "D", "M"));
            } else if (level == 1000) {
                roman.push(getDigitRoman(digit, "M", "", ""));
            }
            num = num / 10;
            level *= 10;
        }
        StringBuilder builder = new StringBuilder();
        while (!roman.isEmpty()) {
            builder.append(roman.pop());
        }
        return builder.toString();
    }

    public String getDigitRoman(int num, String unit, String bigUnit, String levelUnit) {
        StringBuilder builder = new StringBuilder();
        switch (num) {
            case 0: return "";
            case 1:
            case 2:
            case 3:
                while (num > 0) {
                    num--;
                    builder.append(unit);
                }
                return builder.toString();
            case 4: return unit+bigUnit;
            case 5:
            case 6:
            case 7:
            case 8:
                num = num - 5;
                builder.append(bigUnit);
                while (num > 0) {
                    num--;
                    builder.append(unit);
                }
                return builder.toString();
            case 9: return unit+levelUnit;
        }
        return unit;
    }
}
