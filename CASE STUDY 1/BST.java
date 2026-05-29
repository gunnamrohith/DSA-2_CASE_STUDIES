class BST {

    // Insert into BST
    Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        }

        else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Calculate Height
    int height(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Inorder Traversal
    void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}