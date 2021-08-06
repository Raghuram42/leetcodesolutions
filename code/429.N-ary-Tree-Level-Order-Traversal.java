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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<List<Integer>>();
        // HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        solve(root, 0);
        return res;
    }
    
    public void solve(Node root, int dep){
        if(root == null)
            return;
        if(res.size() == dep)
            res.add(new ArrayList<Integer>());
        
        res.get(dep).add(root.val);
        for(Node child: root.children)
            solve(child, dep+1);
    }
}
