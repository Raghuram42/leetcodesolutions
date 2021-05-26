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
    public int pathSum(TreeNode root, int sum) {
        TreeNode head = root;
        res = 0;
        if(head == null)
            return res;
   Stack<TreeNode> stk = new Stack<TreeNode>();
       stk.push(head);
        while(!stk.isEmpty()){
            TreeNode temp = stk.pop();
         dfs(temp, 0, sum, new StringBuilder());
            if(temp.left != null)
                stk.push(temp.left);
            if(temp.right != null)
                stk.push(temp.right);
        }
        
      //  dfs(root, 0, sum, new StringBuilder());
        return res;
    }
    public void dfs(TreeNode root, int currsum, int sum, StringBuilder str){
        if(root == null)
            return;
        currsum += root.val;
        str.append(root.val+" ->");
     //System.out.println(root.val+" path "+str.toString());
        if(sum == currsum){
 //       System.out.println(root.val+" "+str.toString());
            res++;
        }
        if(root.left != null){
           // dfs(root.left, 0, sum, new StringBuilder());
            dfs(root.left, currsum, sum, new StringBuilder(str));
        }
        if(root.right != null){
           // dfs(root.right, 0, sum, new StringBuilder());
            dfs(root.right, currsum, sum,  new StringBuilder(str));
        }
    }
}