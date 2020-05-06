package linked.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(0);
        Node<Integer> root = list.add(node);
        assertEquals(node, root);
    }

    @Test
    public void testAddTwoNodes() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        Node<Integer> second = new Node<>(1);
        Node<Integer> root = list.add(second);
        assertNotEquals(second, root);
        assertEquals(second, root.getNext());
    }
}