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
    ArrayList<Integer> res;
    public int sumNumbers(TreeNode root) {
        res = new ArrayList<Integer>();
        dfs(root, 0);
        int sum = 0;
        for(int a: res){
            sum+=a;
        }
        return sum;
        
    }
    
    public void dfs(TreeNode root, int val){
        if(root == null)
            return;
        val = val * 10 +  root.val;
        if(root.left == null && root.right == null)
            res.add(val);
        
        dfs(root.left, val);
        dfs(root.right, val);
    }
}