package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import linked.lists.Node;

import static collections.Reverse.RECURSIVE;

public class CollectionUtilsTest {

    @Test
    public void testReverseRecursiveNull() {
        CollectionUtils utils = new CollectionUtils();
        Node<Integer> newRoot = utils.reverse((Node<Integer>) null, RECURSIVE);
        assertNull(newRoot);
    }

    @Test
    public void testReverseRecursiveOne() {
        CollectionUtils utils = new CollectionUtils();

        Node<Integer> root = new Node<>(1);

        Node<Integer> newRoot = utils.reverse(root, RECURSIVE);
        assertEquals(root, newRoot);
    }

    @Test
    public void testReverseRecursiveTwo() {
        CollectionUtils utils = new CollectionUtils();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        one.setNext(two);

        Node<Integer> newRoot = utils.reverse(one, RECURSIVE);
        assertEquals(two, newRoot);
        assertEquals(one, newRoot.getNext());
    }

    @Test
    public void testReverseRecursiveThree() {
        CollectionUtils utils = new CollectionUtils();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(23);
        one.setNext(two);
        two.setNext(three);

        Node<Integer> newRoot = utils.reverse(one, RECURSIVE);
        assertEquals(three, newRoot);
        assertEquals(two, newRoot.getNext());
        assertEquals(one, newRoot.getNext().getNext());
        assertNull(newRoot.getNext().getNext().getNext());
    }
}