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
    ArrayList<ArrayList<Integer>> tra;
    int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        tra  = new ArrayList<ArrayList<Integer>>();
        res = 0;
        travers(new ArrayList<Integer>(), root);
        for(int i=0;i<tra.size();i++){
            System.out.println(tra.get(i));
        }
        return res;
    }
    
    public ArrayList<Integer> travers(ArrayList<Integer> rs, TreeNode tmp){
        
        if(tmp == null)
            return rs;
        
        rs.add(tmp.val);
        if(tmp.left != null){
            rs = travers(rs, tmp.left);
            rs.remove(rs.size()-1);
        }
        
        if(tmp.right != null){
            
            rs = travers(rs, tmp.right);
            rs.remove(rs.size()-1);
        }
        
        if(tmp.left == null && tmp.right == null){
            HashMap<Integer, Integer> tm = new HashMap<Integer, Integer>();
            int siz = rs.size();
            int mid = siz%2 == 0 ? siz/2 : (siz/2) -1;
            for(int i=0;i<siz;i++)
                tm.put(rs.get(i), tm.getOrDefault(rs.get(i), 0)+1);
            int evn = 0;
            int odd = 0;
             for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
                 if(entry.getValue()%2 == 0)
                     evn++;
                 else
                     odd++;
             }
            if(evn+odd == evn || odd == 1)
                res++;
                 //tm.add(rs.get(i));
                  //tra.add(tm);    
            //System.out.println(rs+" "+tmp.val);
        }
        return rs;
    }
}