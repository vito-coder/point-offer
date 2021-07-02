package com.vitoboy.leetcode.tags.string;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
 * 的字符构成。如果可以构成，返回 true ；否则返回 false。 
 * 
 *  (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
 *
 *  示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 *  示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 *  示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *  提示：
 *  你可以假设两个字符串均只含有小写字母。 
 *  
 *  Related Topics 哈希表 字符串 计数 
 *  👍 157 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I383I_CanConstruct {
    public static void main(String[] args) {
        I383I_CanConstruct construct = new I383I_CanConstruct();
        String ransomNote = "a", magazine = "b";
        System.out.println(construct.canConstruct(ransomNote, magazine));
        System.out.println("expect is : false");
        ransomNote = "aa"; magazine = "ab";
        System.out.println(construct.canConstruct(ransomNote, magazine));
        System.out.println("expect is : false");
        ransomNote = "aa"; magazine= "aab";
        System.out.println(construct.canConstruct(ransomNote, magazine));
        System.out.println("expect is : true");


    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了63.28% 的Java用户
     * 				内存消耗:37.9 MB,击败了99.89% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(1)
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] notes = new int[26], zine = new int[26];
        int rl = ransomNote.length(), ml = magazine.length();
        int maxl = Math.max(rl, ml);
        for (int i = 0; i < maxl; i++) {
            if (rl > i) {
                notes[ransomNote.charAt(i)-'a']++;
            }
            if (ml > i) {
                zine[magazine.charAt(i)-'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (notes[i] > zine[i]) return false;
        }
        return true;
    }
}
