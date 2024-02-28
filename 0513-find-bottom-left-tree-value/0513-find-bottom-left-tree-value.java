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
    class Side{
        TreeNode r;
        boolean left;
        
        Side(TreeNode r, boolean left){
            this.r = r;
            this.left = left;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        
        List<Integer> li = new ArrayList<>();
        
        Queue<Side> q = new LinkedList<>();
        
        q.offer(new Side(root, true));
        li.add(root.val);
        
        while(!q.isEmpty()){
            int sz = q.size();
            int or = q.size();
            while(sz > 0 ){
                Side node = q.poll();
                
                    if(sz == or)
                        li.set(0, node.r.val);
                
                
                if(node.r.left != null)
                    q.offer(new Side(node.r.left, true));
                
                  if(node.r.right != null)
                    q.offer(new Side(node.r.right, node.r.left == null));
                sz--;
            }
            
        }
        
        return li.get(0);
    }
}