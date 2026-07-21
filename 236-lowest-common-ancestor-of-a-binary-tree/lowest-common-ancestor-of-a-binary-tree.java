/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == p || root == q)
        {
            return root;
        }
        TreeNode leftSide = findNode(root.left,p,q);
        TreeNode rightSide = findNode(root.right,p,q);

        if(leftSide == null)
        {
            return rightSide;
        }

        if(rightSide == null)
        {
            return leftSide;
        }

        return root;
    }

    public TreeNode findNode(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root == null)
        {
            return null;
        }

        if(root == p || root == q)
        {
            return root;
        }

        TreeNode leftSide = findNode(root.left,p,q);
        TreeNode rightSide = findNode(root.right,p,q);

        if(leftSide == null && rightSide == null)
        {
            return null;
        }

        if(leftSide == null)
        {
            return rightSide;
        }

        if(rightSide == null)
        {
            return leftSide;
        }

        return root;
    }

}