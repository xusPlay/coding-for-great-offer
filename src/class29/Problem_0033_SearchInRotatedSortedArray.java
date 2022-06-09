package class29;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * Leetcode题目：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * <p>
 * 知识点：【二分搜索】
 * <p>
 * 取 L 、M 、 R
 * <p>
 * <p>
 * 时间复杂度：最差情况：O(N)
 */
public class Problem_0033_SearchInRotatedSortedArray {

    // arr，原本是有序数组，旋转过，而且左部分长度不知道
    // 找num
    // num所在的位置返回
    public static int search(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        // 开始二分
        while (L <= R) {
            // M = L + ((R - L) >> 1)
            M = (L + R) / 2;
            if (arr[M] == num) {
                return M;
            }


            // arr[M] != num

            // 第一种情况： [L] == [M] == [R] != num  => 无法二分
            if (arr[L] == arr[M] && arr[M] == arr[R]) {
                // 把L向右移动，找到第一个和M位置不相同的数
                while (L != M && arr[L] == arr[M]) {
                    L++;
                }
                // 跳出while的情况：
                // 1) L == M L...M 一路都相等 => L = M + 1 继续去二分
                // 2) 从L到M终于找到了一个不等的位置
                if (L == M) { // L...M 一路都相等
                    L = M + 1;
                    continue;
                }
            }


            // ...
            // 有两种情况：
            // arr[M] != num
            // [L] [M] [R] 不都一样的情况, 如何二分的逻辑
            if (arr[L] != arr[M]) {

                // arr[M] > arr[L] => L...M 一定有序
                if (arr[M] > arr[L]) {
                    // 如果num 大于L 小于 M ，那么num如果存在一定在左边，否则一定在右边
                    if (num >= arr[L] && num < arr[M]) { //  3  [L] == 1    [M]   = 5   L...M - 1
                        R = M - 1;
                    } else { // 9    [L] == 2    [M]   =  7   M... R
                        L = M + 1;
                    }
                }
                // [L] > [M]    L....M  存在断点
                else {
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            }
            /// [L] [M] [R] 不都一样，  [L] === [M] -> [M]!=[R]
            else {
                if (arr[M] < arr[R]) {
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if (num >= arr[L] && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }

}
