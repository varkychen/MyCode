package linked.lists;

public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return "(" + data.toString() + ")";
    }
}
