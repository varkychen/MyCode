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

    @Override
    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);

        if (counts[proot] <= counts[qroot]) {
            data[proot] = qroot;
            counts[qroot] += counts[proot];
        } else {
            data[qroot] = proot;
            counts[proot] += counts[qroot];
        }
    }

    private int findRoot(int p) {
        while (data[p] != p)
            p = data[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

}
