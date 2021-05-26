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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null)
            return new ArrayList<Integer>();
        TreeNode tmp = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        stk.push(tmp);
        while(!stk.isEmpty()){
        TreeNode t = stk.pop();
        res.add(t.val);
        if(t.right != null)
            stk.push(t.right);
        if(t.left != null)
            stk.push(t.left);
        }
        
        return res;
        
    }
}