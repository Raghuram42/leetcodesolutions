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
    public String serialize(TreeNode root) {
        return buildString(root).toString();
    }
    
    public StringBuilder buildString(TreeNode root){
        StringBuilder curr = new StringBuilder();
        if(root == null)
        {
            curr.append("$").append(",");
            return curr;
        }
        
        StringBuilder l = buildString(root.left);
        StringBuilder r = buildString(root.right);
        
        curr.append(root.val).append(",").append(l).append(r);
        return curr;
    }
    int i;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] inp = data.split(",");
        System.out.println(Arrays.toString(inp));
        return create(inp);
    }
    
    public TreeNode create(String[] inp){
        if(inp[i].equals("$") || i >= inp.length)
            return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(inp[i]));
        i++;
        root.left = create(inp);
        i++;
        root.right = create(inp);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));