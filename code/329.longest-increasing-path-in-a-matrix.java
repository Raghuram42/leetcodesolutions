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
    public ListNode oddEvenList(ListNode head) {
     if(head == null || head.next == null)
          return head;
     ListNode temp = head;
        int c =1;
        while(temp.next != null){
            c++;
            temp = temp.next;
        }
        ListNode res = head;
        int k =0;
        while(head != null && k != c/2){
            k++;
            temp.next = head.next;
            temp = temp.next;
     //       temp.next = null;
            head.next = head.next.next;
            head = head.next;
        }
        temp.next = null;
        return res;
    }
}