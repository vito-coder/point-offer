package com.vitoboy.leetcode.tags.array;

/**
 * 
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。 
 * 
 *  网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
 * 
 *  岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
 * 的周长。 
 *
 *  示例 1：
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边 
 * 
 *  示例 2：
 * 输入：grid = [[1]]
 * 输出：4
 *  
 * 
 *  示例 3：
 * 输入：grid = [[1,0]]
 * 输出：4
 *
 *  提示：
 *  row == grid.length 
 *  col == grid[i].length 
 *  1 <= row, col <= 100 
 *  grid[i][j] 为 0 或 1 
 *  
 *  Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
 *  👍 417 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/6
 */
public class I463I_IslandPerimeter {
    public static void main(String[] args) {


    }

    /**
     * 错误代码, 考虑一下, 错在哪?
     * <p>
     * todo
     *
     * @param grid
     * @return
     */
    public int islandPerimeterError(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count * 4 - (count - 1) * 2;
    }


    /**
     * 				解答成功:
     * 				执行耗时:8 ms,击败了79.95% 的Java用户
     * 				内存消耗:39.2 MB,击败了97.06% 的Java用户
     *
     * 时间复杂度: O(MN)
     * 空间复杂度: O(1)
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int m = grid.length, n = grid[0].length, count = 0, x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    for (int k = 0; k < 4; k++) {
                        x = i + dx[k];
                        y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            if (grid[x][y] == 1) count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}
