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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        
        stk.push(root);
        int res = 0;
        while(!stk.isEmpty()){
            TreeNode tmp = stk.pop();
            res++;
            if(tmp.left!=null){
                stk.push(tmp.left);
            }
                
                if(tmp.right!=null){
                    stk.push(tmp.right);
                }
        }
        return res;
    }
}