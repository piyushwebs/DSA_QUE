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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        idx = n-1;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            hm.put(inorder[i],i);
        }

        return formTree(postorder,hm,0,n-1);
    }

    public TreeNode formTree(int[] postorder,HashMap<Integer,Integer> hm,int start,int end)
    {
         if(start>end || start<0 || end<0 || start>postorder.length-1 || end>postorder.length-1 || idx<0)
         {
            return null;
         }
        
         TreeNode head = new TreeNode(postorder[idx--]);

         head.right = formTree(postorder,hm,hm.get(head.val)+1,end);
         head.left = formTree(postorder,hm,start,hm.get(head.val)-1);

         return head;
    }
}