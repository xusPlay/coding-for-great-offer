package class34;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * Leetcode题目 : https://leetcode.cn/problems/find-the-duplicate-number/
 * <p>
 * 知识点：【快慢指针】【单链表第一个入环结点问题】
 *
 * 思路：
 * 一个快指针、一个慢指针，他俩都从头出发，快指针一次走两步、慢指针一次走一步，
 * 如果他俩相遇，那么快指针回到头结点，快指针一次走一步，满指针继续一次走一步，他俩必定会再次相遇，相遇的结点就是第一个入环结点
 */
public class Problem_0287_FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
