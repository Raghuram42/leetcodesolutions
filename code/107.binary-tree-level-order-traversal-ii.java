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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        
        dfs(root, 0);
        
        for(int i=0;i<res.size()/2;i++)
            Collections.swap(res, i, res.size()-i-1);
        return res;
    }
    
    public void dfs(TreeNode root, int i){ 
        if(root == null)
            return;
        
        if(res.size()<i+1)
            res.add(new ArrayList<Integer>());
        
        res.get(i).add(root.val);
        int curr = i+1;
        if(root.left != null)
            dfs(root.left, curr);
        
        if(root.right != null)
           dfs(root.right, curr);
        
    }
}