/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        
        solve(root);
        return res;
    }
    
    public void solve(Node root){
        if(root == null)
            return;
        
        
        res.add(root.val);
        if(root.children.size() == 0)
            return;
        
        for(Node n: root.children)
            solve(n);
        
        
    }
}