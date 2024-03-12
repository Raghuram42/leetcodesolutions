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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode rev = null;
        
        while(head != null){
            ListNode next = head.next;
            
     
            if(head.val != 0){
            head.next= rev;
            rev = head;
            ListNode dumy = rev.next;
            int sum = rev.val;
            while(dumy != null){
                sum += dumy.val;
                
                if(sum == 0)
                {
                    rev = dumy.next;
                    break;
                }
                dumy = dumy.next;
            }
            }
            head = next;
            
            
        }
        
        head = null;
        while(rev != null){
            ListNode next = rev.next;
            rev.next = head;
            head = rev;
            rev = next;
        }
        return head;
    }
}