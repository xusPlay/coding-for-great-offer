package class30;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 这棵树如果是普通二叉树，该怎么做。
 * 你只能使用常量级额外空间。 => O(1)
 * Leetcode题目 : https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * <p>
 * 主思路：
 */
public class Problem_0116_PopulatingNextRightPointersInEachNode {

    // 不要提交这个类
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    // 提交下面的代码
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 使用自己实现的队列，利用二叉树的结点自己串起来
        MyQueue queue = new MyQueue();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 第一个弹出的节点
            Node pre = null;
            int size = queue.size;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }

    /**
     * 用二叉树的结点做一个队列
     * <p>
     * 三个多余变量  head、tail、size
     */
    public static class MyQueue {
        public Node head;
        public Node tail;
        public int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 压入
         *
         * @param cur
         */
        public void offer(Node cur) {
            size++;
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }

        /**
         * 弹出
         *
         * @return
         */
        public Node poll() {
            size--;
            Node ans = head;
            head = head.next;
            ans.next = null;
            return ans;
        }

    }

}
