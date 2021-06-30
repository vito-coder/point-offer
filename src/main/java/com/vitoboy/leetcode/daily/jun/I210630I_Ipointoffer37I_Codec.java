package com.vitoboy.leetcode.daily.jun;

import com.vitoboy.leetcode.pointoffer.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I210630I_Ipointoffer37I_Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(-1, new TreeNode(-2), new TreeNode(0)), null), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Codec codec =  new Codec();
        System.out.println(codec.serialize(root));
        TreeNode node ; //= codec.deserialize("[1,2,3,-1,null,4,5,-2,0]");
//        System.out.println(node);
//        root = new TreeNode(1, new TreeNode(2), null);
//        System.out.println(codec.serialize(root));
//        node = codec.deserialize("[1,2]");
//        node = codec.deserialize("[1,null,2]");
//        System.out.println(codec.serialize(node));
        node = codec.deserialize("[1,2,3,-1,null,4,5,-2,0,null,null,null,null,null,null,null,null]");
        System.out.println(codec.serialize(node));

    }


    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。 
     * 
     *  你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
     * 符串反序列化为原始的树结构。 
     * 
     *  提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
     * 法解决这个问题。 
     * 
     *  
     * 
     *  示例：
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     *  
     *
     *  注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
     * inary-tree/ 
     *  Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
     *  👍 183 👎 0
     *
     *
     */
    static class Codec {

        /**
         * 				解答成功:
         * 				执行耗时:24 ms,击败了61.16% 的Java用户
         * 				内存消耗:39.9 MB,击败了88.28% 的Java用户
         *
         * 时间复杂度: O(N)
         * 空间复杂度: O(N)
         *
         * @param root
         * @return
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            if (root.left == null && root.right == null) return "[" + root.val + "]";
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            StringBuilder builder = new StringBuilder();
            builder.append("[").append(root.val).append(",");
            while (list.size() > 0) {
                TreeNode node = list.remove();
                if (node.left != null) {
                    list.add(node.left);
                    builder.append(node.left.val).append(",");
                } else {
                    builder.append("null,");
                }
                if (node.right != null) {
                    list.add(node.right);
                    builder.append(node.right.val).append(",");
                } else {
                    builder.append("null,");
                }
            }
            builder.replace(builder.length()-1, builder.length(), "]");
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) return null;
            data = data.substring(1, data.length()-1);
            String[] strs = data.split(",");
            TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            for (int i = 1; i < strs.length; i = i+2) {
                TreeNode node = list.remove();
                if (!"null".equals(strs[i])) {
                    node.left = new TreeNode(Integer.valueOf(strs[i]));
                    list.add(node.left);
                }
                if (i+1 < strs.length && !"null".equals(strs[i+1])){
                    node.right = new TreeNode(Integer.valueOf(strs[i+1]));
                    list.add(node.right);
                }
            }
            return root;
        }
    }
}
