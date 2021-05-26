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
    Stack<TreeNode> stk = new Stack<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        
        solve(root);
        int prev = stk.pop().val;
        while(!stk.isEmpty())
        {
            int curr = stk.pop().val;
            if(prev <= curr)
                return false;
            prev = curr;
        }
        return true;
    }
    
    public void solve(TreeNode root){
        if(root == null)
            return;
            solve(root.left);
            stk.push(root);
            solve(root.right);
    }
}