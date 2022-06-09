package class34;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * Leetcode题目 : https://leetcode.cn/problems/shuffle-an-array/
 */
public class Problem_0384_ShuffleAnArray {

    class Solution {
        private int[] origin;
        private int[] shuffle;
        private int N;

        public Solution(int[] nums) {
            origin = nums;
            N = nums.length;
            shuffle = new int[N];
            for (int i = 0; i < N; i++) {
                shuffle[i] = origin[i];
            }
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            // 从n-1 ... 0 位置随机一个位置放在n位置
            // 从n-2 ... 0 位置随机一个位置放在n-1位置
            // ...
            for (int i = N - 1; i >= 0; i--) {
                int r = (int) (Math.random() * (i + 1));
                int tmp = shuffle[r];
                shuffle[r] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }

}
