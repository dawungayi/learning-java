package Trees;

public class BinarySearchTree {

    private class Node {
        Node left, right;   // this node's left and right nodes: null by default
        int data;   // this node's data

        private Node(int data) {
            this.data = data;
        }
    }

    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    // insert
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {  // check for null pointer
            return new Node(value);
        }

        // less than: insert in left subtree
        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        }
        // greater than: insert in right subtree
        else if (value > current.data) {
            current.right = insertRecursive(current.right, value);
        }
        // equal: if current value is already in tree
        else {
            System.out.println("Data is already in Tree.");
            return current;
        }

        return current;
    }

    // contains
    public boolean contains(int value) {
        return containsRec(root, value);
    }

    private boolean containsRec(Node current, int value) {
        if (current == null)
            return false;

        else if (value == current.data)
            return true;

        else if (value < current.data)
            return containsRec(current.left, value);

        else  //  value < current.data
            return containsRec(current.left, value);

    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void delete(int value) {
            root = deleteRec(root, value);  // updates root tree
    }

    private Node deleteRec(Node current, int value) {
        // base case if subtree is empty
        if (current == null)
            return current;

        // otherwise recur down the tree
        if (value < current.data)
            current.left = deleteRec(current.left, value);  // go to left subtree
        else if (value > current.data)
            current.right = deleteRec(current.right, value); // go to right subtree

        // this node's data == value ==> this is the node to be deleted
        else {
            // node with only one child or no child
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            // node with 2 children: get inorder successor (smallest of right subtree)
            current.data = minValue(current.right);
            // Delete the inorder successor
            current.right = deleteRec(current.right, current.data);
        }
        return current;
    }

    // get the inorder successor: elt at the left-most end of this subtree
    public int minValue(Node current) {
        int minValue = current.data;
        while (current.left != null) {
            minValue = current.left.data;
            current = current.left;
        }
        return minValue;
    }

    // in-order traversal
    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }
    private void printInOrderRec(Node current) {
        if (current != null) {
            // 1. left subtree
            printInOrderRec(current.left);
            // 2. root node
            System.out.print(current.data + ", ");
            // 3. right subtree
            printInOrderRec(current.right);
        }
    }

    // pre-order traversal
    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println();
    }
    private void printPreOrderRec(Node current) {
        if (current != null) {
            // 1. root node
            System.out.print(current.data + ", ");
            // 2. left subtree
            printPreOrderRec(current.left);
            // 3. right subtree
            printPreOrderRec(current.right);
        }
    }

    // in-order traversal
    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println();
    }
    private void printPostOrderRec(Node current) {
        if (current != null) {
            // 1. left subtree
            printPostOrderRec(current.left);
            // 2. right subtree
            printPostOrderRec(current.right);
            // 3. root node
            System.out.print(current.data + ", ");
        }
    }


}
