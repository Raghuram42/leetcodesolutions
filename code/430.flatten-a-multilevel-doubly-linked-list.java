/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        Node res = null;//new Node(-1);
        Node res1 = null;//new Node(-1);
        Stack<Node> stk = new Stack<Node>();
        
        while(head != null){
      
            if(res1 == null){
               res1 = new Node(head.val);
               res = res1;
            }
            else{
                res1.next = new Node(head.val);
         //       System.out.println(head.val);
                res1.next.prev = res1;
                res1= res1.next;
            }
            if(head.child != null){
            stk.push(head);
            head = head.child;
            }
            else{
                head = head.next;
            }
            
            if(head == null && !stk.isEmpty()){
                head = stk.pop().next;
            }
        }
        return res;
    }
}