package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
 *  "Silver Medal", "Bronze Medal"）。 
 * 
 *  (注：分数越高的选手，排名越靠前。) 
 * 
 *  示例 1:
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
 * "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
 * 
 *  提示:
 *  N 是一个正整数并且不会超过 10000。 
 *  所有运动员的成绩都不相同。 
 *  
 *  Related Topics 数组 排序 堆（优先队列） 
 *  👍 76 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/9
 */
public class I506I_FindRelativeRanks {
    public static void main(String[] args) {
        I506I_FindRelativeRanks ranks = new I506I_FindRelativeRanks();
        int[] score = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(ranks.findRelativeRanks(score)));
        System.out.println("expect is : [\"Gold Medal\", \"Silver Medal\", \"Bronze Medal\", \"4\", \"5\"]");
        score = new int[]{5,4,3,2,1,34,32,64,6};
        System.out.println(Arrays.toString(ranks.findRelativeRanks(score)));
        System.out.println("expect is : [\"5\",\"6\",\"7\",\"8\",\"9\",\"Silver Medal\",\"Bronze Medal\",\"Gold Medal\",\"4\"]");
        
    }


    /**
     * 				解答成功:
     * 				执行耗时:19 ms,击败了23.40% 的Java用户
     * 				内存消耗:39.3 MB,击败了79.43% 的Java用户
     *
     * 				解答成功: (使用swith)
     * 				执行耗时:15 ms,击败了40.76% 的Java用户
     * 				内存消耗:39.1 MB,击败了94.09% 的Java用户
     *
     *
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {
        SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>(((o1, o2) -> {return o2-o1;}));
        String[] strs = new String[score.length];
        int count = 0;
        for (int i = score.length-1; i >= 0; i--) {
            sortedMap.put(score[i], "");
        }
        for (Map.Entry<Integer, String> integerStringEntry : sortedMap.entrySet()) {
            switch (count) {
                case 0: integerStringEntry.setValue("Gold Medal");break;
                case 1: integerStringEntry.setValue("Silver Medal");break;
                case 2: integerStringEntry.setValue("Bronze Medal");break;
                default:
                    integerStringEntry.setValue((count+1)+"");
            }
            count++;
        }
        for (int i = 0, len = score.length; i < len; i++) {
            strs[i] = sortedMap.get(score[i]);
        }

        return strs;
    }
}
