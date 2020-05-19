package my.learning.union.find;

public class QuickUnion implements UnionFind {

    public int[] data;

    public QuickUnion(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++)
            data[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        data[rootp] = rootq;
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
