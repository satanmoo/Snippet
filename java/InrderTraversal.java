import java.util.ArrayList;
import java.util.Stack;

/**
 * This class implements a Binary Search Tree (BST) for integers.
 *
 * It provides two methods for in‑order traversal:
 * one using a recursive approach and the other using an iterative approach with a stack.
 *
 * The in‑order traversal methods visit nodes in ascending order.
 */
public class InorderTraverals {
    public static void main(String[] args) {
        Node node = new Node(4);

        Node.insert(node, 1);
        Node.insert(node, 2);
        Node.insert(node, 3);
        Node.insert(node, 5);
        Node.insert(node, 6);
        Node.insert(node, 7);

        Node.traverseInOrderRec(node);
        System.out.println();
        System.out.println("-----");
        Node.traverseInOrderIter(node);
    }

    private static class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node(final int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public static void insert(final Node root, final int data) {
            insertRec(root, new Node(data));
        }

        private static Node insertRec(final Node root, final Node cur) {
            if (root == null) {
                return cur;
            }

            if (cur.data < root.data) {
                root.left = insertRec(root.left, cur);
            } else if (root.data < cur.data) {
                root.right = insertRec(root.right, cur);
            }
            return root;
        }

        public static void traverseInOrderRec(final Node root) {
            if (root == null) {
                return;
            }

            traverseInOrderRec(root.left);
            System.out.print(root.data + " ");
            traverseInOrderRec(root.right);
        }

        public static void traverseInOrderIter(final Node root) {
            final ArrayList<Node> list = new ArrayList<>();
            final Stack<Node> stack = new Stack<>();
            Node current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                Node top = stack.pop();
                list.add(top);
                current = top.right;
            }

            for (Node node : list) {
                System.out.print(node.data + " ");
            }
        }
    }
}
