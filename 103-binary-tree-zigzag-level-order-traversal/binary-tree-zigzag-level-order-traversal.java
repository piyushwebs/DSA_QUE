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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        while(!q.isEmpty())
        {
           int n = q.size();
           List<Integer> temp = new ArrayList<>();
           for(int j=0;j<n;j++)
           {
            root = q.poll();
            if(i%2==0)
            {
              temp.add(root.val);
            }
            else
            {
                temp.add(0,root.val);
            }
            if(root.left!=null) q.offer(root.left);
            if(root.right!=null) q.offer(root.right);
           }
           i++;
           ans.add(temp);
        }
        return ans;
    }
}