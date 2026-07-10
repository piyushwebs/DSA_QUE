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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                root = q.poll();
                temp.add(root.val);
                if(root.left!=null)
                {
                    q.offer(root.left);
                }
                if(root.right!=null)
                {
                    q.offer(root.right);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}