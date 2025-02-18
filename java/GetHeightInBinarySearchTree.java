/**
 * This class implements a Binary Search Tree (BST) for integers.
 *
 * It provides method for getting height in BST using post-order traversal
 *
 */
public class GetHeightInBinarySearchTree {
    public static void main(String[] args) {
        Node node = new Node(4);

        Node.insert(node, 1);
        Node.insert(node, 2);
        Node.insert(node, 3);
        Node.insert(node, 5);
        Node.insert(node, 6);
        Node.insert(node, 7);

        int height = node.getHeightRec(node);
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

        public int getHeightRec(final Node node) {
            if (node == null) {
                return -1;
            }

            return Math.max(getHeightRec(node.left), getHeightRec(node.right)) + 1;
        }
    }
}
