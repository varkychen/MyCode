package my.learning.union.find;

public class WeightedQuickUnion implements UnionFind {

    public int[] data;
    public int[] counts;

    public WeightedQuickUnion(int n) {
        data = new int[n];
        counts = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = i;
            counts[i] = 1;
        }
    }

    /*
     * Weighted Union implementation. For a given forest of trees array, we store
     * the counts of elements. For union operations, the element will lesser
     * elements will become part of the element with more elements.
     */
    @Override
    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);

        if (proot == qroot)
            return;

        if (counts[proot] <= counts[qroot]) {
            data[proot] = qroot;
            counts[qroot] += counts[proot];
        } else {
            data[qroot] = proot;
            counts[proot] += counts[qroot];
        }
    }

    /**
     * Find root of element. If an item index are the same, then it's a root.
     */
    private int findRoot(int p) {
        while (data[p] != p)
            p = data[p];
        return p;
    }

    /**
     * Check if two elements are connected. This would happen if they have the same
     * roots.
     */
    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

}
