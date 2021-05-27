package com.vitoboy.leetcode.daily.may;

/**
 * 
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
 * 
 *  给出两个整数 x 和 y，计算它们之间的汉明距离。 
 * 
 *  注意： 
 * 0 ≤ x, y < 231. 
 * 
 *  示例: 
 * 
 *  
 * 输入: x = 1, y = 4
 * 
 * 输出: 2
 * 
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 
 * 上面的箭头指出了对应二进制位不同的位置。
 * 汉明距离: 指两个整数异或后, 二进制表示时, 还有多少个`1`
 *  
 *  Related Topics 位运算 
 *  👍 430 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/27
 */
public class I210527I_I461I_HammingDistance {
    public static void main(String[] args) {
        I210527I_I461I_HammingDistance hammingDistance = new I210527I_I461I_HammingDistance();
        System.out.println("result is : " + hammingDistance.hammingDistance(2, 8));
        System.out.println("expect is : 2");


        System.out.println(Integer.toBinaryString(1000));
        System.out.println(Integer.toBinaryString(23));

    }


    /**
     * 最初版本实现
     * 				解答成功:
     * 				执行耗时:1 ms,击败了8.45% 的Java用户
     * 				内存消耗:35 MB,击败了89.18% 的Java用户
     *
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        if (x == y) return 0;
        x = x ^ y;
        y = 0;
        String bin = Integer.toBinaryString(x);
        for (char c : bin.toCharArray()) {
            if (c == '1') y++;
        }
        return y ;
    }


    /**
     * 升级版本实现
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.1 MB,击败了84.78% 的Java用户
     *
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistanceUpdate(int x, int y) {
        if (x == y) return 0;
        x = x ^ y;
        y = 0;
        while(x > 0) {
            if(x % 2 == 1) y++;
            x = x/2;
        }
        return y ;
    }
}
