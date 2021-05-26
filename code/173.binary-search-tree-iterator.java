public class BSTIterator {

    TreeNode head = new TreeNode();

    public BSTIterator(TreeNode root) {
        TreeNode ans = head;
        generateIncreasingOrderTree(root);
        head = ans.right;
    }

    private void generateIncreasingOrderTree(TreeNode node) {

        if (node != null) {
            generateIncreasingOrderTree(node.left);
            node.left = null;
            head.right = node;
            head = node;
            generateIncreasingOrderTree(node.right);
        }
    }

    public int next() {
        if (head != null) {
            int val = head.val;
            head = head.right;
            return val;
        }
        return 0;
    }

    public boolean hasNext() {
        return head != null;
    }
}