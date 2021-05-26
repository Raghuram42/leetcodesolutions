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
    boolean wtoadd;
    public int rob(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        wtoadd = false;
        res = solve(root);
 //       System.out.println(res);
        if(res.size() == 0)
            return 0;
            return Math.max(res.get(0), res.get(1));
    }
    
    public ArrayList<Integer> solve(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            res.add(0);
            res.add(0);
            return res;
        }
        
        ArrayList<Integer> lf = solve(root.left);
        ArrayList<Integer> rg = solve(root.right);
        
            res.add(root.val+lf.get(1)+rg.get(1));
            res.add(Math.max(lf.get(0), lf.get(1)) +Math.max(rg.get(0),rg.get(1)));
            

        return res;
    }
    
}