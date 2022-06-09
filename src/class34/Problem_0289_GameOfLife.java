package class34;

// 有关这个游戏更有意思、更完整的内容：
// https://www.bilibili.com/video/BV1rJ411n7ri
// 也推荐这个up主

/**
 * 生命游戏，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 1、如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2、如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3、如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4、如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * Leetcode题目 : https://leetcode.cn/problems/game-of-life/
 * <p>
 * 知识点：
 * 利用原始数组中的0和1 的没有利用的位信息
 */
public class Problem_0289_GameOfLife {

    public static void gameOfLife(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        // 遍历整个二维数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 找到i,j位置周围有几个1
                int neighbors = neighbors(board, i, j);
                // 如果满足条件，把倒数第2位修改为1
                if (neighbors == 3 || (board[i][j] == 1 && neighbors == 2)) {
                    board[i][j] |= 2;
                }
            }
        }
        // 遍历数组，把所有的数右移1位
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    // b[i][j] 这个位置的数，周围有几个1
    public static int neighbors(int[][] b, int i, int j) {
        return f(b, i - 1, j - 1)
                + f(b, i - 1, j)
                + f(b, i - 1, j + 1)
                + f(b, i, j - 1)
                + f(b, i, j + 1)
                + f(b, i + 1, j - 1)
                + f(b, i + 1, j)
                + f(b, i + 1, j + 1);
    }

    // b[i][j] 的值是1，就返回1，上面不是1，就返回0
    public static int f(int[][] b, int i, int j) {
        return (i >= 0 && i < b.length && j >= 0 && j < b[0].length && (b[i][j] & 1) == 1) ? 1 : 0;
    }

}
