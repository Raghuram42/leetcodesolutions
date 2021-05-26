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
public class snode {
    TreeNode node;
    int d;
    snode(TreeNode nodes, int depth){
         this.node = nodes;
         this.d = depth;
    }
}
class Solution {
    int dp1 = 0;
    int dp2 = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<snode> stk = new Stack<snode>();
        snode sn = new snode(root, 1);
        stk.push(sn);
        snode xx = null;
        snode yy = null;
        if(root!=null && root.val == x || root.val == y)
            return false;
        while(!stk.isEmpty()){
            
            TreeNode temp = stk.peek().node;
            int dep = stk.peek().d;
            if(temp.val == x && xx == null){
                snode a = stk.pop();
                xx =stk.peek();
                stk.push(a);

            }
            if(temp.val == y && yy == null){
                snode b = stk.pop();
                //if(!isEmptyStack)/
                yy = stk.peek();
                stk.push(b);
            }
            if(temp.left == null && temp.right == null)
                stk.pop();
            
            if(temp.left != null){
                stk.push( new snode(temp.left, dep+1));
                temp.left = null;
                continue;
            }
             
            if(temp.right != null){
                stk.push( new snode(temp.right, dep+1));
                temp.right = null;
            }
        }
        
        return xx.node.val !=  yy.node.val && xx.d == yy.d;
        
    }
}