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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q =new LinkedList<>();
        
        
        q.offer(root);
        List<Double> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            
            double sum = 0;
            int p = 0; 
            while(sz>0){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null)
                    q.offer(curr.left);
                
                
                if(curr.right != null)
                    q.offer(curr.right);
                p++;
                sz--;
            }
            
            res.add(sum/p);
        }
        return res;
    }
}