package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。 
 * 
 *  给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分
 * 组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。 
 * 
 *  给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。 
 *
 *  示例 1：
 *  输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 *  
 * 
 *  示例 2：
 *  输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *
 *  提示:
 *  S 的长度可能很长，请按需分配大小。K 为正整数。 
 *  S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-' 
 *  S 非空
 *
 *  Related Topics 字符串 
 *  👍 69 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I482I_LicenseKeyFormatting {
    public static void main(String[] args) {
        I482I_LicenseKeyFormatting formatting = new I482I_LicenseKeyFormatting();
        String s = "5F3Z-2e-9-w";
        System.out.println(formatting.licenseKeyFormatting(s, 4));
        System.out.println("expect is : 5F3Z-2E9W");
        s = "2-5g-3-J";
        System.out.println(formatting.licenseKeyFormatting(s, 2));
        System.out.println("expect is : 2-5G-3J");
    }


    /**
     * 				解答成功:
     * 				执行耗时:54 ms,击败了18.53% 的Java用户
     * 				内存消耗:38.9 MB,击败了32.50% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder(), tmp = new StringBuilder();
        char line = '-', ch = ' ';
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (count == k) {
                count = 0;
                tmp.insert(0, line);
                builder.insert(0, tmp.toString());
                tmp = new StringBuilder();
            }
            ch = s.charAt(i);
            if (ch == line) continue;
            tmp.insert(0, toUpperCase(ch));
            count++;
        }
        if (tmp.length() > 0) {
            builder.insert(0, tmp.toString());
        }
        if (builder.length() > 0 && builder.charAt(0) == line) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    private char toUpperCase(char c) {
        if (isDigit(c)) return c;
        if (isLowerCase(c)) {
            return (char)('A' + (c - 'a'));
        } else {
            return c;
        }
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    private boolean isLowerCase(char c) {
        if (c >= 'a' && c <='z') return true;
        return false;
    }
}
