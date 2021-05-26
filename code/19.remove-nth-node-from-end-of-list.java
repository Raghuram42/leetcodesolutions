/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        ListNode root = head;
        Stack<ListNode> stk = new Stack<ListNode>();
        
        while(head != null){
            stk.push(head);
            head = head.next;
        }
        n = n+1;
        while(n!=0 && !stk.isEmpty()){
           head = stk.pop();
            n--;
        }
        if(n > 0)
            root = root.next;
        else
        head.next = head.next != null ? head.next.next : null;
        return root;
    }
}