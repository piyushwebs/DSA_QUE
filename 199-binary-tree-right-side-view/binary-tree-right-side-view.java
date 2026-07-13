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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                root = q.poll();
                if(i==n-1) 
                {
                    ans.add(root.val);
                }
                if(root.left!=null)
                {
                    q.offer(root.left);
                }
                if(root.right!=null)
                {
                    q.offer(root.right);
                }
            }
        }
        return ans;
    }
}