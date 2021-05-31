package com.vitoboy.leetcode.tags.dp;

/**
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I70I_ClimbStairs {
    public static void main(String[] args) {

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35 MB,击败了82.00% 的Java用户
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        int f1 = 1, f2 = 2;
        int count = 2;
        while(n >= count+2) {
            count += 2;
            f1 = f1 + f2;
            f2 = f1 + f2;
        }
        if(n == count) return f2;
        else return f1 + f2;
    }


    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 官方动态规划实现
     *
     * @param n
     * @return
     */
    public int climbStairsII(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *  官方矩阵快速幂实现
     *
     *  复杂度分析
     *
     * 时间复杂度：同快速幂，O(logn)。
     * 空间复杂度：O(1)。
     *
     * @param n
     * @return
     */
    public int climbStairsIII(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }


    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 官方实现: 通项公式
     *
     * @param n
     * @return
     */
    public int climbStairsIV(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }



}
