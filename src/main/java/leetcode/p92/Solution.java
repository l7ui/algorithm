package leetcode.p92;

import leetcode.entity.ListNode;

/**
 * 反转 m - n 范围内的链表
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, next = dummy;
        ListNode cur = head;

        while (n >= 1) {
            if (m == 2) {
                pre = cur;
            }
            if (n == 1) {
                next = cur.next;
                break;
            }
            cur =  cur.next;
            m--;
            n--;
        }

        ListNode start = pre.next;
        ListNode end = cur;

        end.next = null;
        pre.next = reverse(start);
        start.next = next;

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
