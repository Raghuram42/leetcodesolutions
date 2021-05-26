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
    HashMap<Integer, Integer> hsm;
    List<Integer> res;
    int maxdep;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        if(root == null)
            return res;
        hsm = new HashMap<Integer, Integer>();
        
        solve(root, 0);
        for(int i=0;i<maxdep;i++)
            if(hsm.containsKey(i))
            res.add(hsm.get(i));
        return res;
    }
    
    public void solve(TreeNode root, int dep){
        if(root == null)
            return;
        hsm.put(dep, root.val);
        maxdep = Math.max(maxdep, dep+1);
        solve(root.left, dep+1);
        solve(root.right, dep+1);
        
    }
}