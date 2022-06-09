package class32;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * Leetcode题目 : https://leetcode.cn/problems/rotate-array/
 * <p>
 * 原地调整：
 * 1、先左边逆序
 * 2、再右边逆序
 * 3、最后整体逆序
 */
public class Problem_0189_RotateArray {

    public void rotate1(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverse(nums, 0, N - k - 1);
        reverse(nums, N - k, N - 1);
        reverse(nums, 0, N - 1);
    }

    public static void reverse(int[] nums, int L, int R) {
        while (L < R) {
            int tmp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = tmp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        if (k == 0) {
            return;
        }
        int L = 0;
        int R = N - 1;
        int lpart = N - k;
        int rpart = k;
        int same = Math.min(lpart, rpart);
        int diff = lpart - rpart;
        exchange(nums, L, R, same);
        while (diff != 0) {
            if (diff > 0) {
                L += same;
                lpart = diff;
            } else {
                R -= same;
                rpart = -diff;
            }
            same = Math.min(lpart, rpart);
            diff = lpart - rpart;
            exchange(nums, L, R, same);
        }
    }

    public static void exchange(int[] nums, int start, int end, int size) {
        int i = end - size + 1;
        int tmp = 0;
        while (size-- != 0) {
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            start++;
            i++;
        }
    }

}
