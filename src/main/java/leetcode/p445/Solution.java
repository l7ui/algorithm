package leetcode.p445;

import leetcode.entity.ListNode;

public class Solution {
    public ListNode addTwoNumbers (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int bit = 0, sum = 0;
        while (head1 != null && head2 != null) {
            sum = head1.val + head2.val + bit;
            bit = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        ListNode notNull = head1 != null ? head1 : head2;
        while (notNull != null) {
            sum = notNull.val + bit;
            bit = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            notNull = notNull.next;
        }
        if (bit != 0) {
            cur.next = new ListNode(bit);
        }

        ListNode res = head.next;
        head.next = null;
        return reverse(res);
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
