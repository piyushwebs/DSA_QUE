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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<m;i++)
        {
            hm.put(inorder[i],i);
        }

        return formTree(preorder,inorder,hm,0,n-1);
    }

    public TreeNode formTree(int[] preorder,int[] inorder,HashMap<Integer,Integer> hm,int start,int end)
    {

        if(start>end || end>=preorder.length || end<0 || start>=preorder.length || start<0 || idx>=preorder.length)
        {
            return null;
        }
        
        TreeNode head = new TreeNode(preorder[idx++]);
        head.left = formTree(preorder,inorder,hm,start,hm.get(head.val)-1);
        head.right = formTree(preorder,inorder,hm,hm.get(head.val)+1,end);

        return head;
    }
}