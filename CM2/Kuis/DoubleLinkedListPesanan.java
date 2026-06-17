package CM2;

public class DoubleLinkedListPesanan {
    NodePesanan head;
    NodePesanan tail;
    int size;

    public DoubleLinkedListPesanan() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(Pesanan data) {
        if (isEmpty()) {
            head = new NodePesanan(null, data, null);
            tail = head;
        } else {
            NodePesanan newNode = new NodePesanan(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void manualSortByName() {
        if (size <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;
            while (current != null && current.next != null) {
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void printReport() {
        if (isEmpty()) {
            System.out.println("Belum ada laporan pesanan.");
            return;
        }
        manualSortByName();
        NodePesanan current = head;
        System.out.println("===============================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("===============================================");
        System.out.printf("%-15s %-20s %-10s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        System.out.println("------------------------------------------------");
        while (current != null) {
            System.out.printf("%-15d %-20s %-10d\n", current.data.kodePesanan, current.data.namaPesanan, current.data.harga);
            current = current.next;
        }
    }
}
