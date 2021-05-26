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
    int res;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        ArrayList<Integer> sum = new ArrayList<Integer>();
        int res = 0;
        while(!stk.isEmpty()){
            TreeNode tmp = stk.peek();
    
            if(tmp.left == null && tmp.right == null){
                sum.add(tmp.val);
                stk.pop();
            }
            
            if(tmp.left != null)
            {
                    stk.push(tmp.left);
                    tmp.left = null;
                    continue;
            }
            
            if(tmp.right != null){
                sum.add(tmp.val);
                stk.pop();
                stk.push(tmp.right);
                tmp.right = null;
            }
            
        }
        
        boolean start  = false;
        for(int i: sum){
            if(i == L || i == R)
            {
                start = !start;
            }
            if(start)
                res += i;
         //   System.out.println(i);
        }
        return res+R;
        
    }
    
}