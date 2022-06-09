package class29;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...，由于返回类型是整数，小数部分将被舍去。
 * Leetcode题目：https://leetcode.cn/problems/sqrtx/
 * <p>
 * 知识点：【二分搜索】
 */
public class Problem_0069_SqrtX {

    // x一定非负，输入可以保证
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 3) {
            return 1;
        }
        // x >= 3
        long ans = 1;
        long L = 1;
        long R = x;
        long M = 0;
        while (L <= R) {
            M = (L + R) / 2;
            if (M * M <= x) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return (int) ans;
    }

}
