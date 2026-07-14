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
    public int sumNumbers(TreeNode root) {
        List<String> arr = new ArrayList<>();
        StringBuilder str = new StringBuilder("");
        StringBuilder str1 = new StringBuilder("");
        if(root.left==null && root.right==null) return root.val;
        formString(root.left,arr,str.append(root.val));
        formString(root.right,arr,str1.append(root.val));
        int sum =0;
        for(int i=0;i<arr.size();i++)
        {
          sum+=Integer.parseInt(arr.get(i));
        }
        System.out.println(arr);
       return sum;
    }
    public void formString(TreeNode root,List<String> arr,StringBuilder str)
    {
        if(root==null) return;
        if(root.left == null && root.right == null)
        {
            str.append(root.val);
            arr.add(str.toString());
            return;
        }
        str.append(root.val);
        formString(root.left,arr,str);
        if(root.left!=null)
        {
          str.deleteCharAt(str.length()-1);
        }
        formString(root.right,arr,str);
        if(root.right!=null)
        {
          str.deleteCharAt(str.length()-1);
        }
    }
}