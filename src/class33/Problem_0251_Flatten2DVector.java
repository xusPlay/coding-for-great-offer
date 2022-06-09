package class33;

/**
 * 给定一个二维数组，实现二维数组的迭代器，包含hasNext()和next()两个迭代器常见方法。
 * Leetcode题目 : https://leetcode.cn/problems/flatten-2d-vector/
 * <p>
 * 付费题
 */
public class Problem_0251_Flatten2DVector {

    public static class Vector2D {
        private int[][] matrix;
        private int row;
        private int col;
        private boolean curUse;

        public Vector2D(int[][] v) {
            matrix = v;
            row = 0;
            col = -1;
            curUse = true;
            hasNext();
        }

        public int next() {
            int ans = matrix[row][col];
            curUse = true;
            hasNext();
            return ans;
        }

        /**
         * 如果当前的数没用过，就用
         * 如果当前数用过了，寻找下一个，并把相关状态改了
         *
         * @return
         */
        public boolean hasNext() {
            if (row == matrix.length) {
                return false;
            }
            if (!curUse) {
                return true;
            }
            // (row，col)用过了，如果当前列没有结束
            if (col < matrix[row].length - 1) {
                col++;
            } else {
                col = 0;
                // 防止有某一行0个数据，要一直向下跳
                do {
                    row++;
                } while (row < matrix.length && matrix[row].length == 0);
            }

            // 结束上面的流程新的(row，col)
            if (row != matrix.length) {
                curUse = false;
                return true;
            } else {
                return false;
            }
        }

    }

}
