package my.learning.union.find;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickFindTest {

    @Test
    public void testUnion() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(6, 1);

        assertEquals(1, quickFind.data[6]);
        assertEquals(1, quickFind.data[1]);
    }

    @Test
    public void testUnionTwoCells() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(6, 1);
        quickFind.union(6, 7);

        assertEquals(7, quickFind.data[1]);
        assertEquals(7, quickFind.data[6]);
        assertEquals(7, quickFind.data[7]);
    }

    @Test
    public void testUnionTwoCellsDifferentOrder() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(0, 1);
        quickFind.union(0, 2);

        assertEquals(2, quickFind.data[0]);
        assertEquals(2, quickFind.data[1]);
        assertEquals(2, quickFind.data[2]);
    }

    @Test
    public void testFind() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(6, 1);
        quickFind.union(6, 7);
        assertTrue(quickFind.isConnected(1, 7));
        assertFalse(quickFind.isConnected(0, 7));
    }
}