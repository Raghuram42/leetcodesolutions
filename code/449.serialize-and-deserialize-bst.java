/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    ArrayList<Integer> preOrder;
    public String serialize(TreeNode root) {
        preOrder = new ArrayList<Integer>();
        preOrd(root);
        return preOrder.toString();
    }
    int ind;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 2)
            return null;
        // System.out.println("String "+data.substring(1,data.length()-1));
        // System.out.println("Array "+preOrder);
        ind = 0;
           preOrder = new ArrayList<Integer>();
        String[] pre = data.substring(1,data.length()-1).split(",");
        for(String s: pre)
         preOrder.add(Integer.parseInt(s.trim()));
   // System.out.println("data: "+data+" order "+preOrder);
        
        
        return buildTree(preOrder, preOrder.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode buildTree(ArrayList<Integer> pre, int key, int min, int max){
        if(ind >= pre.size())
            return null;
        
        TreeNode root = null;
        
        if(key > min && key < max){
            root = new TreeNode(key);
            ind++;
            if(ind < pre.size()){
              //   System.out.println("data: "+ind);
            root.left = buildTree(pre, pre.get(ind), min, key);
           //     System.out.println("data: "+ind);
        
            }
                        if(ind < pre.size())
                root.right = buildTree(pre, pre.get(ind), key, max);
            
        }
        
        return root;
        
    }
    public void preOrd(TreeNode root){
        if(root == null)
            return;
        preOrder.add(root.val);
        preOrd(root.left);
        preOrd(root.right);
        return;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;