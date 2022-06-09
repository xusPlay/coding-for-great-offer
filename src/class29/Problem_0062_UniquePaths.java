package class29;

/**
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步
 * 机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 * Leetcode题目：https://leetcode.cn/problems/unique-paths/
 * <p>
 * 知识点：【GCD问题】排列组合问题，辗转相除法
 */
public class Problem_0062_UniquePaths {

    // m 行
    // n 列
    // 下：m-1
    // 右：n-1
    public static int uniquePaths(int m, int n) {
        int right = n - 1;
        int all = m + n - 2;
        long o1 = 1;
        long o2 = 1;
        // o1乘进去的个数 一定等于 o2乘进去的个数
        for (int i = right + 1, j = 1; i <= all; i++, j++) {
            o1 *= i;
            o2 *= j;
            // 求最大公约数
            long gcd = gcd(o1, o2);
            o1 /= gcd;
            o2 /= gcd;
        }
        return (int) o1;
    }

    // 调用的时候，请保证初次调用时，m和n都不为0
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}
