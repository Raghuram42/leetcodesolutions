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
    public ListNode reverseKGroup(ListNode head, int k) {
        
         if(k== 1 || head == null)
             return head;
        int p = 1;
        ListNode res = null;
        ListNode prev = null;
        while(head != null){
            ListNode curr = head;
            p = 1;
            while(p%k != 0 && head != null){
                p++;
                head = head.next;
            }
            if(head == null){
                prev.next = curr;
            }else{
            ListNode next = head.next;
            head.next = null;
            
            if(prev == null){
                prev = curr;
                res = rev(curr);
            }else{
                prev.next = rev(curr);
                prev = curr;
            }
            
            head = next;
            }
        }
        
        return res;
    }
    
    public ListNode rev(ListNode node){
        ListNode prev = null;
        
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}