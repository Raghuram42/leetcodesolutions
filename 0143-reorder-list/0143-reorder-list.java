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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode copy = head;
        
        
        ListNode first = head;
        ListNode second = head.next;
        
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        
        ListNode rev = first.next;
        first.next = null;
        rev = r(rev);
        ListNode prev = new ListNode(-1);

        while(copy != null && rev != null){
            ListNode nextC = copy.next;    
            ListNode nextRev = rev.next;
            
            prev.next = copy;
            prev = prev.next;
            prev.next = rev;
            prev = prev.next;
            rev = nextRev;
            copy =nextC;
        }
        
        if(copy != null)
            prev.next = copy;
        
        // return head;    
        
    }
    
    public ListNode r(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head =next;
        }
        
        return prev;
    }
    
}