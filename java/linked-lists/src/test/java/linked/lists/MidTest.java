package linked.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MidTest {

    @Test
    public void testTwoNodeMid() {
        Node<Integer> one = new Node<>(10);
        Node<Integer> two = new Node<>(10);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(one);
        list.add(two);
        assertEquals(one, list.mid());
    }

    @Test
    public void testTenNodeMid() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Node<>(i));
        }

        Node<Integer> mid = list.mid();
        Node<Integer> fifthNode = list.get(5);

        assertEquals(fifthNode, mid);
    }
}
