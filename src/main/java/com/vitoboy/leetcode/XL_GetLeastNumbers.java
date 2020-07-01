package com.vitoboy.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: vito
 * @Date: 2020/7/1 00:49
 * @Version: 1.0
 * <p>
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class XL_GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        XL_GetLeastNumbers leastNumbers = new XL_GetLeastNumbers();
        System.out.println(Arrays.toString(leastNumbers.getLeastNumbers(arr, 2)));

        arr = new int[]{0, 1, 2, 1};
        System.out.println(Arrays.toString(leastNumbers.getLeastNumbers(arr, 1)));

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 1) return new int[0];
        for (int i = 0; i < k; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }


    /**
     * 简单优化, 使用java自己的类库实现
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersUpdate(int[] arr, int k) {
        if (k < 1) return new int[0];
        if (k == arr.length) return arr;
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }


    /**
     *
     * 一、用快排最最最高效解决 TopK 问题：O(N)
     * 注意找前 K 大/前 K 小问题不需要对整个数组进行 O(NlogN) 的排序！
     * 例如本题，直接通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数啦～
     * 下面代码给出了详细的注释，没啥好啰嗦的，就是快排模版要记牢哈～
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersFaster(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


    /**
     * 二、大根堆(前 K 小) / 小根堆（前 K 大),Java中有现成的 PriorityQueue，实现起来最简单：O(NlogK)O(NlogK)
     * 本题是求前 K 小，因此用一个容量为 K 的大根堆，每次 poll 出最大的数，那堆中保留的就是前 K 小啦（注意不是小根堆！小根堆的话需要把全部的元素都入堆，那是 O(NlogN)O(NlogN)😂，就不是 O(NlogK)O(NlogK)啦～～）
     * 这个方法比快排慢，但是因为 Java 中提供了现成的 PriorityQueue（默认小根堆），所以实现起来最简单，没几行代码～
     *
     * // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * // 1. 若目前堆的大小小于K，将当前数字放入堆中。
     * // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] getLeastNumbersFasterII(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }


}
