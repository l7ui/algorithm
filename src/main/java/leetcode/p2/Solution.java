package leetcode.p2;

import leetcode.entity.ListNode;

/**
 * 链表计算两数之和（逆序）
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + bit;
            bit = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            int sum = l.val + bit;
            bit = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l = l.next;
        }
        if (bit != 0) {
            cur.next = new ListNode(bit);
        }

        return head.next;
    }
}
