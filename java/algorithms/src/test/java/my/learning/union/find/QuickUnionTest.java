package my.learning.union.find;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickUnionTest {

    @Test
    public void testUnion() {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(6, 1);
        assertEquals(1, quickUnion.data[6]);
        assertEquals(1, quickUnion.data[1]);
    }

    @Test
    public void testUnionTwoCells() {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(6, 1);
        quickUnion.union(6, 3);
        assertEquals(1, quickUnion.data[6]);
        assertEquals(3, quickUnion.data[1]);
        assertEquals(3, quickUnion.data[3]);
    }

    @Test
    public void testIsConnected() {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(6, 1);
        quickUnion.union(6, 3);
        assertTrue(quickUnion.isConnected(1, 3));
    }
}