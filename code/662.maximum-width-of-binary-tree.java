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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        root.val = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxWidth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int left = q.peek().val;
            int right = left;
            for (int i = 0; i < size; i++){
                root = q.poll();
                if (root.val > right) right = root.val;
                if (root.left != null) {
                    root.left.val = root.val * 2 - 1;
                    q.offer(root.left);
                }
                if (root.right != null){
                    root.right.val = root.val * 2;
                    q.offer(root.right);
                }
            }
            if ((right - left + 1) > maxWidth) maxWidth = right - left + 1;
        }
        return maxWidth;
    }
}