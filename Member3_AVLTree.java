class TreeNode {
    String location;
    TreeNode left, right;

    public TreeNode(String location) {
        this.location = location;
        left = right = null;
    }
}

public class Member3_AVLTree {
    private TreeNode root;

    private int height(TreeNode n) {
        if (n == null) return 0;
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    private int getBalance(TreeNode n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    private TreeNode insert(TreeNode node, String location) {
        if (node == null) return new TreeNode(location);

        if (location.compareToIgnoreCase(node.location) < 0)
            node.left = insert(node.left, location);
        else if (location.compareToIgnoreCase(node.location) > 0)
            node.right = insert(node.right, location);
        else
            return node;

        int balance = getBalance(node);

        if (balance > 1 && location.compareToIgnoreCase(node.left.location) < 0)
            return rotateRight(node);
        if (balance < -1 && location.compareToIgnoreCase(node.right.location) > 0)
            return rotateLeft(node);
        if (balance > 1 && location.compareToIgnoreCase(node.left.location) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && location.compareToIgnoreCase(node.right.location) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(String location) {
        root = insert(root, location);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println("- " + node.location);
            inorder(node.right);
        }
    }

    public void display() {
        if (root == null) System.out.println("No locations yet.");
        else inorder(root);
    }
}
