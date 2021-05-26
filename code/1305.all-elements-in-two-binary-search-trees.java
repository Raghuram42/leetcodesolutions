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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack<TreeNode>();
        Stack<TreeNode> stk2 = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root1 == null && root2 == null)
            return res;
        
        if(root1 != null){
        stk1.push(root1);
        buildStack(stk1);
        }
        if(root2 != null){
        stk2.push(root2);
        buildStack(stk2);
        }
        
        if(root1 == null){
            while(stk2.size() > 0)
            sort(stk2, res);
            return res;
        }
        if(root2 == null){
            while(stk1.size() > 0)
            sort(stk1, res);
            return res;
        }
        
        while(stk1.size() > 0 || stk2.size() > 0){
            if(stk1.size() > 0 && stk2.size() > 0){
                if(stk1.peek().val < stk2.peek().val){
              sort(stk1, res);
                }else{
                 sort(stk2, res);
                }
            
            }else if(stk1.size() > 0){
                    sort(stk1, res);
            } else if(stk2.size() > 0){
                    sort(stk2, res);
            }
            
        }
        return res;
    }
    
    public void sort(Stack<TreeNode> stk1, ArrayList<Integer> res){
           TreeNode c = stk1.peek();
                    if(c.left != null){
                        stk1.push(c.left);
                        c.left = null;
                        buildStack(stk1);
                    }
                    else{
                        res.add(c.val);
                    //    System.out.println(c.val);
                        stk1.pop();
                        if(c.right != null){
                            stk1.push(c.right);
                            buildStack(stk1);
                        }
                    }
    }
    
    public void buildStack(Stack<TreeNode> stk1){
        while(!stk1.isEmpty()){
            TreeNode curr = stk1.peek();
            
            if(curr.left == null){
                break;
            }
            if(curr.left != null)
            {
                stk1.push(curr.left);
                curr.left = null;
            }
        } 
    }
}