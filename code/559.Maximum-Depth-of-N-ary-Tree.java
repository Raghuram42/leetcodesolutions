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
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        
        if(root.children == null)
            return 1;
        
        int res = 1;
        for(Node next: root.children)
            res = Math.max(res, 1+maxDepth(next));
        
        return res;
    }
}
