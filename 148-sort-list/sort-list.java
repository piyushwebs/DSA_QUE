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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null)
        {
           fast = fast.next.next;
           prev = slow;
           slow = slow.next;
        }
        if(prev!=null)
        {
          prev.next = null;
        }
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(slow);
        return mergeTwoList(leftList,rightList);
    }
    public ListNode mergeTwoList(ListNode leftList,ListNode rightList)
    {
        ListNode leftHead = leftList;
        ListNode rightHead = rightList;
        ListNode head = null;
        ListNode dummy = null;
        while(leftHead!=null && rightHead!=null)
        {
             ListNode temp = null;
           if(leftHead.val>rightHead.val)
           {
            temp = new ListNode(rightHead.val);
            rightHead = rightHead.next;
           }
           else
           {
            temp = new ListNode(leftHead.val);
            leftHead = leftHead.next;
           }
           if(head == null)
           {
            head = temp;
            dummy = head;
           }
           else
           {
            dummy.next = temp;
            dummy = dummy.next;
           }

        }
        while(leftHead!=null)
        {
            ListNode temp = new ListNode(leftHead.val);
            leftHead = leftHead.next;
            if(head == null)
            {
              head = temp;
              dummy = head;
            }
            else
            {
                dummy.next = temp;
                dummy = dummy.next;
            }
        }
        while(rightHead!=null)
        {
            ListNode temp = new ListNode(rightHead.val);
            rightHead = rightHead.next;
            if(head == null)
            {
                head = temp;
                dummy = head;
            }
            else
            {
                dummy.next = temp;
                dummy = dummy.next;
            }
        }
        return head;
    }
}