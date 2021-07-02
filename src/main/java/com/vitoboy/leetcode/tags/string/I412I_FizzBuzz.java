package com.vitoboy.leetcode.tags.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 写一个程序，输出从 1 到 n 数字的字符串表示。 
 * 
 *  1. 如果 n 是3的倍数，输出“Fizz”； 
 * 
 *  2. 如果 n 是5的倍数，输出“Buzz”； 
 * 
 *  3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
 * 
 *  示例： 
 * 
 *  n = 15,
 * 
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *  
 *  Related Topics 数学 字符串 模拟 
 *  👍 98 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I412I_FizzBuzz {
    public static void main(String[] args) {
        I412I_FizzBuzz fizzBuzz = new I412I_FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
        System.out.println(fizzBuzz.fizzBuzz(100));

    }

    /**
     * 				解答成功:
     * 				执行耗时:7 ms,击败了35.58% 的Java用户
     * 				内存消耗:39.4 MB,击败了80.56% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String all = "FizzBuzz", fizz = "Fizz", buzz = "Buzz";
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add(all);
            } else if (i % 5 == 0) {
                list.add(buzz);
            } else if (i % 3 == 0) {
                list.add(fizz);
            } else {
                list.add(i + "");
            }

        }
        return list;
    }
    
}
