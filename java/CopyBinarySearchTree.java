/**
 * This class implements a Binary Search Tree (BST) for integers.
 *
 * It provides two methods for copying tree by pre‑order traversal:
 * one using a recursive approach and the other using an iterative approach with a stack.
 *
 * Additionally, it provides a method to compare two BSTs by their contents.
 *
 * <p>
 * Note: Duplicate keys are assumed to be disallowed.
 * </p>
 *
 */
public class CopyBinarySearchTree {
    public static void main(String[] args) {
        Node node = new Node(4);

        Node.insert(node, 1);
        Node.insert(node, 2);
        Node.insert(node, 3);
        Node.insert(node, 5);
        Node.insert(node, 6);
        Node.insert(node, 7);

        Node copy1 = Node.copyTreeIter(node);
        Node copy2 = Node.copyTreeRec(node);
        Boolean result = Node.equalsRec(copy1, copy2);

        assert result;
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

        public static Node copyTreeRec(final Node root) {
            if (root == null) {
                return null;
            }

            Node newRoot = new Node(root.data);
            newRoot.left = copyTreeRec(root.left);
            newRoot.right = copyTreeRec(root.right);
            return newRoot;
        }

        public static Node copyTreeIter(final Node root) {
            assert root != null;
            final Stack<Node> originStack = new Stack<>();
            final Stack<Node> copyStack = new Stack<>();

            final Node newRoot = new Node(root.data);
            originStack.push(root);
            copyStack.push(newRoot);
            while (!originStack.isEmpty()) {
                final Node cur = originStack.pop();
                final Node copyCur = copyStack.pop();

                if (cur.right != null) {
                    copyCur.right = new Node(cur.right.data);
                    originStack.push(cur.right);
                    copyStack.push(copyCur.right);
                }
                if (cur.left != null) {
                    copyCur.left = new Node(cur.left.data);
                    originStack.push(cur.left);
                    copyStack.push(copyCur.left);
                }
            }
            return newRoot;
        }

        public static Boolean equalsRec(final Node root1, final Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            if (root1.data != root2.data) {
                return false;
            }

            if (!equalsRec(root1.left, root2.left)) {
                return false;
            }

            return equalsRec(root1.right, root2.right);
        }
    }
}
