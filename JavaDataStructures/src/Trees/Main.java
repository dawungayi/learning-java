package Trees;

public class Main {
    // BST
    // Insertion: O(log n)
    // Search: O(log n)
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Is Empty: " + tree.isEmpty());
        tree.insert(12);
        tree.insert(6);
        tree.insert(3);
        tree.insert(10);
        tree.insert(17);
        tree.insert(15);
        tree.insert(20);
        tree.insert(13);
        System.out.println(tree.contains(14));
        System.out.println("In-order");
        tree.printInOrder();

        // delete elt
        tree.delete(12);
        System.out.println("In-order");
        tree.printInOrder();

        System.out.println("Pre-order");
        tree.printPreOrder();
        // System.out.println("Post-order");
        // tree.printPostOrder();
        // System.out.println("Is Empty: " + tree.isEmpty());


    }

    public static void introBst() {
        // Node root = new Node(12);
        // root.insert(6);
        // root.insert(17);
        // root.insert(3);
        // root.insert(10);
        // root.insert(15);
        // root.insert(20);
        //
        // System.out.println("In order Traversal: ");
        // root.printInOrder();
        // System.out.println();
        //
        // System.out.println(root.contains(3));
        // System.out.println(root.contains(14));
    }
}
