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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode ret = res;
        while(l1 != null && l2 != null){
            int val = l1.val+l2.val+carry;
            
            res.next = new ListNode(val%10);
            carry = val/10;
            
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        l1 = l1 == null ? l2 : l1;
        
        if(l1 != null){
            while(l1 != null){
                int val = l1.val+carry;
                res.next = new ListNode(val%10);
                carry = val/10;
            
                res = res.next;
                l1 = l1.next;
            }
        }
        if(carry != 0)
            res.next = new ListNode(1);
        return ret.next;
    }
}

