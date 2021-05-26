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

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hsm = new HashMap<Node, Node>();
        if(head == null)
            return null;
        Node res = new Node(-10001);
        Node ans = res;
        while(head != null){
            if(!hsm.containsKey(head))
                 hsm.put(head, new Node(head.val));
            Node clonednod = hsm.get(head);
            if(head.random != null){
                if(!hsm.containsKey(head.random))
                    hsm.put(head.random, new Node(head.random.val));
                
                clonednod.random = hsm.get(head.random);
            }
            res.next = clonednod;
            res = res.next;
            head = head.next;
        }
        // Node t = new Node(-1);
        // hsm.put(t, t);
        // if(hsm.containsKey(new Node(-1)))
        //     System.out.println(4);
        
        return ans.next;
    }
}