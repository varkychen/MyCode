package linked.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ReverseTest {

    @Test
    public void testReverseOne() {
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(new Node<>(1));
        System.out.println(ints);

        ints.reverse();
        System.out.println(ints);

        Node<Integer> root = ints.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertNull(root.getNext());
    }

    @Test
    public void testReverseTwo() {
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(new Node<>(1));
        ints.add(new Node<>(2));
        System.out.println(ints);

        ints.reverse();
        System.out.println(ints);

        Node<Integer> root = ints.getRoot();
        assertEquals((Integer) 2, root.getData());
        assertEquals((Integer) 1, root.getNext().getData());
    }

    @Test
    public void testReverse() {
        LinkedList<Integer> ints = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            ints.add(new Node<>(i));
        System.out.println(ints);

        ints.reverse();
        System.out.println(ints);

        Integer data = 9;
        Node<Integer> root = ints.getRoot();
        while (root != null) {
            assertEquals(data--, root.getData());
            root = root.getNext();
        }
    }
}