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
    public int pairSum(ListNode head) {
        ListNode ptr = head;
        ListNode fast = head;
        ListNode slow = head;
        int ans = Integer.MIN_VALUE;
        ListNode prev = head;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ptr2 = reverse(slow);
        while(ptr2!=null)
        {
            ans = Math.max(ans,(ptr2.val+ptr.val));
            ptr2 = ptr2.next;
            ptr = ptr.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode head)
    {
        if(head == null) return head;
        ListNode ptr = head;
        ListNode prev = null;
        ListNode curr = head.next;
        while(ptr!=null)
        {
            ptr.next = prev;
            prev = ptr;
            ptr = curr;
            if(curr!=null)
            curr = curr.next;
        } 
        return prev;
    }
}