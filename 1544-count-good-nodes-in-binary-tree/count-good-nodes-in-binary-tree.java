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
    public int goodNodes(TreeNode root) {
        int ans  = 0;
        int max = Integer.MIN_VALUE;
        if(root.left==null && root.right ==null)
        {
            return 1;
        }
        return findVal(root,max);
    }

    public int findVal(TreeNode root, int max) {
        if(root == null) return 0;
        int count = 0;
        if(max<=root.val)
        {
           count=1;
        } 
        int currMax = Math.max(max,root.val);
        count += findVal(root.left, currMax );
        count += findVal(root.right, currMax );
       
        return count;
    }
}