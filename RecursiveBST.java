class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class RecursiveBST {
    Node root;

    // Recursive insert
    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        return node;
    }

    // Recursive search
    boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (key == node.data)
            return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Recursive inorder (Left, Node, Right)
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Recursive preorder (Node, Left, Right)
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Recursive postorder (Left, Right, Node)
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Recursive delete
    Node delete(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            // Node with one or no child
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            // Node with two children: get inorder successor
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }

        return node;
    }

    int minValue(Node node) {
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    public static void main(String[] args) {
        RecursiveBST bst = new RecursiveBST();

        int[] elements = { 50, 30, 20, 40, 70, 60, 80 };
        for (int e : elements)
            bst.root = bst.insert(bst.root, e);

        System.out.print("Inorder: ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println();

        // Search for a key
        int searchKey = 40;
        System.out.println("Searching " + searchKey + ": " + (bst.search(bst.root, searchKey) ? "Found" : "Not Found"));

        // Delete a node
        bst.root = bst.delete(bst.root, 50);

        System.out.print("Inorder after deleting 50: ");
        bst.inorder(bst.root);
        System.out.println();
    }
}
