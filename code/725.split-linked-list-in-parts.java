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
    int i;
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int len = getLength(head);
        
        ListNode[] res = new ListNode[k];
        int firstSize = len/k + (len%k);
        if(k >= len){
            firstSize = 1;
            k=1;
            len =1;
        }
        
 
        i = 0;

        ListNode next = null;
        if(len%k != 0){
        next = solve(head, (len/k)+1, len%k, res);
        solve(next, len/k, 1001, res);
        }else
            solve(head, (len/k), 1001, res);
        return res;
        
            
        
            
    }
    
    public int getLength(ListNode node){
        int i = 0;
        
        while(node != null){
            node = node.next;
            i++;
        }
        return i;
    }
    
    public ListNode solve(ListNode head, int len, int rem, ListNode[] res){
        ListNode next = head;
        ListNode start = next;
        int st  = 1;
        while(next != null && rem > 0){
            
            if(st%(len) == 0){
                res[i++] = start;
                start = next;
                next = next.next;
                start.next = null;
                start = next;
                rem--;
            }else
                next = next.next;
            st++;
        }
        
        return next;
    }
}