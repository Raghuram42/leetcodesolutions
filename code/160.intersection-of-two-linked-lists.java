/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hst = new HashSet<>();
        
        while(headA != null || headB != null){
            if(headA != null){
                if(hst.contains(headA))
                    return headA;
            hst.add(headA);
                headA = headA.next;
                }
            
            if(headB != null){
                if(hst.contains(headB))
                    return headB;
            hst.add(headB);
                headB = headB.next;
                }
        }
        
        return null;
        
    }
}