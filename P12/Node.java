package P12;

public class Node {
    Mahasiswa data;
    Node prev;
    Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}