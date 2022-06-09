package class33;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * Leetcode题目 : https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */
public class Problem_0237_DeleteNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
