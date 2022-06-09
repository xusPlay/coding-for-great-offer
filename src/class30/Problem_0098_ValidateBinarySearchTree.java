package class30;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * Leetcode题目 : https://leetcode.cn/problems/validate-binary-search-tree/
 * <p>
 * 难度：【中等】
 * <p>
 * 知识点：【Morris遍历】
 */
public class Problem_0098_ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        Integer pre = null;
        boolean ans = true;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (pre != null && pre >= cur.val) {
                // 不能直接return false；需要跑完遍历
                ans = false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return ans;
    }

}
