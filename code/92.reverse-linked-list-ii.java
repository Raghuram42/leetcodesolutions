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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode m_first = null;
        ListNode n_last = null;
        ListNode temp = head;
        if(m == n)
            return head;
        
        while(temp != null){
            m--;
            n--;
            if( m == 1){
                m_first = temp;
            }
            if(n == 0)
                n_last = temp;
            
            temp = temp.next;
        }
        ListNode next_l = n_last.next;
        ListNode next_f = null;
        if(m_first == null)
        next_f = head;
        else
            next_f = m_first.next;
        n_last.next = null;
        
        ListNode rev = reverse(next_f);
        // return rev;
        //System.out.println(m_first);
        if(m_first != null)
        m_first.next = rev;
        else
            head = rev;
    
        next_f.next = next_l;
        return head;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        
        ListNode prev = null;
        ListNode next = head;
        
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}