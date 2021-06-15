package com.vitoboy.leetcode.daily.jun;

/**
 * 
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 *  
 *  arr.length >= 3 
 *  存在 i（0 < i < arr.length - 1）使得：
 *  
 *  arr[0] < arr[1] < ... arr[i-1] < arr[i] 
 *  arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
 *
 *  给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 
 * 1] > ... > arr[arr.length - 1] 的下标 i 。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 *  
 * 
 *  示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 *  
 * 
 *  示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 *  
 * 
 *  示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 *  
 * 
 *  示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 *
 *  提示：
 *  3 <= arr.length <= 104 
 *  0 <= arr[i] <= 106 
 *  题目数据保证 arr 是一个山脉数组 
 *  
 *
 *  进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？ 
 *  Related Topics 二分查找 
 *  👍 176 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/15
 */
public class I210615I_I852I_PeakIndexInMountainArray {
    public static void main(String[] args) {
        I210615I_I852I_PeakIndexInMountainArray mountainArray = new I210615I_I852I_PeakIndexInMountainArray();
        int[] arr = new int[]{3,4,5,1};
        System.out.println(mountainArray.peakIndexInMountainArray(arr));

    }


    /**
     * 二分查找法解决
     *
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.7 MB,击败了48.81% 的Java用户
     *
     * 时间复杂度: O(logN) 二分查找的时间复杂度
     * 空间复杂度: O(1)
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length -1, mid = -1;
        while(low < high) {
            mid = (high-low)/2 + low;
            if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                low = mid+1;
            } else if(arr[mid] < arr[mid-1]&& arr[mid] > arr[mid+1]) {
                high = mid;
            } else{
                return mid;
            }
        }
        return low;
    }


    /**
     *     作者：AC_OIer
     *     链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/solution/gong-shui-san-xie-er-fen-san-fen-cha-zhi-5gfv/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 时间复杂度: O(log3 N)
     * 空间复杂度: O(1)
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArrayIII(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m1 = l + (r - l) / 3;
            int m2 = r - (r - l) / 3;
            if (arr[m1] > arr[m2]) {
                r = m2 - 1;
            } else {
                l = m1 + 1;
            }
        }
        return r;
    }




}
