package class33;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * Leetcode题目 : https://leetcode.cn/problems/product-of-array-except-self/
 */
public class Problem_0238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int right = 1;
        for (int i = n - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * right;
            right *= nums[i];
        }
        ans[0] = right;
        return ans;
    }

    // 扩展 : 如果仅仅是不能用除号，把结果直接填在nums里呢？
    // 解法：数一共几个0；每一个位得到结果就是，a / b，位运算替代 /，之前的课讲过（新手班）

}
