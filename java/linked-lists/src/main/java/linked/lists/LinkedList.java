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
        Node<T> loopStart = loopStartNode();
        boolean first = false;

        while (item != null) {
            if (first && item == loopStart) {
                buffer.append(item);
                return buffer.toString();
            }

            if (!first && item == loopStart)
                first = true;

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

    public boolean hasLoop() {
        return loopStartNode() != null;
    }

    private Node<T> loopStartNode() {
        Node<T> oneStep = root;
        if (root == null)
            return null;

        Node<T> twoStep = oneStep.getNext();
        while (twoStep != null && oneStep != twoStep) {
            oneStep = oneStep.getNext();

            if (twoStep.getNext() == null)
                return null;

            twoStep = twoStep.getNext().getNext();
        }
        return (twoStep == oneStep ? oneStep : twoStep);
    }
}