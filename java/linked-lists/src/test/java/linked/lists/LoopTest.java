package linked.lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoopTest {

    @Test
    public void testNull() {
        LinkedList<Integer> list = new LinkedList<>();
        assertFalse(list.hasLoop());
    }

    @Test
    public void testOneItem() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        assertFalse(list.hasLoop());
    }

    @Test
    public void testOneItemLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        list.getRoot().setNext(list.getRoot());
        assertTrue(list.hasLoop());
    }

    @Test
    public void testTwoItem() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        list.add(new Node<>(1));
        assertFalse(list.hasLoop());
    }

    @Test
    public void testTwoItemLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));

        Node<Integer> end = new Node<>(1);
        list.add(end);
        end.setNext(list.getRoot());

        assertTrue(list.hasLoop());
    }

    @Test
    public void testThreeItem() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        list.add(new Node<>(1));
        list.add(new Node<>(2));
        assertFalse(list.hasLoop());
    }

    @Test
    public void testThreeItemLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Node<>(0));
        list.add(new Node<>(1));

        Node<Integer> end = new Node<>(2);
        list.add(end);
        end.setNext(list.getRoot());

        assertTrue(list.hasLoop());
    }

    @Test
    public void testManyItemLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            list.add(new Node<>(i));

        Node<Integer> end = new Node<>(10);
        list.add(end);
        end.setNext(list.getRoot());

        assertTrue(list.hasLoop());
    }

    @Test
    public void testEarringLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            list.add(new Node<>(i));

        Node<Integer> end = new Node<>(10);
        list.add(end);
        end.setNext(list.getRoot().getNext().getNext());

        System.out.println(list);

        assertTrue(list.hasLoop());
    }
}