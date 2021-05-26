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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null)
            return head;
        int len = 1;
        ListNode clone = head;
        ListNode fst = null;
        while(head != null){
            if(k-1 == len)
                fst = head;
                head = head.next;
                len++;
        }
        
        ListNode sec = null;
        head = clone;
        k = len-k;
        len = 1;
        while(head != null){
            if(k-1 == len)
             sec = head;
            
            head = head.next;
                
        len++;
            
            
        }
        // System.out.println(fst.val+" "+sec.val);
        head = clone;
        if(fst == null && sec == null)
            return head;
            else
        if(fst == null){
            ListNode next1 = sec.next;
            ListNode next2 = head.next;
            sec.next = null;
            head.next = null;
            
            if(next1 != next2){
            next1.next = next2;
            sec.next = head;    
            head = next1;
            }else{
                next1.next =head;
                head = next1;
            }
                
            
        }else if(sec == null){
            ListNode next1 = fst.next;
            ListNode next2 = head.next;
            head.next = null;
            fst.next = null;
            
            if(next1 != next2){
            next1.next = next2;
            fst.next = head;    
            head = next1;
            }else{
                next1.next =head;
                head = next1;
            }
             
        }else if(sec != null && fst != null){
            int tmp = sec.next.val;
            sec.next.val = fst.next.val;
            fst.next.val =tmp;
            
        }
        
        
        return head;
    }
}

// 1-2-3-4-5-6;

// f -> 1
// s -> 4
    
// nex1 = 2 -3- 4
// next2 = 5-6 
//     f.n = null;
//     s.n = null;
//     f.n = sec.n;
//     sec.n = next1.n;
//     s.n = next1;
//     nex1.next = next2.n; 
// 1-5-3-4-5-6 
    