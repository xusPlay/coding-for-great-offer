package class32;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * Leetcode题目 : https://leetcode.cn/problems/maximum-product-subarray/
 * <p>
 * 知识点：
 * <p>
 * 子数组问题 => 以每个数字为结尾的情况做判断
 */
public class Problem_0152_MaximumProductSubarray {


    /**
     * 一般解
     *
     * @param arr
     * @return
     */
    public static double max(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // 报错！
        }
        int n = arr.length;
        // 上一步的最大
        double premax = arr[0];
        // 上一步的最小
        double premin = arr[0];

        double ans = arr[0];
        for (int i = 1; i < n; i++) {
            // 第一种情况：只要i位置自己的数
            double p1 = arr[i];
            // 第二种情况：i位置的数 * i-1 位置的最大累乘积
            double p2 = arr[i] * premax;
            // 第三种情况：i位置的数 * i-1 位置的最小累乘积（考虑当前位置可能为负数）
            double p3 = arr[i] * premin;
            double curmax = Math.max(Math.max(p1, p2), p3);
            double curmin = Math.min(Math.min(p1, p2), p3);
            ans = Math.max(ans, curmax);
            premax = curmax;
            premin = curmin;
        }
        return ans;
    }


    /**
     * 每个位置求最大累乘积、最小累乘积
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 求三种情况下的最大累乘积和最小累乘积
            int curmin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int curmax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = curmin;
            max = curmax;
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
