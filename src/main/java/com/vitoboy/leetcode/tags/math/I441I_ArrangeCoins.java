package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
 * 
 *  给定一个数字 n，找出可形成完整阶梯行的总行数。 
 * 
 *  n 是一个非负整数，并且在32位有符号整型的范围内。 
 * 
 *  示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *  
 * 
 *  示例 2: 
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *  
 *  Related Topics 数学 二分查找 
 *  👍 109 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/5
 */
public class I441I_ArrangeCoins {
    public static void main(String[] args) {
        I441I_ArrangeCoins coins = new I441I_ArrangeCoins();
        System.out.println(coins.arrangeCoins(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);

    }

    /**
     * n >= k * (k + 1)/2
     * 求 k
     *
     *				解答成功:
     * 				执行耗时:2 ms,击败了87.52% 的Java用户
     * 				内存消耗:35.6 MB,击败了46.69% 的Java用户
     *
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        long total = 0L;
        int low = 1, high = n, mid = 0;
        while (low < high ) {
            mid = low + (high-low)/2;
            if (mid == low) return low;
            total = mid*1L*(mid+1)/2;
            if (total == n) return mid;
            if (total > n) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;

    }
    
}
