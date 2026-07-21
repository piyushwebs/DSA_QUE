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
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        findPath(root,pPath,p);
        findPath(root,qPath,q);

        int pSize = pPath.size();
        int qSize = qPath.size();

        for(int i=0;i<pSize;i++)
        {
            for(int j=0;j<qSize;j++)
            {
                if(pPath.get(i) == qPath.get(j))
                {
                    return pPath.get(i);
                }
            }
        }
        return null;
    }

    public boolean findPath(TreeNode root,List<TreeNode> arr,TreeNode val)
    {
        if(root == null) 
        {
            return false;
        }

        if(root == val)
        {
            arr.add(root);
            return true;
        }



        if(findPath(root.left,arr,val))
        {
            arr.add(root);
            return true;
        }
        if(findPath(root.right,arr,val))
        {
            arr.add(root);
            return true;
        }

        return false;
    }
}