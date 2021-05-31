package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
 * 
 *  单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
 *
 *  示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *  
 * 
 *  示例 2：
 * 输入：s = " "
 * 输出：0
 *  
 *
 *  提示：
 *  1 <= s.length <= 104 
 *  s 仅有英文字母和空格 ' ' 组成 
 *  
 *  Related Topics 字符串 
 *  👍 315 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I58I_LengthOfLastWord {
    public static void main(String[] args) {
        
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.5 MB,击败了86.39% 的Java用户
     *
     * 	时间复杂度: O(N) 只需要遍历一次s即可
     * 	空间复杂度: O(1) 只需要记录单词的字母个数即可
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int res = 0;
        for (int i = len-1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                if(res > 0)
                    return res;
            }else {
                res++;
            }
        }
        return res;
    }
}
