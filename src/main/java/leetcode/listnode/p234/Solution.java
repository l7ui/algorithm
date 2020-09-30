package leetcode.listnode.p234;

import leetcode.entity.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next, temp = next;
        slow.next = null;
        temp = reverse(temp);

        ListNode cur = head;
        while (cur != null && temp != null) {
            if (cur.val != temp.val) {
                return false;
            }
            cur = cur.next;
            temp = temp.next;
        }
        // 还原链表
        next = reverse(next);
        slow.next = next;
        return true;
    }

    public ListNode reverse(ListNode head) {
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
