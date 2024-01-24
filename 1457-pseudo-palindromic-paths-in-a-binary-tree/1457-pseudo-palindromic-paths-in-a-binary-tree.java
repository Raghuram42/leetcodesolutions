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
    public int pseudoPalindromicPaths (TreeNode root) {
        return s(root, new int[10]);
    }
    
    public int s(TreeNode root, int[] map){
        if(root == null)
            return 0;
        map[root.val]++;
        if(root.left == null && root.right == null){
            int tans = p(map) ? 1: 0;
            map[root.val]--;
            return tans;
        }
        int ans = s(root.left, map)+ s(root.right, map);
        map[root.val]--;
        return ans;
    }
    public boolean p(int[] m){
        boolean one = false;
        
        for(int next: m){
            if(next%2 == 1)
            {
                if(one)
                    return false;
                one = true;
            }
        }
        
        return true;
    }
}