package my.learning.union.find;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WeightedQuickUnionTest {

    @Test
    public void testUnion() {
        WeightedQuickUnion unionFind = new WeightedQuickUnion(10);
        unionFind.union(6, 1);
        assertEquals(1, unionFind.data[6]);
        assertEquals(1, unionFind.data[1]);
    }

    @Test
    public void testUnionTwoCells() {
        WeightedQuickUnion unionFind = new WeightedQuickUnion(10);
        unionFind.union(6, 1);
        unionFind.union(6, 8);
        assertEquals(1, unionFind.data[6]);
        assertEquals(1, unionFind.data[1]);
        assertEquals(1, unionFind.data[8]);
        assertEquals(1, unionFind.counts[6]);
        assertEquals(3, unionFind.counts[1]);
        assertEquals(1, unionFind.counts[8]);
    }

    @Test
    public void testUnionNineCells() {
        WeightedQuickUnion unionFind = new WeightedQuickUnion(10);
        unionFind.union(6, 1);
        unionFind.union(6, 8);
        unionFind.union(7, 2);
        unionFind.union(5, 4);
        unionFind.union(4, 7);
        unionFind.union(6, 9);
        unionFind.union(0, 3);
        unionFind.union(3, 2);
        unionFind.union(5, 8);

        int[] result = { 3, 2, 2, 2, 2, 4, 1, 2, 1, 1 };
        int[] counts = { 1, 4, 10, 2, 2, 1, 1, 1, 1, 1 };
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], unionFind.data[i]);
            assertEquals(counts[i], unionFind.counts[i]);
        }

        assertTrue(unionFind.isConnected(9, 0));
    }
}