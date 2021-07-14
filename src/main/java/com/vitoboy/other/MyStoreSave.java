package com.vitoboy.other;

/**
 *
 * 输入一个仓库数组 store, 其中 store[i]表示第i个仓库可以存放的商品的包数, 同时第i个仓库每包的商品数量为i个
 * 输入一个目标商品存储数量target, 计算指定的仓库列表能否正常放下.
 *
 * 示例1
 * 输入: store=[0,8,3,0,5,7,2], target: 20
 * 输出: true
 * 解释: store[4] = 5 ==> 4*5 = 20 , 第4个仓库直接存满即可
 *
 *
 * 示例2
 * 输入: store=[0,8,3,0,5,7,2], target: 29
 * 输出: true
 * 解释:
 * store[6] = 2 ==> 能存放2包, 每包6个商品, 即12个商品 ==> 17=29-12, 第6个仓库存储12个商品, 剩余17个商品
 * store[5] = 7 ==> 能存入7包, 每包5个商品, 只能入15个商品 ==> 2=17-15, 第5个仓库存储15个商品, 剩余2个商品
 * store[1] = 8 ==> 能存放8包, 第包1个商品, 将剩余的2个商品存入  ==> 0=2-2, 第1个仓库存储2个商品, 剩余0
 *
 *
 * 示例3
 * 输入: store=[0,3,0,0,1,0], target: 9
 * 输出: false
 * 解释:
 * store[4] = 1 ==> 能存放1包, 每包4个商品, 即4个商品 ==> 5=9-4, 第4个仓库存储4个商品, 剩余5个商品
 * store[1] = 3 ==> 能存放3包, 第包1个商品, 即3个商品  ==> 2=5-3, 第1个仓库存储3个商品, 剩余2个商品
 * 没有其它仓库可以存放, 失败, 返回: false
 *
 * 提示
 * store[0] = 0;
 *
 * 作者：vitocoder
 * 链接：https://leetcode-cn.com/circle/discuss/ZHdBzE/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/14
 */
public class MyStoreSave {
    public static void main(String[] args) {
        MyStoreSave save = new MyStoreSave();
        int[] store = new int[]{0,3,0,0,1,0};
        System.out.println(save.saveProducts(store, 9));
        System.out.println("expect is : false");
        store = new int[]{0,8,3,0,5,7,2};
        System.out.println(save.saveProducts(store, 20));
        System.out.println("expect is : true");
        store = new int[]{0,8,3,0,5,7,2};
        System.out.println(save.saveProducts(store, 29));
        System.out.println("expect is : true");
    }


    public boolean saveProducts(int[] stores, int target) {
        int store = 0;
        for (int i = stores.length-1; i > 0 ; i--) {
            if (stores[i] != 0) {
                store = stores[i];
                if (i > target) continue;
                int box = target/i;
                if (box <= store) {
                    target = target % i;
                } else {
                    target = target-store*i;
                }
            }
        }
        return target == 0;
    }
}
