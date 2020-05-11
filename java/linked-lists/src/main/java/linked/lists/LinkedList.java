package linked.lists;

import java.util.IdentityHashMap;
import java.util.Map;

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
        Node<T> loopStart = fetchLoopStart();
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
        return fetchLoopStart() != null;
    }

    private Node<T> fetchLoopStart() {
        /**
         * Floyd's algorithm: If there is no loop, hare will encounter the end first.
         * 
         * If a loop exists, let the start of the loop be at mu, length of the loop be
         * l. On moving hare twice as fast as tortoise, eventually hare and tortoise
         * will point to the same element. Let the distance from beginning to the
         * tortoise be v. Thus, distance from beginning to the hare will be 2v. v will
         * be a multiple of l as will 2v.
         * 
         * If we now reset the tortoise to the start, and move both tortoise and hare
         * one step at-a-time, the two will eventually meet at mu.
         */
        Node<T> tortoise = root, hare = root;
        do {
            if (hare == null || hare.getNext() == null)
                return null;
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
        } while (tortoise != hare);

        tortoise = root;
        while (tortoise != hare) {
            tortoise = tortoise.getNext();
            hare = hare.getNext();
        }
        return tortoise;
    }
}