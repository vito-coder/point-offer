package com.vitoboy.leetcode.daily.aprilbefore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两个长度相同的字符串，s 和 t。 
 * 
 *  将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的
 * 绝对值。 
 * 
 *  用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。 
 * 
 *  如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。 
 * 
 *  如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。 
 * 
 *  示例 2： 
 * 
 *  输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *  
 * 
 *  示例 3： 
 * 
 *  输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= s.length, t.length <= 10^5 
 *  0 <= maxCost <= 10^6 
 *  s 和 t 都只含小写英文字母。 
 *  
 *  Related Topics 数组 Sliding Window 
 *  👍 86 👎 0
 * 
 * @Author: vito
 * @Date: 2021/2/5 下午3:24
 * @Version: 1.0
 */
public class EqualSubstringSolution {
    public static void main(String[] args) {
        EqualSubstringSolution solution = new EqualSubstringSolution();
        String s = "abcd";
        String t = "bcdf";
        int cost = 3;
        System.out.println("result is : " + solution.equalSubstringIUpdate(s, t, cost));
        System.out.println("expect is : 3");
        s = "abcd";
        t = "cdef";
        cost = 3;
        System.out.println("result is : " + solution.equalSubstringIUpdate(s, t, cost));
        System.out.println("expect is : 1");
        s = "abcd";
        t = "acde";
        cost = 0;
        System.out.println("result is : " + solution.equalSubstringIUpdate(s, t, cost));
        System.out.println("expect is : 1");
        s = "krrgw";
        t = "zjxss";
        cost = 19;
        System.out.println("result is : " + solution.equalSubstringIUpdate(s, t, cost));
        System.out.println("expect is : 2");
        s = "fkfnkrfunni";
        t = "jyufzxzfbsa";
        cost = 18;
        System.out.println("result is : " + solution.equalSubstringIUpdate(s, t, cost));
        System.out.println("expect is : 2");


    }


    /**
     *
     * 双指针, 空间换时间
     *
     * 				解答成功:
     * 				执行耗时:3 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.6 MB,击败了51.12% 的Java用户
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstringII(String s, String t, int maxCost) {
        char []s1=s.toCharArray();
        char []t1=t.toCharArray();
        int []num=new int[s.length()];
        int length=s.length(),i,j,temp=0;
        for(i=0;i<length;i++)
        {
            num[i]=Math.abs(s1[i]-t1[i]);
        }
        for(i=0,j=0;i<length;i++)
        {
            if(temp+num[i]>maxCost)
            {
                temp+=num[i]-num[j];
                j++;
            }
            else
            {
                temp+=num[i];
            }
        }
        return i-j;
    }


    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了64.03% 的Java用户
     * 				内存消耗:38.5 MB,击败了81.52% 的Java用户
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstringI(String s, String t, int maxCost) {
        int maxlen = 0, head =0,  tail = 0;
        int len = s.length();
        int[] diffArr = new int[len];
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            diffArr[i] = diff;
            head++;
            if (diff > maxCost) {
                while (maxCost < diff) {
                    maxCost += diffArr[tail];
                    tail++;
                }
            }
            maxlen = Math.max(maxlen, (head-tail));
            maxCost = maxCost-diff;
        }
        return maxlen;
    }


    /**
     *				解答成功:
     * 				执行耗时:4 ms,击败了97.57% 的Java用户
     * 				内存消耗:38.6 MB,击败了49.46% 的Java用户
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstringIUpdate(String s, String t, int maxCost) {
        int temp = 0, head =0,  tail = 0;
        int len = s.length();
        int[] diff = new int[len];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (; head < len; head++) {
            diff[head] = Math.abs(sc[head] - tc[head]);
            if(temp+diff[head]>maxCost) {
                temp+=diff[head]-diff[tail];
                tail++;
            } else {
                temp+=diff[head];
            }
        }
        return head-tail;
    }

    /**
     * 				解答成功:
     * 				执行耗时:16 ms,击败了7.92% 的Java用户
     * 				内存消耗:39.4 MB,击败了5.02% 的Java用户
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        Queue<Integer> queue = new LinkedList<>();
        int use = 0;
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            diff = Math.abs(s.charAt(i) - t.charAt(i));
            if (diff <= maxCost) {
                maxCost -= diff;
                queue.add(diff);
                use = Math.max(use, queue.size());
            } else if (!queue.isEmpty()){
                while (!queue.isEmpty()) {
                    maxCost += queue.poll();
                    if (diff <= maxCost) {
                        maxCost -= diff;
                        queue.add(diff);
                        break;
                    }
                }
                use = Math.max(use, queue.size());
            }
        }
        return use;
    }
}
