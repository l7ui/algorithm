package leetcode.p160;

import leetcode.entity.ListNode;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0, countB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            countA++;
            curA = curA.next;
        }
        while (curB != null) {
            countB++;
            curB = curB.next;
        }
        int dif = countA - countB;
        while (dif > 0) {
            headA = headA.next;
            dif--;
        }
        while (dif < 0) {
            headB = headB.next;
            dif++;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
