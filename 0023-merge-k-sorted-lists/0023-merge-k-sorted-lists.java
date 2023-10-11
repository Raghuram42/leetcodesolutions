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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        
        int i = 1;
        if(n == 0)
            return null;
        ListNode head = lists[0];
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode ret = res;
        
        while(i<n){
            
            while(head != null && lists[i] != null){
                
                if(head.val <= lists[i].val){
                    res.next = head;
                    head = head.next;
                }else{
                    res.next = lists[i];
                    lists[i] = lists[i].next;
                }
                res = res.next;
            }
            
            if(head != null)
                res.next = head;
            
            if(lists[i] != null)
                res.next = lists[i];
            
            head = ret.next;
            res = ret;
            i++;
        }
        
        return ret.next;
    }
}