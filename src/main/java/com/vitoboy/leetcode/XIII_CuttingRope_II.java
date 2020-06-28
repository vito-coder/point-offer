package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/27 20:46
 * @Version: 1.0
 *
 *
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 */
public class XIII_CuttingRope_II {
    public static void main(String[] args) {

        XIII_CuttingRope_II cuttingRope_ii = new XIII_CuttingRope_II();
        System.out.println(cuttingRope_ii.cuttingRope(120));
    }

    /**
     * 1. 首先, 需要知道这种题的数学求解, 不然不会知道, 最优解是, 最好每段的长度为: 3
     * 2. 不知道数学求解的, 可以考虑一下, 使用找规律的办法, 判断小数的解, 到大数的解之间有什么规律, 从而发现最好每段的长度为: 3
     * 3. 这道题是关于大数的解, 需要考虑的是求模, 求模则要求无法判断大小(因为大数会越界, 越界后的值求模会变小, 同时也不好比较乘积的大小)
     *
     * n = 2 ==> 1X1 = 1
     * n = 3 ==> 1X2 = 3
     * n = 4 ==> 2X2 = 4
     * n = 5 ==> 2X3 = 6
     * n = 6 ==> 3X3 = 9
     * n = 7 ==> 3X2X2 = 3X4 = 12
     * n = 8 ==> 3X3X2 = 18
     * n = 9 ==> 3X3X3 = 27
     * n = 10 ==> 3X3X2X2 = 3X3X4 = 36
     * ....
     * n = n ==> 3X3X3...X(2, 3, 4)
     *
     * @param n     绳子的长度
     * @return
     *      返回最大的乘积求模后的结果
     */
    public int cuttingRope(int n) {
        if (n <= 3 ) return n-1;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) ((res * n) % 1000000007);
    }

    /**
     *
     作者：chuang-bian-gu-shi
     链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/ctan-xin-0ms-by-chuang-bian-gu-shi/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    //n >= 5 2*(n-2) > n   3*(n-3) > n  且3*(n-3) >= 2*(n-2)
    //n = 4 2 * 2 > 1 * 3
    //2和3不能再分了  分了就变小了 且3优于2
    public int cuttingRopeNiceAnswer(int n) {
        if(n <= 3) return n-1;
        long rs = 1;
        while (n > 4) {
            //3最优
            rs *= 3;
            rs %= 1000000007;
            n -= 3;
        }
        //n = 1,2,3,4,5,6,7,8,9,10,11,12  减了n个3之后
        //n = 1,2,3,4,2,3,4,2,3,4, 2, 3
        //循环结束 只剩下1, 2 ,3,4   *1等于没有
        //2，3不能再分了
        //4 可以分成1 * 3  2 * 2,所以还是4最优
        //所以 剩下的1 2 3 4 都不能再分了
        return (int) ((rs * n) % 1000000007);
    }
}
