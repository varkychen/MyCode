package collections;

import linked.lists.Node;

public class CollectionUtils {

    public <T> Node<T> reverse(Node<T> root, ReverseType type) {
        if (root == null || root.getNext() == null)
            return root;
        else {
            return reverseRecursive(root);
        }
    }

    private <T> Node<T> reverseRecursive(Node<T> root) {
        if (root.getNext() != null) {
            Node<T> newRoot = reverseRecursive(root.getNext());
            root.getNext().setNext(root);
            root.setNext(null);
            return newRoot;
        }
        return root;
    }
}
