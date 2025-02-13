class BinaryTree {

    public class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private TreeNode root;

    public void add(int data) {
        root = addRec(root, data);
    }

    private TreeNode addRec(TreeNode current, int data) {
        if (current == null) {
            return new TreeNode(data);
        }

        if (data < current.data) {
            current.left = addRec(current.left, data);
        } else if (data > current.data) {
            current.right = addRec(current.right, data);
        }

        return current;
    }
}
