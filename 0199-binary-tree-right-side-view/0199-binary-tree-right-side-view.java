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
    public List<Integer> rightSideView(TreeNode root) {
       
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> stk = new LinkedList<>();
        
        stk.add(root);
        while(!stk.isEmpty()){
            
            int sz = stk.size();
            boolean fir = true;
            while(sz > 0){
                if(sz == 1)
                    res.add(stk.peek().val);
                
                TreeNode curr = stk.poll();
                
                if(curr.left != null)
                    stk.add(curr.left);
                
                if(curr.right != null)
                    stk.add(curr.right);
                sz--;
            }
        }
        
        return res;
    }
}