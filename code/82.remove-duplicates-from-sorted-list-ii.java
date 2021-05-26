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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        
        ListNode prev = null;
        ListNode res= null;
        ListNode next = head.next;
    //     while(next != null && head.val == next.val)
    //         next = next.next;
    // if(head.next != null && head.val == head.next.val)
    //     head = next;
        while(head != null){
          next = head.next;
            
            if(next != null && head.val == next.val){
                while(next != null && head.val == next.val)
                next = next.next;
            }else{
                prev = head;
                if(res == null)
                    res =prev;
                head = next;
                continue;
            }
            if(prev != null)
                prev.next = next;
            head = next;
        }
        
        return res;
    }
}