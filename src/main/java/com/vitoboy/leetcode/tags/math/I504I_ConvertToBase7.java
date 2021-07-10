package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。 
 * 
 *  示例 1:
 * 输入: 100
 * 输出: "202"
 *  
 * 
 *  示例 2:
 * 输入: -7
 * 输出: "-10"
 *  
 * 
 *  注意: 输入范围是 [-1e7, 1e7] 。 
 *  Related Topics 数学 
 *  👍 89 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/9
 */
public class I504I_ConvertToBase7 {
    public static void main(String[] args) {
        I504I_ConvertToBase7 base7 = new I504I_ConvertToBase7();
        System.out.println(base7.convertToBase7(100));
        System.out.println("expect is : 202");
        System.out.println(base7.convertToBase7(-7));
        System.out.println("expect is : -10");
    }

    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了15.67% 的Java用户
     * 				内存消耗:35.9 MB,击败了40.98% 的Java用户
     *
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num > -7 && num < 7) return num+"";
        String mine = "";
        if (num < 0) {
            mine = "-";
            num = -num;
        }
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num >= 7) {
                builder.append(num % 7);
                num = num / 7;
            } else {
                builder.append(num);
                num = 0;
            }
        }

        return mine + builder.reverse() ;
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.5 MB,击败了94.80% 的Java用户
     *
     * 使用类库
     *
     * @param num
     * @return
     */
    public String convertToBase7II(int num) {
        return Integer.toString(num, 7);
    }
    
    
}
