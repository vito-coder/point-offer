package com.vitoboy.leetcode.daily.aprilbefore;

/**
 * 第995题
 * 
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0
 * 。 
 * 
 *  返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= A.length <= 30000 
 *  1 <= K <= A.length 
 *  
 *  Related Topics 贪心算法 Sliding Window 
 *  👍 93 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/2/18 上午10:08
 * @Version: 1.0
 */
public class I995IMinKBitFlips {

    public static void main(String[] args) {
        I995IMinKBitFlips minKBitFlip  = new I995IMinKBitFlips();
        int[] A = new int[]{0,1,0};
        int k = 1;
        System.out.println("result is : " + minKBitFlip.minKBitFlips(A, k));
        System.out.println("expect is : 2");
        A = new int[]{1,1,0};
        k = 2;
        System.out.println("result is : " + minKBitFlip.minKBitFlips(A, k));
        System.out.println("expect is : -1");
        A = new int[]{0,0,0,1,0,1,1,0};
        k = 3;
        System.out.println("result is : " + minKBitFlip.minKBitFlips(A, k));
        System.out.println("expect is : 3");

    }

    /**
     * 				解答成功:(vito)
     * 				执行耗时:2384 ms,击败了23.60% 的Java用户
     * 				内存消耗:46.5 MB,击败了48.75% 的Java用户
     *
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int len = A.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if((A[i] == 0 || A[i] % 2 == 0) && i + K <= len ){
                A[i] = 1;
                count++;
                for (int j = i+1; j < K+i; j++) {
                    A[j] = ++A[j];
                }
            }
        }

        for (int i = len - K; i < len; i++) {
            if (A[i] == 0 || A[i] % 2 == 0) {
                return -1;
            }
        }

        return count;

    }
}
