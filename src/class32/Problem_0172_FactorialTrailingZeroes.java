package class32;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * Leetcode题目 : https://leetcode.cn/problems/factorial-trailing-zeroes/
 * <p>
 * <p>
 * 2因子和5因子 构成10
 * 但是2因子大于5的因子
 * 所以，这道题就变成了求有多少5的因子
 */
public class Problem_0172_FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            //
            n /= 5;
            ans += n;
        }
        return ans;
    }

}
