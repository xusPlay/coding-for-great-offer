package class28;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * Leetcode题目：https://leetcode.cn/problems/valid-sudoku/
 */
public class Problem_0036_ValidSudoku {

    /**
     * 9行
     * 9列
     * 9个桶
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // 第i行某一个数字出现没出现
        boolean[][] row = new boolean[9][10];
        // 第i列某一个数字出现没出现
        boolean[][] col = new boolean[9][10];
        // 第i个桶某一个数子出现没出现
        boolean[][] bucket = new boolean[9][10];
        // 遍历所有的格子 => i，j就是每一个格子
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // 计算桶的编号
                int bid = 3 * (i / 3) + (j / 3);

                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    // 这个数字在 ... 出现过 就为 false
                    if (row[i][num] || col[j][num] || bucket[bid][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
        return true;
    }

}
