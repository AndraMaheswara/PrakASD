package CM2;

public class DoubleLinkedListAntrean {
    NodeAntrean head;
    NodeAntrean tail;
    int size;

    public DoubleLinkedListAntrean() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(int noAntrean, Pembeli data) {
        if (isEmpty()) {
            head = new NodeAntrean(null, noAntrean, data, null);
            tail = head;
        } else {
            NodeAntrean newNode = new NodeAntrean(tail, noAntrean, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeByNo(int noAntrean) {
        if (isEmpty()) {
            return;
        }
        NodeAntrean current = head;
        while (current != null) {
            if (current.noAntrean == noAntrean) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public Pembeli getByNo(int noAntrean) {
        NodeAntrean current = head;
        while (current != null) {
            if (current.noAntrean == noAntrean) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Antrean Kosong");
            return;
        }
        NodeAntrean current = head;
        System.out.println("----------------------------------------------");
        System.out.printf("%-12s %-20s %-15s\n", "No Antrian", "Nama", "No HP");
        System.out.println("----------------------------------------------");
        while (current != null) {
            System.out.printf("%-12d %-20s %-15s\n", current.noAntrean, current.data.namaPembeli, current.data.noHp);
            current = current.next;
        }
    }
}
