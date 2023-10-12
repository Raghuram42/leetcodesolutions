/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map; 
    HashSet<Node> vis;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        map = new HashMap<>();
        vis = new HashSet<>();
        return dfs(node);
    }
    
    public Node dfs(Node n){
        if(vis.contains(n))
            return map.get(n);
        
        vis.add(n);
        Node curr = map.getOrDefault(n, new Node());
        map.put(n, curr);
        curr.val = n.val;
        
        for(Node ne: n.neighbors){
            curr.neighbors.add(dfs(ne));
        }
        
        return curr;
    }
}