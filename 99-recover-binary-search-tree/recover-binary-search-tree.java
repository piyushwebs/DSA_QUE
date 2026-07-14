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
    
    public void recoverTree(TreeNode root) {
     ArrayList<TreeNode> arr = new ArrayList<>();
     inOrder(root,arr);
     int idx=0;
     int idx1 = 0;
     for(int i=0;i<arr.size()-1;i++)
     {
        if(arr.get(i).val > arr.get(i+1).val)
        {
            idx = i;
            break;
        }
     }
     for(int i=arr.size()-1;i>0;i--)
     {
        if(arr.get(i).val<arr.get(i-1).val)
        {
            idx1 = i;
            break;
        }
     }
     int temp = arr.get(idx).val;
     arr.get(idx).val = arr.get(idx1).val;
     arr.get(idx1).val = temp;

    }
    public void inOrder(TreeNode root,ArrayList<TreeNode> arr)
    {
        if(root==null) return;
        inOrder(root.left,arr);
        arr.add(root);
        inOrder(root.right,arr);
    }

}