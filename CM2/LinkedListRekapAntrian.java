package CM2;

public class LinkedListRekapAntrian {
    NodeRekapAntrean head;
    NodeRekapAntrean tail;
    int size;

    public LinkedListRekapAntrean() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(int noAntrean, Pembeli data) {
        if (isEmpty()) {
            head = new NodeRekapAntrean(null, noAntrean, data, null);
            tail = head;
        } else {
            NodeRekapAntrean newNode = new NodeRekapAntrean(tail, noAntrean, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

}