package leetcode.p142;

import leetcode.entity.ListNode;

/**
 * 返回链表环的入口
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode inter = getInter(head);
        if (inter == null) {
            return null;
        }
        ListNode start = head;
        while (start != inter) {
            start = start.next;
            inter = inter.next;
        }

        return inter;
    }

    public ListNode getInter(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
