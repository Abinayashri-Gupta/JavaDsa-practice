import java.util.LinkedList;
import java.util.Queue;

// Node class
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// Binary Tree class
public class BinaryTree {
    Node root;

    // Preorder traversal (Root, Left, Right)
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder traversal (Left, Root, Right)
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder traversal (Left, Right, Root)
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Function to delete a node
    void delete(int key) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.data == key)
                root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node target = null, temp = null;

        // Find the target node and last node (deepest rightmost)
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key)
                target = temp;

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }

        // Replace target node with the last node
        if (target != null) {
            int x = temp.data; // last node's data
            deleteDeepest(temp);
            target.data = x;
        }
    }

    // Helper to delete the deepest node
    void deleteDeepest(Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creating a binary tree:
        /*
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder before deletion: ");
        tree.inorder(tree.root);
        System.out.println();

        tree.delete(2); // Delete node with value 2

        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}
