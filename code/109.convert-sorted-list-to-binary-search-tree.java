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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
      list = new ArrayList<Integer>();
      
        ListNodeToList(head);
        
        return heightBalancedTree( 0 , list.size()-1);
        
    }
    public void ListNodeToList(ListNode head){
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
    }
    public TreeNode heightBalancedTree( int st, int end){
        if(st > end)
            return null;
        
        int mid = (st+end)/2;
        
        
        TreeNode newNode = new TreeNode(list.get(mid));
        newNode.left = heightBalancedTree(st, mid-1);
        newNode.right = heightBalancedTree(mid+1, end);
        
        return newNode;
    }
}