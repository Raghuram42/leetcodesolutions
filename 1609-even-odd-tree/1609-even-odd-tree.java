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
    public boolean isEvenOddTree(TreeNode root) {
        boolean res = true;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        int l = 0;
        
        
        while(!q.isEmpty())
        {
            int sz = q.size();
            boolean first = true;
            int prev = -1;
            // int d = l%2 == 0 ? 1 : 0; 
            while(sz>0){
                TreeNode curr = q.poll();
                // System.out.println(first+" "+prev+" "+l+" "+curr.val);
                if(first){
                    first = false;
                    prev = curr.val;
                    if(prev%2 == l%2)
                        return false;
                }else if(curr.val%2 == 1 && l%2 == 0){
                    if(prev < curr.val)
                        prev = curr.val;
                    else
                        return false;
                }else if(l%2 == 1 && curr.val%2 == 0){
                    if(prev > curr.val)
                        prev = curr.val;
                    else
                        return false;
                }else
                    return false;
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                
                if(curr.right != null)
                    q.offer(curr.right);
                sz--;
            }
            l++;
            
        }
        return res;
    }
}