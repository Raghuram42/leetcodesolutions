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
    public int findBottomLeftValue(TreeNode root) {
        
        int ans = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            int or = q.size();
            while(sz > 0 ){
                TreeNode node = q.poll();
                
                    if(sz == or)
                        ans = node.val;
    
                if(node.left != null)
                    q.offer(node.left);
                
                  if(node.right != null)
                    q.offer(node.right);
                sz--;
            }
            
        }
        
        return ans;
    }
}