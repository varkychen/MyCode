package my.learning.union.find;

public class WeightedQuickUnion implements UnionFind {

    int[] ancestor;
    int[] counts;

    public WeightedQuickUnion(int n) {
        ancestor = new int[n];
        counts = new int[n];

        for (int i = 0; i < n; i++) {
            ancestor[i] = i;
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
        if (isConnected(p, q))
            return;

        int proot = findRoot(p);
        int qroot = findRoot(q);

        if (counts[proot] <= counts[qroot]) {
            ancestor[proot] = qroot;
            counts[qroot] += counts[proot];
        } else {
            ancestor[qroot] = proot;
            counts[proot] += counts[qroot];
        }
    }

    /**
     * Find root of element. If an item index are the same, then it's a root.
     */
    private int findRoot(int p) {
        int root = p;
        while (ancestor[root] != root)
            root = ancestor[root];

        // Path compression
        int parent = ancestor[p];
        while (ancestor[parent] != parent) {
            ancestor[p] = root;
            counts[parent] -= counts[p];
            p = parent;
            parent = ancestor[parent];
        }

        return root;
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
