package com.vitoboy.leetcode.daily.aprilbefore;

/**
 * 
 *通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 *
 * 3 * 2 * 1。 
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)
 *和减法(-)。 
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我
 *们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。 
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。 
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。 
 *
 * 
 *
 * 示例 1： 
 *
 * 输入：4
 *输出：7
 *解释：7 = 4 * 3 / 2 + 1
 * 
 *
 * 示例 2： 
 *
 * 输入：10
 *输出：12
 *解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 * 
 *
 * 
 *
 * 提示： 
 *
 * 
 * 1 <= N <= 10000 
 * -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。） 
 * 
 * Related Topics 数学 
 * 👍 119 👎 0
 * 
 * @Author: vito
 * @Date: 2021/4/1 下午10:39
 * @Version: 1.0
 */
public class I1006IClumsy {
    public static void main(String[] args) {
        IClumsy clumsy = new Clumsy();
        System.out.println("result is : " + clumsy.clumsy(4));
        System.out.println("expect is : 7");
        System.out.println("result is : " + clumsy.clumsy(10));
        System.out.println("expect is : 12");
        System.out.println(8*7/6+5-4*3/2+1);
        // 8*7/6+5-4*3/2+1
        System.out.println("result is : " + clumsy.clumsy(8));
        System.out.println("expect is : 9");

    }
    
    interface IClumsy {
        int clumsy(int N);
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了81.94% 的Java用户
     * 				内存消耗:35.5 MB,击败了32.90% 的Java用户
     */
    static class Clumsy implements IClumsy {
        
        @Override
        public int clumsy(int N) {
            int sum = 0;
            boolean first = true;
            if (N <= 4) {
                return specialCalculate(N);
            }
            while (N >= 4) {
                if (first) {
                    sum = sum + N * (N-1) / (N-2) + (N-3);
                    first = false;
                } else {
                    sum = sum - N * (N-1) / (N-2) + (N-3);
                }
                N = N - 4;
            }
            return sum - specialCalculate(N);
        }

        private int specialCalculate(int N) {
            int sum = 0;
            for (int i = 0; i < 4 && N > 0;  i++) {
                if (i%4 == 0) {
                    sum = sum + N;
                    N--;
                } else if (i%4 == 1) {
                    sum = sum * N;
                    N--;
                } else if (i%4 ==2) {
                    sum = sum/N;
                    N--;
                } else if (i%4 == 3) {
                    sum = sum + N;
                    N--;
                }
            }
            return sum;
        }
    }
}
