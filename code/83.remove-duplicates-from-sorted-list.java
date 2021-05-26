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
        ListNode root = head;
        
        while(head != null){
            
            ListNode temp = head;
            
            while(temp.next != null && temp.next.val == head.val)
                temp = temp.next;
            
            head.next = temp.next;
            
            head = head.next;
        }
        
        return root;
    }
}