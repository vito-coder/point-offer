package com.vitoboy.leetcode.daily;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * 
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。 
 * 
 *  返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
 * 
 *  示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *  示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
 *  = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *  注意：
 *  假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
 *  输入的单词均由小写字母组成。 
 *
 *  扩展练习：
 *  尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
 *  
 *  Related Topics 堆 字典树 哈希表 
 *  👍 252 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/20 上午7:44
 * @Version: 1.0
 */
public class I210520I_I692I_TopKFrequent {
    public static void main(String[] args) {
        I210520I_I692I_TopKFrequent topKFrequent = new I210520I_I692I_TopKFrequent();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println("result is : " + topKFrequent.topKFrequent(words, 2));
        System.out.println("expect is : [\"i\", \"love\"]");
        words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println("result is : " + topKFrequent.topKFrequent(words, 4));
        System.out.println("expect is : [\"the\", \"is\", \"sunny\", \"day\"]");
    }


    /**
     * 				解答成功:
     * 				执行耗时:10 ms,击败了15.55% 的Java用户
     * 				内存消耗:38.8 MB,击败了15.85% 的Java用户
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> dataMap = new TreeMap<>();
        for (String word : words) {
            if (dataMap.containsKey(word)) {
                dataMap.put(word, dataMap.get(word) + 1);
            } else {
                dataMap.put(word, 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(dataMap.entrySet());
        entryList.sort(((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        }));

        List<String> list = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (count < k) {
                list.add(entry.getKey());
                count++;
            } else {
                break;
            }
        }

        return list;
    }


    /**
     * 哈希表 + 排序
     *
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 				解答成功:
     * 				执行耗时:7 ms,击败了91.95% 的Java用户
     * 				内存消耗:38.5 MB,击败了77.33% 的Java用户
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentII(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }


    /**
     * 方法二：优先队列
     * 思路及算法
     *
     * 对于前 kk 大或前 kk 小这类问题，有一个通用的解法：优先队列。优先队列可以在 O(\log n)O(logn) 的时间内完成插入或删除元素的操作（其中 nn 为优先队列的大小），并可以 O(1)O(1) 地查询优先队列顶端元素。
     *
     * 在本题中，我们可以创建一个小根优先队列（顾名思义，就是优先队列顶端元素是最小元素的优先队列）。我们将每一个字符串插入到优先队列中，如果优先队列的大小超过了 kk，那么我们就将优先队列顶端元素弹出。这样最终优先队列中剩下的 kk 个元素就是前 kk 个出现次数最多的单词。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(l \times n + m \times l \log k)O(l×n+m×llogk)，其中 nn 表示给定字符串序列的长度，mm 表示实际字符串种类数，ll 表示字符串的平均长度。我们需要 l \times nl×n 的时间将字符串插入到哈希表中，以及每次插入元素到优先队列中都需要 l \log kllogk 的时间，共需要插入 mm 次。
     *
     * 空间复杂度：O(l \times (m + k))O(l×(m+k))，其中 ll 表示字符串的平均长度，mm 表示实际字符串种类数。哈希表空间占用为 O(l \times m)O(l×m)，优先队列空间占用为 O(l \times k)O(l×k)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 				解答成功:
     * 				执行耗时:7 ms,击败了91.95% 的Java用户
     * 				内存消耗:38.6 MB,击败了70.88% 的Java用户
     *
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentIII(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }




}
