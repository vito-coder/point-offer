package com.vitoboy.leetcode.daily.may;

/**
 * 
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。 
 * 
 *  对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
 * 本次查询的结果。 
 * 
 *  并返回一个包含给定查询 queries 所有结果的数组。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8] 
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001 
 * 3 = 0011 
 * 4 = 0100 
 * 8 = 1000 
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2 
 * [1,2] = 3 xor 4 = 7 
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14 
 * [3,3] = 8
 *  
 * 
 *  示例 2：
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= arr.length <= 3 * 10^4 
 *  1 <= arr[i] <= 10^9 
 *  1 <= queries.length <= 3 * 10^4 
 *  queries[i].length == 2 
 *  0 <= queries[i][0] <= queries[i][1] < arr.length 
 *  
 *  Related Topics 位运算 
 *  👍 122 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I210512I_I1310I_XorQueries {
    public static void main(String[] args) {

    }


    /**
     * 自己实现
     * 				解答成功:
     * 				执行耗时:703 ms,击败了30.63% 的Java用户
     * 				内存消耗:49.1 MB,击败了75.20% 的Java用户
     *
     * 时间复杂度: O(m*n) 每次(m)都需要重新计算区间(n)的异或值
     * 空间复杂度: O(m)  只需记录每次(m)区间异或的结果值, 及其它固定变量值
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int begin = 0, end = 0, sum = 0;
        for(int i=0; i<res.length; i++) {
            begin = queries[i][0];
            end = queries[i][1];
            sum = 0;
            for(int j=begin; j<=end; j++) {
                sum = sum ^ arr[j];
            }
            res[i] = sum;
        }
        return res;
    }

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray/solution/zi-shu-zu-yi-huo-cha-xun-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 				解答成功:
     * 				执行耗时:2 ms,99.98% 的Java用户
     * 				内存消耗:48.3 MB,击败了 96.52% 的Java用户
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueriesII(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }


}
