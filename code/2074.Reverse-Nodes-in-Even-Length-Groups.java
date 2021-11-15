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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode res = head;
        
        ListNode prev = head;
        head = head.next;
        int i = 2;
        while(head != null){
             int j = 1;
             int k = 1;
            while(j < i && head != null && head.next != null){
                head = head.next;
                k++;
                j++;
            }
            
            // System.out.println(i+" "+j+" "+k);
            if(k%2 == 0)
            {
                ListNode next = head.next;
                head.next = null;
                ListNode prevNext = prev.next;
                reverse(prevNext);
                prev.next = head;
                prevNext.next = next;
                head = prevNext;
            }
            prev = head;
            i++;
            if(head != null)
            head = head.next;
        }
        return res;
    }
    
    
    public void reverse(ListNode head){
        
        ListNode temp = head;
        ListNode prev = null;
       
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;            
        }

    }
}
