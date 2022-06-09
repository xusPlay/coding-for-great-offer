package class28;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 要求：设计并实现时间复杂度为 O(log n) 的算法
 * Leetcode题目：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * 知识点：【二分搜索】
 */
public class Problem_0034_FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 找到数组中小于target的最右位置的下一个位置，如果不等于target，说明当前数组中没有target
        int L = lessMostRight(nums, target) + 1;
        if (L == nums.length || nums[L] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{L, lessMostRight(nums, target + 1)};
    }

    /**
     * 小于某个数的最右位置
     *
     * @param arr
     * @param num
     * @return
     */
    public static int lessMostRight(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        int ans = -1;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (arr[M] < num) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return ans;
    }

}
