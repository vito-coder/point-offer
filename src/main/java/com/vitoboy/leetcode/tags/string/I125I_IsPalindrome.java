package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
 * 
 *  说明：本题中，我们将空字符串定义为有效的回文串。 
 * 
 *  示例 1:
 *  输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *  
 * 
 *  示例 2:
 *  输入: "race a car"
 * 输出: false
 *  
 *  Related Topics 双指针 字符串 
 *  👍 386 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/9
 */
public class I125I_IsPalindrome {
    public static void main(String[] args) {
        I125I_IsPalindrome palindrome = new I125I_IsPalindrome();
        String s = "race a car";
        System.out.println("result is : " + palindrome.isPalindrome(s));
        System.out.println("expect is : false");
        s = "A man, a plan, a canal: Panama";
        System.out.println("result is : " + palindrome.isPalindrome(s));
        System.out.println("expect is : true");
        s = "Nella's simple hymn: \"I attain my help, Miss Allen.\"";
        System.out.println("result is : " + palindrome.isPalindrome(s));




    }

    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了63.42% 的Java用户
     * 				内存消耗:38.3 MB,击败了89.01% 的Java用户
     *
     * 双指针
     * 时间复杂度: O(N) 需要遍历一遍字符串
     * 空间复杂度: O(1) 固定空间即可
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        char[] chars = s.toCharArray();
        int length = s.length();
        boolean res = true;
        char low, high;
        for(int i=0, j=length-1; i<length && i<j && j < length && i >= 0; i++,j--) {
            low = chars[i];
            high = chars[j];
            if(isChar(low) && isChar(high)){
                if(low != high ) {
                    if(Character.isDigit(low) || Character.isDigit(high)) return false;
                    else if(Character.toLowerCase(low) != Character.toLowerCase(high)) return false;
                }
            } else if(!isChar(low) && !isChar(high)) {
                continue;
            } else if(!isChar(high)) {
                i--;
            } else {
                j++;
            }
        }
        return res;
    }

    private boolean isChar(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >='A' && c <= 'Z')){
            return true;
        }
        return false;
    }
}
