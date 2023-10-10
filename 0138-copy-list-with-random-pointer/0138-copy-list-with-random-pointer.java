/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
    
//     @Override
//     public string toString(){
//         return this.val+" "+this.next+" "+this.random;
//     }
// }
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node res = new Node(-1);
        Node ret = res;
        
        while(head != null){
            Node next = map.getOrDefault(head, new Node(head.val));
            
            res.next = next;
            res = res.next;
            
            map.put(head, res);
            // System.out.println(head.random+" "+map.get(head.random));
            if(head.random != null)
            res.random = map.getOrDefault(head.random, new Node(head.random.val));
            map.put(head.random, res.random);
            head = head.next;
        }
        return ret.next;
    }
}