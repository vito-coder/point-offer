package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 实现 int sqrt(int x) 函数。 
 * 
 *  计算并返回 x 的平方根，其中 x 是非负整数。 
 * 
 *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
 * 
 *  示例 1:
 *  输入: 4
 * 输出: 2
 *  
 * 
 *  示例 2:
 *  输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 *      由于返回类型是整数，小数部分将被舍去。
 *  
 *  Related Topics 数学 二分查找 
 *  👍 685 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I69I_MySqrt {
    public static void main(String[] args) {
        I69I_MySqrt mySqrt = new I69I_MySqrt();
        System.out.println(mySqrt.mySqrt(12345678));

    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x < 4) return 1;
        if(x == 4) return 2;
        int low = 1, high = x/2;
        int mid = 0;
        while(low < high) {
            mid = (low + high) / 2;
            if(mid > x/mid) {
                high = mid;
            } else if (mid < x/mid) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        if(low*low < x && low < low*low) {
            return low;
        }
        return low-1;
    }

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * @param x
     * @return
     */
    public int mySqrtII(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


}
