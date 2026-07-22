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
        List<Integer> arr = new ArrayList<>();
        inOrder(root,k,arr);
        return arr.get(k-1);
    }
    public void inOrder(TreeNode root,int k,List<Integer> arr)
    {
        if(arr.size() == k) 
        {
           return ;
        }
        if(root == null)
        {
            return ;
        }
        inOrder(root.left,k,arr);
        arr.add(root.val);
        inOrder(root.right,k,arr);
    }

}