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
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if(len == 0)
            return null;
        TreeNode res = new TreeNode(preorder[0]);
        
        for(int i=1;i<len;i++){
            TreeNode temp = res;
            TreeNode prev = null;
            while(temp != null ){
                prev = temp;
                if(temp.val > preorder[i])
                temp =temp.left;
                else
                    temp = temp.right;
                
            }
            if(prev.val > preorder[i])
             prev.left = new TreeNode(preorder[i]);
            else
                prev.right = new TreeNode(preorder[i]);
        }
        return res;
    }
}