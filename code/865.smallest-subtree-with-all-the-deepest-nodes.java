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
    TreeNode[] parents = new TreeNode[501];
    int[] depth = new int[501];
    TreeNode depn = null;
    int maxdep = 0;
    HashMap<Integer, Stack<Integer>> hsm = new HashMap<Integer, Stack<Integer>>(); 
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            return root;
        
         int mxdep = solve(root, 0);
        // System.out.println(hsm+" "+mxdep+" "+depth[mxdep]+" "+depn.val);
        // if(depth[mxdep]  == 2)
        //     return parents[depn.val].left != null && parents[depn.val].right != null ? parents[depn.val]:root;
        // if(depth[mxdep]  == 1)
        //     return depn;
        // // else 
        
        Stack<Integer> stk = hsm.get(mxdep);
        // System.out.println(stk);
        TreeNode ans = null;
        if(stk.size() == 1)
            return depn;
        while(stk.size() > 0){
            TreeNode curr = parents[stk.pop()];
            if(ans == null)
                ans = curr;
            else if(curr.val != ans.val){
                mxdep--;
                // stk = hsm.get(mxdep);
                // stk.
                // System.out.println(curr.val+" "+ans.val);
                stk = new Stack<Integer>();
                if(parents[curr.val].val == parents[ans.val].val)
                    return parents[curr.val];
                stk.push(parents[curr.val].val);
                stk.push(parents[ans.val].val);
                ans = null;
            }
        }
        
        return ans;
    }
    
    public int solve(TreeNode root, int dep){
        if(root == null)
            return dep-1;
        if(!hsm.containsKey(dep))
            hsm.put(dep, new Stack<Integer>());
        
        hsm.get(dep).push(root.val);
        depth[dep] += 1;
        // maxdep = Math.max(depth[dep], maxdep);
        if(maxdep <= dep){
            maxdep = dep;
            
            depn = root;
        }
        if(root.left != null)
        parents[root.left.val] = root;
        if(root.right != null)
        parents[root.right.val] = root;
        
        return Math.max(solve(root.left, dep+1), solve(root.right, dep+1) );
    }
}