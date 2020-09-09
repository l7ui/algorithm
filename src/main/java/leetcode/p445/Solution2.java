package leetcode.p445;

import leetcode.entity.ListNode;

import java.util.Stack;

public class Solution2 {
    public ListNode addTwoNumbers (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }

        int bit = 0, sum = 0;

        Stack<Integer> s = new Stack<>();
        ListNode head = new ListNode(-1);
        while (!s1.isEmpty() || !s2.isEmpty() || bit != 0) {
            sum = 0;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            sum += bit;
            bit = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
        }

        return head.next;
    }
}
