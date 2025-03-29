public class FindRandomElementInSet {
    public static void main(String[] args) {
        Set<Node> set = Set.of(new Node(1), new Node(2), new Node(3), new Node(4), new Node(5));
        Node e = set.iterator().next();
    }

    private final static class Node {
        final int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
