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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        
        ListNode root = head;
        int len = getlen(root);
        if(k%len == 0)
            return head;
        if(k>len)
            k = k%len;
        
        return solve(head ,len-k);
    }
    
    public int getlen(ListNode root){
        if(root == null)
            return 0;
        
        return 1+getlen(root.next);
    }
    
    public ListNode solve(ListNode root, int k){
        ListNode head = root;
        
        while(head != null && k > 1){
            k--;
            head = head.next;
        }
        if(head == null)
            return root;
        ListNode next = head.next;
        head.next = null;
        ListNode curr = next;
        while(curr != null && curr.next != null)
            curr = curr.next;
        if(curr != null)
        curr.next = root;
        
        return next;
    }
}