/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode ptr = head.next;
        ListNode prev = head;
        ListNode last = head;
        int c = 0;
        while (last.next != null) {
            c++;
            last = last.next;
        }
        if ((c & 1) == 0) {
            int i = 0;
            ListNode stop = last;
            while (i < c / 2) {
                if (ptr.next != null) {
                    prev.next = ptr.next;
                    last.next = ptr;
                    prev = ptr.next;
                    ptr.next = null;
                    last = ptr;
                }
                ptr = prev.next;
                i++;
            }
        } else {
            int i = 0;
            ListNode stop = last;
            while (i <= c / 2) {
                if (ptr.next != null) {
                    prev.next = ptr.next;
                    last.next = ptr;
                    prev = ptr.next;
                    ptr.next = null;
                    last = ptr;
                }
                ptr = prev.next;
                i++;
            }
        }
        return head;
    }
}