package P14;

public class BinaryTreeArrayMain27 {
    public static void main(String[] args) {
        BinaryTreeArray27 bta = new BinaryTreeArray27();

        System.out.println("=== PENGUJIAN TUGAS 4: add() & traversePreOrder() Array ===");
        bta.add(new Mahasiswa27("244160121", "Ali", "SIB-1E", 3.57));    // Indeks 0 (Root)
        bta.add(new Mahasiswa27("244160185", "Candra", "SIB-1E", 3.41)); // Indeks 1
        bta.add(new Mahasiswa27("244160221", "Badar", "SIB-1E", 3.75));  // Indeks 2
        bta.add(new Mahasiswa27("244160220", "Dewi", "SIB-1E", 3.35));   // Indeks 3
        bta.add(new Mahasiswa27("244160131", "Devi", "SIB-1E", 3.48));   // Indeks 4
        bta.add(new Mahasiswa27("244160205", "Ehsan", "SIB-1E", 3.61));  // Indeks 5
        bta.add(new Mahasiswa27("244160170", "Fizi", "SIB-1E", 3.86));   // Indeks 6

        System.out.println("\n[Output] InOrder Traversal Array:");
        bta.traverseInOrder(0);

        System.out.println("\n[Output] PreOrder Traversal Array:");
        bta.traversePreOrder(0);
    }
}