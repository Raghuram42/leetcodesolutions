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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode middle = getMid(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode lft = sortList(head);
        ListNode rgt = sortList(next);
        return msort(lft, rgt);
    }
    public ListNode msort(ListNode l, ListNode r){
        if(l == null)
            return r;
        if(r == null)
            return l;
        ListNode res = null;
        // while(l != null &&  r != null){
            if(l.val <= r.val){
                res = l;
                res.next = msort(l.next, r);
            }
            else{
                res = r;
                res.next = msort(l, r.next);
            }
            
        // }
        return res;
    }
    public ListNode getMid(ListNode root){
        if(root == null)
            return root;
        
        ListNode slow = root;
        ListNode fast = root;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}