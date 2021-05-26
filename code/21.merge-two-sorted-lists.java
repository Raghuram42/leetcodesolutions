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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1 == null && l2 == null)
            return null;
            
        ListNode res = null;
        ListNode last = res;
       
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    if(res == null){
                        last = l1;
                        res = l1;
                    }
                    else{
                        res.next = l1;
                        res = res.next;
                    }
                    l1 = l1.next;
                    
                }
                else{
                         if(res == null){
                        last = l2;
                        res = l2;
                    } else{
                        res.next = l2;
                        res = res.next;
                    }
                    l2 = l2.next;
                }
            }
            else if(l1 != null ){
                 res.next = l1;
                        res = res.next;
                l1 = l1.next;
            }
            else if(l2 != null ){
                 res.next = l2;
                        res = res.next;
                l2 = l2.next;
            }
        }
        return last;
    }
}