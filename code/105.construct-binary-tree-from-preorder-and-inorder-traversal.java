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
//Arrays.copyOfRange(array, 0, 2)
class Solution {
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        
        return solve(preorder,inorder, 0, inorder.length-1);
    }
    
    public TreeNode solve(int[] preorder, int[] inorder, int k, int j){
        if(j<k)
            return null;
        if(j-k == 0){
            i++;
            return new TreeNode(inorder[j]);
        }
        
        int index = indexOf(inorder, preorder[i]);
        // System.out.println(Arrays.toString(inorder)+" "+index+" "+i);
   
        
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = solve(preorder, inorder, k, index-1);
        root.right = solve(preorder, inorder, index+1, j);
        return root;
        
    }
    public int indexOf(int[] ary, int target){
        int p=0;
        
        while(p<ary.length){
            if(ary[p] == target)
                return p;
            
            p++;
        }
        return -1;
    }
}