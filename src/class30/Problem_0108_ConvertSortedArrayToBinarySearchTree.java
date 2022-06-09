package class30;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡二叉树是一棵满足每个节点的左右两个子树的高度差的绝对值不超过1的二叉树
 * Leetcode题目 : https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * <p>
 * 难度：【简单】
 * <p>
 * 知识点：
 */
public class Problem_0108_ConvertSortedArrayToBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public static TreeNode process(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return new TreeNode(nums[L]);
        }
        // 取中点
        int M = (L + R) / 2;
        // 做递归
        TreeNode head = new TreeNode(nums[M]);
        head.left = process(nums, L, M - 1);
        head.right = process(nums, M + 1, R);
        return head;
    }

}
