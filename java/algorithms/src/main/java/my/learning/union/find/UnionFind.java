package my.learning.union.find;

public interface UnionFind {
    void union(int p, int q);

    boolean isConnected(int p, int q);
}