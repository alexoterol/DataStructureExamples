class BST {

    public class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    TreeNode root;
    void insert(int data) {
        root = insertRec(root, data);
    }
    TreeNode insertRec(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) root.left = insertRec(root.left, data);
        else root.right = insertRec(root.right, data);
        return root;
    }
}
