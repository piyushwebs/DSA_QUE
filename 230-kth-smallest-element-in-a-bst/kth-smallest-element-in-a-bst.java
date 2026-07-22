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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        int[] ans = {-1};
        return inOrder(root,k,count,ans);
    }
    public int inOrder(TreeNode root, int k,int[] count,int[] ans)
    {
        if(root == null)
        {
            return -1;
        }

        ans[0] = inOrder(root.left,k,count,ans);
        count[0]+=1;

        if(ans[0]!=-1) return ans[0];
        
        if(count[0]==k)
        {
            return root.val;
        }
        ans[0] = inOrder(root.right,k,count,ans);
        return ans[0];

    }
}