package my.learning.union.find;

public class QuickFind {

    int[] data;

    public QuickFind(int size) {
        data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

    /*
     * Connect cell at location p with cell at location q. For all cells in the
     * array with cell value data[p], set it to data[q]
     * 
     * @param p Cell p
     * 
     * @param q Cell q
     */
    public void union(int p, int q) {
        int pid = data[p];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == pid)
                data[i] = data[q];
        }
    }

    /*
     * Check if data[p] and data[q] are connected
     * 
     * @param p Cell p
     * 
     * @param q Cell q
     */
    public boolean isConnected(int p, int q) {
        return data[p] == data[q];
    }

}
