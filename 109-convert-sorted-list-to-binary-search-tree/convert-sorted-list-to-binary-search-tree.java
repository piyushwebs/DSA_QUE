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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return breakList(head);
    }
    public TreeNode breakList(ListNode head)
    {
        if(head==null || head.next==null)
        {
            if(head == null) return null;
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev!=null) prev.next = null;
        ListNode next = null;
        if(slow!=null)
        {
             next = slow.next;
            slow.next = null;
        } 
        TreeNode root = new TreeNode(slow.val,breakList(head),breakList(next));
        return root;
    }
}