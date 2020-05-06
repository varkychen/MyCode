package linked.lists;

public class LinkedList<T> {
    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    public Node<T> mid() {
        ensureNotEmpty();

        Node<T> oneStep = root;
        Node<T> twoStep = oneStep.getNext();
        while (twoStep != null) {
            if (twoStep.getNext() != null) {
                twoStep = twoStep.getNext().getNext();
                oneStep = oneStep.getNext();
            } else
                break;
        }
        return oneStep;
    }

    public Node<T> add(Node<T> node) {
        if (root == null)
            root = node;
        else {
            Node<T> item = root;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(node);
        }
        return root;
    }

    public String toString() {
        if (root == null)
            return "";

        StringBuffer buffer = new StringBuffer();
        Node<T> item = root;
        while (item.getNext() != null) {
            buffer.append(item + "->");
            item = item.getNext();
        }
        buffer.append("null");
        return buffer.toString();
    }

    public Node<T> get(int elementAt) {
        ensureNotEmpty();

        Node<T> node = root;
        int i = 1;
        while (i++ < elementAt) {
            node = node.getNext();
            if (node == null)
                throw new IllegalStateException("List has only " + i + " elements !!");
        }
        return node;
    }

    private void ensureNotEmpty() {
        if (root == null)
            throw new IllegalStateException("List is empty !!");
    }
}