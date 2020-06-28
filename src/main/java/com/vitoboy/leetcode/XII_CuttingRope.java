package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/27 20:44
 * @Version: 1.0
 *
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
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
 * 提示：
 *
 * 2 <= n <= 58
 */
public class XII_CuttingRope {
    public static void main(String[] args) {

        XII_CuttingRope cuttingRope = new XII_CuttingRope();
        System.out.println(cuttingRope.cuttingRope(2));
        System.out.println(cuttingRope.cuttingRope(10));
        System.out.println(cuttingRope.cuttingRope(45));
        System.out.println(cuttingRope.cuttingRope(58));

        System.out.println();

        System.out.println(cuttingRope.cuttingRopeII(2));
        System.out.println(cuttingRope.cuttingRopeII(10));
        System.out.println(cuttingRope.cuttingRopeII(45));
        System.out.println(cuttingRope.cuttingRopeII(58));

    }

    /**
     * 自己实现的剪绳子问题
     *
     * @param n     绳子的长度
     * @return
     *      最大的分段乘积
     */
    public int cuttingRope(int n) {
        if (n <= 2) return 1;
        int half = n / 2;
        int max = Math.max(n-1, (n-2)*2);
        int preMax = 0;
        for (int i = 2; i <= half; i++) {
            int temp = cuttingRope(n-i);
            int countMax = Math.max(i*temp, i*(n-i));
            if (max < countMax) {
                max = countMax;
            }
            if (temp < preMax) break;
            else preMax = temp;
        }
        return max;
    }


    /**
     * 数学推导.....
     *
     * 算法流程：
     * 当 n ≤ 3 时，按照规则应不切分，但由于题目要求必须剪成 m>1 段，因此必须剪出一段长度为 1 的绳子，即返回 n - 1 。
     * 当 n > 3 时，求 n 除以 3 的 整数部分 a 和 余数部分 b （即 n = 3a + b ），并分为以下三种情况：
     *  当 b = 0 时，直接返回 3^a；
     *  当 b = 1 时，要将一个 1 + 3 转换为 2+2，因此返回 3^{a-1} ×4；
     *  当 b = 2 时，返回 3^a ×2。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int cuttingRopeII(int n) {
        if (n <= 3 ) return n-1;
        int a = n/3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a-1)*4;
        return (int) Math.pow(3, a)*2;
    }
}
