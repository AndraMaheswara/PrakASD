package P14;

public class BinaryTreeMain27 {
    public static void main(String[] args) {
        BinaryTree27 bst = new BinaryTree27();

        System.out.println("=== PENGUJIAN TUGAS 1: addRekursif() ===");
        // Menambahkan data menggunakan method rekursif
        bst.addRekursif(new Mahasiswa27("244160121", "Ali", "A", 3.57));
        bst.addRekursif(new Mahasiswa27("244160221", "Badar", "B", 3.85));
        bst.addRekursif(new Mahasiswa27("244160185", "Candra", "C", 3.21));
        bst.addRekursif(new Mahasiswa27("244160220", "Dewi", "B", 3.54));
        bst.addRekursif(new Mahasiswa27("244160131", "Devi", "A", 3.72));
        bst.addRekursif(new Mahasiswa27("244160205", "Ehsan", "D", 3.37));
        bst.addRekursif(new Mahasiswa27("244160170", "Fizi", "B", 3.46));

        System.out.println("Data berhasil dimasukkan secara rekursif.");
        System.out.println("\nInOrder Traversal Mahasiswa:");
        bst.traverseInOrder(bst.root);

        System.out.println("\n--------------------------------------------------");
        System.out.println("=== PENGUJIAN TUGAS 2: cariMinIPK() & cariMaxIPK() ===");
        bst.cariMinIPK();
        bst.cariMaxIPK();

        System.out.println("\n--------------------------------------------------");
        System.out.println("=== PENGUJIAN TUGAS 3: tampilMahasiswaIPKDiAtas() ===");
        // Menampilkan mahasiswa yang memiliki IPK di atas 3.50
        bst.tampilMahasiswaIPKDiAtas(3.50);
    }
}