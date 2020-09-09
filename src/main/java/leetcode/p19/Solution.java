package leetcode.p19;

import leetcode.entity.ListNode;

/**
 * 删除倒数第 n 个节点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode fast = head, slow = head;
        // 快指针先走 n 步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        // 若需要删除的是第一个节点，直接返回
        if (fast == null) {
            return head.next;
        }
        ListNode pre = slow;
        // 快指针走到头，慢指针跟着走
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}
