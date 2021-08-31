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
    Stack<Integer> stk;
    public boolean checkEqualTree(TreeNode root) {
        stk = new Stack<>();
        getSum(root);
        int sum = stk.pop();
        if(sum%2 != 0)
            return false;
        
        while(!stk.isEmpty())
            if(stk.pop() == sum/2)
                return true;
        return false;
    }
    public int getSum(TreeNode root){
        if(root == null)
            return 0;
        stk.push(root.val+getSum(root.left)+getSum(root.right));
        return stk.peek();
    }
}
