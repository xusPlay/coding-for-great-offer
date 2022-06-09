package class29;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加1
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * 输入：digits = [9,9,9]
 * 输出：[1,0,0,0]
 * 解释：输入数组表示数字 1000。
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * Leetcode题目：https://leetcode.cn/problems/plus-one/
 */
public class Problem_0066_PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        // 从后向前遍历
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 如果每一位都进行了进位，那么新创建一个数组，放一个1
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

}
