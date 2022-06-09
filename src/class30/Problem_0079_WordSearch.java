package class30;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * Leetcode题目 : https://leetcode.cn/problems/word-search/
 * <p>
 * 难度：【中等】
 * <p>
 * 知识点：【深度优先遍历】
 */
public class Problem_0079_WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (f(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 目前到达了b[i][j]，word[k....]
     * 从b[i][j]出发，能不能搞定word[k....] true false
     *
     * @param b 原始数组
     * @param i 当前来到i行
     * @param j 当前来到j列
     * @param w 需要寻找的单词
     * @param k 当前来到w的k位置
     * @return
     */
    public static boolean f(char[][] b, int i, int j, char[] w, int k) {
        // base case
        if (k == w.length) {
            return true;
        }
        // word[k.....] 有字符
        // 如果(i,j)越界，返回false
        if (i < 0 || i == b.length || j < 0 || j == b[0].length) {
            return false;
        }

        // 当前的位置能不能搞定
        if (b[i][j] != w[k]) {
            return false;
        }

        // 当前 b[i][j] == work[k]

        char tmp = b[i][j];
        // 防止走回头路
        // 深度优先遍历的常用技巧
        b[i][j] = 0;
        boolean ans = f(b, i - 1, j, w, k + 1)
                || f(b, i + 1, j, w, k + 1)
                || f(b, i, j - 1, w, k + 1)
                || f(b, i, j + 1, w, k + 1);
        // 恢复现场
        b[i][j] = tmp;
        return ans;
    }

}
