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
    HashMap<Integer, Node> hsm = new HashMap<Integer, Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(hsm.containsKey(node.val)){
            return hsm.get(node.val);
        }
        Node finalNode = new Node(node.val);
        //finalNode.neighbors = new List<Integer>();
        hsm.put(node.val, finalNode);
        for(Node curr : node.neighbors){
            finalNode.neighbors.add(cloneGraph(curr));
        }
        return finalNode;
    }
}