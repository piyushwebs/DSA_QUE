/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            Node prev = q.poll();
            for(int i=0;i<n-1;i++)
            {
                Node temp = q.poll(); 
                prev.next = temp;
                if(prev.left!=null) q.offer(prev.left);
                if(prev.right!=null) q.offer(prev.right);
                prev = temp;
            }
            prev.next = null;
            if(prev.left!=null) q.offer(prev.left);
            if(prev.right!=null) q.offer(prev.right);

        }
        return root;
    }
}