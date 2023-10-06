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
        
        ListNode copy = head;
        int size = 0;
        
        while(copy != null){
            size++;
            copy = copy.next;
        }
        size -= n;
        copy = head;
        int k = 1;
        if(size == 0)
            return head.next;
        ListNode prev = null;
        while(k <= size){
            prev = copy;
            copy = copy.next;
            k++;
        }
        if(prev == null)
            return null;
        if(prev.next != null)
        prev.next = prev.next.next;
        else{
            prev.next = null;
        }
        return head;
        
    }
}