/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      if(head == null)
          return head;
        
       ListNode fast = head; 
       ListNode slow = head;
       boolean hasloop = false;

        while(fast !=null && fast.next != null){
         //   System.out.println(slow.val+" "+fast.val);
                   slow = slow.next;
            fast = fast.next.next;
              if(slow == fast){
                hasloop = true;
                break;
            }
     
          
        }
        
        if(!hasloop)
            return null;

        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}