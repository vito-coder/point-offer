package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 给定一个单词，你需要判断单词的大写使用是否正确。 
 * 
 *  我们定义，在以下情况时，单词的大写用法是正确的： 
 *
 *  全部字母都是大写，比如"USA"。 
 *  单词中所有字母都不是大写，比如"leetcode"。 
 *  如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
 *
 *  否则，我们定义这个单词没有正确使用大写字母。 
 * 
 *  示例 1:
 * 输入: "USA"
 * 输出: True
 *  
 * 
 *  示例 2:
 * 输入: "FlaG"
 * 输出: False
 *
 *  注意: 输入是由大写和小写拉丁字母组成的非空单词。 
 *  Related Topics 字符串 
 *  👍 136 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/12
 */
public class I520I_DetectCapitalUse {
    public static void main(String[] args) {
        I520I_DetectCapitalUse capitalUse = new I520I_DetectCapitalUse();
        System.out.println(capitalUse.detectCapitalUse("Flag"));
        System.out.println("expect is : true");
        System.out.println(capitalUse.detectCapitalUse("GooD"));
        System.out.println("expect is : false");
        System.out.println(capitalUse.detectCapitalUse("CHINA"));
        System.out.println("expect is : true");
        System.out.println(capitalUse.detectCapitalUse("morning"));
        System.out.println("expect is : true");
        System.out.println(capitalUse.detectCapitalUse("mOrning"));
        System.out.println("expect is : false");
        System.out.println(capitalUse.detectCapitalUse("moRrning"));
        System.out.println("expect is : false");

    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.8 MB,击败了52.04% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(1)
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return false;
        if (word.length() < 2) return true;
        boolean start = lowerCase(word.charAt(0));
        boolean second = lowerCase(word.charAt(1));
        if (start && !second) return false;
        for (int i = 2, len = word.length(); i < len; i++) {
            if ((start && second) || (!start && second)) {
                if (!lowerCase(word.charAt(i))) return false;
            } else if (!start && !second) {
                if (lowerCase(word.charAt(i))) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean lowerCase(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
}
