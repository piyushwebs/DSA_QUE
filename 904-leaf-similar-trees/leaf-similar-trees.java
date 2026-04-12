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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        checkList(root1,arr1);
        checkList(root2,arr2);
        if(arr1.equals(arr2)) return true;
        else return false;
    }
    public void checkList(TreeNode root,List<Integer> arr)
    {
        if(root==null)
        {
            return ;
        }
         if(root.left == null && root.right==null)
         {
            arr.add(root.val);
            return ;
         }
         checkList(root.left,arr);
         checkList(root.right,arr);
    }
}