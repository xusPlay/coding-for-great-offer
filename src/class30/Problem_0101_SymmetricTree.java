package class30;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * Leetcode题目 : https://leetcode.cn/problems/symmetric-tree/
 * <p>
 * <p>
 * 知识点：
 * <p>
 * <p>
 * 转化一下思维：两个树是否为镜像
 */
public class Problem_0101_SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    // 一棵树是原始树  head1
    // 另一棵是翻面树  head2
    public static boolean isMirror(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        // 都不为空
        if (head1 != null && head2 != null) {
            // 值相等
            // 左树和右树 是镜像
            // 右树和左树  是镜像
            return head1.val == head2.val
                    && isMirror(head1.left, head2.right)
                    && isMirror(head1.right, head2.left);
        }
        // 一个为空，一个不为空  false
        return false;
    }

}
