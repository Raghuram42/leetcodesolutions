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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int len;
    ListNode root;
    public Solution(ListNode head) {
        root = head;
        len = 0;
        
        while(head != null){
            len++;
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ind = (int)(Math.random()*100)%len;
        // System.out.println(ind);
        ListNode curr = root;
        for(int i =0;i<ind;i++)
            curr=curr.next;
        
        return curr.val;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */