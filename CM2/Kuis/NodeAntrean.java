package CM2;

public class NodeAntrean {
    int noAntrean;
    Pembeli data;
    NodeAntrean prev;
    NodeAntrean next;

    public NodeAntrean(NodeAntrean prev, int noAntrean, Pembeli data, NodeAntrean next) {
        this.prev = prev;
        this.noAntrean = noAntrean;
        this.data = data;
        this.next = next;
    }
}
