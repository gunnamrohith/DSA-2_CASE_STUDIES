import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BST bst = new BST();
        AVLTree avl = new AVLTree();

        Node bstRoot = null;
        Node avlRoot = null;

        System.out.print("Enter number of comment IDs to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " comment IDs (integers):");
        for (int i = 0; i < n; i++) {
            int comment = scanner.nextInt();
            System.out.print(comment + " ");
            bstRoot = bst.insert(bstRoot, comment);
            avlRoot = avl.insert(avlRoot, comment);
        }

        System.out.println("\n");

        // BST Traversal
        System.out.print("BST Inorder Traversal: ");
        bst.inorder(bstRoot);

        System.out.println();

        // AVL Traversal
        System.out.print("AVL Inorder Traversal: ");
        avl.inorder(avlRoot);

        System.out.println("\n");

        // Heights
        int bstHeight = bst.height(bstRoot);
        int avlHeight = avl.height(avlRoot);

        System.out.println("BST Height: " + bstHeight);
        System.out.println("AVL Height: " + avlHeight);

        System.out.println();
        System.out.println("AVL performs better because it remains balanced.");

        scanner.close();
    }
}