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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                if(a != null && b != null)
                    return a.val-b.val;
                if(a == null)
                    return b.val;
                
                return a.val;
            }
        });
        int i=0;
        ListNode tempres = new ListNode(-1);
        ListNode res = tempres;
        int[] index= new int[lists.length];
        while(i<lists.length){
            ListNode curr = lists[i];
            if(curr != null)
            pq.offer(curr);
            i++;
        }
        
        while(pq.size() > 0){
            ListNode curr = pq.poll();
            
            tempres.next = curr;
            tempres = tempres.next;
            
            if(curr.next != null)
                pq.offer(curr.next);
        }
        
        return res.next;
    }
}