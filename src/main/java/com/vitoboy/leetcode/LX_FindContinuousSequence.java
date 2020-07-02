package com.vitoboy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: vito
 * @Date: 2020/7/2 18:16
 * @Version: 1.0
 *
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class LX_FindContinuousSequence {
    public static void main(String[] args) {
        LX_FindContinuousSequence continuousSequence = new LX_FindContinuousSequence();
//        System.out.println(Arrays.toString(continuousSequence.findContinuousSequence(15)));
        int[][] list = continuousSequence.findContinuousSequenceUpdate(100000);
        for (int i = 0; i < list.length; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
    }

    /**
     *  太慢了....虽然可以实现
     *  使用双重循环, 太慢了....
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target < 3 || target == 4) return new int[0][];
        int[] array = new int[target/2];;
        List<int[]> total = new ArrayList<>();
        for (int i = 1; i <= target/2; i++) {
            int sum = i+i+1, j=i+1;
            int count = 0;
            array[count] = i;
            count++;
            while (sum <= target) {
                array[count] = j;
                if (sum == target) {
                    total.add(Arrays.copyOfRange(array, 0, count+1));
                    break;
                }
                sum += (++j);
                count++;
            }
            array = new int[target / 2];
        }
        int[][] result = new int[total.size()][];
        int index = 0;
        for (int[] arr : total) {
            result[index++] = arr;
        }
        return result;
    }


    /**
     * 使用窗口滑动算法来处理
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequenceUpdate(int target) {
        if (target < 3 || target == 4) return new int[0][];
        List<Integer> list = new ArrayList<>();
        int i=1,j=1,sum=0;
        List<int[]> total = new ArrayList<>();
        while (i <= target/2) {
            if (sum > target) {
                sum -= i;
                i++;
            } else if (sum < target) {
                sum += j;
                j++;
            } else {
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                total.add(arr);
                sum -= i;
                i++;
            }
        }
        return total.toArray(new int[total.size()][]);
    }


    /**
     *
    作者：nettee
    链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequenceOfficial(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


    /**
     * 官方推荐较快的
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequenceOfficialFaster(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }


}
