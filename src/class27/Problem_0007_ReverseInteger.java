package class27;

/**
 * 数字转换题目的主要思路先把数字转成负的
 * <p>
 * <p>
 * 给你一个32位的有符号整数x，返回将x中的数字部分反转后的结果，如果反转后整数超过 32 位的有符号整数的范围，就返回0
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 * Leetcode题目：https://leetcode.com/problems/reverse-integer/
 */
public class Problem_0007_ReverseInteger {

    /**
     *
     */
    public static int reverse(int x) {
        // 判断第一位的正负号
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;

        // 判断溢出
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;

        int res = 0;
        while (x != 0) {
            // 判断是否有溢出
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }
            // 结果 * 10 + 模10
            res = res * 10 + x % 10;
            // 原数消1位
            x /= 10;
        }
        return neg ? res : Math.abs(res);
    }

}
