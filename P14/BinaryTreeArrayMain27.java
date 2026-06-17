package P14;

public class BinaryTreeArrayMain27 {
    public static void main(String[] args) {
        BinaryTreeArray27 bta = new BinaryTreeArray27();

        System.out.println("=== PENGUJIAN BINARY TREE ARRAY (ABSEN 27) ===");

        // Mengisi data satu per satu memanfaatkan Tugas 4: method add()
        bta.add(new Mahasiswa27("244160121", "Ali", "A", 3.57));    // Indeks 0 (Root)
        bta.add(new Mahasiswa27("244160185", "Candra", "C", 3.41)); // Indeks 1 (Anak Kiri)
        bta.add(new Mahasiswa27("244160221", "Badar", "B", 3.75));  // Indeks 2 (Anak Kanan)
        bta.add(new Mahasiswa27("244160220", "Dewi", "B", 3.35));   // Indeks 3
        bta.add(new Mahasiswa27("244160131", "Devi", "A", 3.48));   // Indeks 4
        bta.add(new Mahasiswa27("244160205", "Ehsan", "D", 3.61));  // Indeks 5
        bta.add(new Mahasiswa27("244160170", "Fizi", "B", 3.86));   // Indeks 6

        // 1. Pengujian Cetak In-Order
        System.out.println("\n[Output] InOrder Traversal:");
        bta.traverseInOrder(0);

        // 2. Pengujian Cetak Pre-Order (Tugas 4)
        System.out.println("\n[Output] PreOrder Traversal:");
        bta.traversePreOrder(0);
    }
}
