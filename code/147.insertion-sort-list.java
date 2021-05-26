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
    public ListNode insertionSortList(ListNode head) {
    if(head  == null)
        return null;
    if(head.next == null )
        return head;
     // if(head.next.next != null)
     //     return head;
            
      ListNode curr = insertionSortList(head.next);
      ListNode trav = curr;
      int key = head.val;
      ListNode prev = head;    
        while(trav != null && key > trav.val){
            prev.val = trav.val;
            prev = trav;
            trav = trav.next;
        }
        prev.val = key;
        // head.next = prev
        return head;
    }
    
}