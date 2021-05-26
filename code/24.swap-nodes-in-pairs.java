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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;

        ListNode res = head.next;
   ListNode next = null;
        
        while(head != null && head.next != null){
         next = head.next;
        
        ListNode nextt =  next.next;  
            
            if(prev == null)
                prev = next;
            else{
                prev.next = next;
            }
        head.next = null;    
        next.next = head;
        prev = head;
        head = nextt; 
        }

        if(head != null)
            prev.next = head;
        return res;
        
        
    }
}