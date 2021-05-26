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
        ListNode root = head;
        ListNode slowP = head;
        ListNode fastP = head.next;
        
        while(fastP != null && fastP.next != null){
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        ListNode next = slowP.next;
        slowP.next = null;
        ListNode prev = null;
        
        while(next != null){
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        ListNode a =root;
        ListNode b = prev;
        
        // while(a != null){
        //     System.out.println(a.val);
        //     a=a.next;
        // }
        
        // while(b != null){
        //     System.out.println(b.val);
        //     b=b.next;
        // }
        next = prev;
        prev = null;
        ListNode f_n = null;
            ListNode s_n = null;
        while(root != null && next != null){
             f_n = root.next;
             s_n = next.next;
            root.next = next;
            next.next = f_n;
            b = next;
            next = s_n;
            root = f_n;
            // if(prev == null)
            //     prev = next;
            // else
            //     prev.next = root;
            // if(next == null && root != null)
            //      b.next = slowP;
            
        }
       
           
            //prev.next = root;
        
     //   return head;
    }
}