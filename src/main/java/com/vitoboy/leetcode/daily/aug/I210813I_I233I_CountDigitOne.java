package com.vitoboy.leetcode.daily.aug;

/**
 * @problem leetcode
 * @description 233.数字1的个数
 * 
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
 *
 *  示例 1：
 * 输入：n = 13
 * 输出：6
 *  
 * 
 *  示例 2：
 * 输入：n = 0
 * 输出：0
 *
 *  提示：
 *  0 <= n <= 2 * 10^9
 *  
 *  Related Topics 递归 数学 动态规划 
 *  👍 266 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/13
 */
public class I210813I_I233I_CountDigitOne {
    public static void main(String[] args) {
        I210813I_I233I_CountDigitOne digitOne = new I210813I_I233I_CountDigitOne();
        System.out.println(digitOne.countDigitOne(123));
        System.out.println("expect is : 57");
        System.out.println(digitOne.countDigitOne(13));
        System.out.println("expect is : 6");
        System.out.println(digitOne.countDigitOne(100));
        System.out.println("expect is : 21");
        System.out.println(digitOne.countDigitOne(1000));
        System.out.println("expect is : 301");
        System.out.println(digitOne.countDigitOne(10000));
        System.out.println("expect is : 40001");
        System.out.println(digitOne.countDigitOne(103));
        System.out.println("expect is : 25");
        System.out.println(digitOne.countDigitOne(234));
        System.out.println("expect is : 154");
        System.out.println(digitOne.countDigitOne(98999999));
        System.out.println("expect is : 79400000");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:34.9 MB,击败了93.62% 的Java用户
     *
     * 时间复杂度: O(lgN)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int time = 1, ans = 0;
        if (n % 10 >= 1) ans = 1;
        int tmp = n / 10;
        while (tmp > 0) {
            int remain = tmp % 10;
            time = time*10;
            if(remain == 0) {
                tmp = tmp /10;
                continue;
            } else if (remain == 1) {
                ans += n % time + 1;
            } else {
                ans += time;
            }
            ans += remain*count(time-1);
            tmp = tmp / 10;
        }

        return ans;
    }

    private int count(int nineTime) {
        switch (nineTime) {
            case 0 : return 0;
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 : return 1;
            case 99 : return 20;
            case 999 : return 300;
            case 9999 : return 4000;
            case 99999 : return 50000;
            case 999999 : return 600000;
            case 9999999 : return 7000000;
            case 99999999 : return 80000000;
            case 999999999 : return 900000000;
            default:return 0;
        }
    }
}
