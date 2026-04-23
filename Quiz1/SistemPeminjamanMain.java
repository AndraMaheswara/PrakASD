package Quiz1;
import java.util.Scanner;

public class SistemPeminjamanMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //inisialisasi data 
        SistemPeminjaman sistem = new SistemPeminjaman();
        sistem.inisialisasiData();

        int pilihan;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Update Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    sistem.tampilSemuaMahasiswa();
                    break;
                case 2:
                    System.out.println("\nDaftar Buku:");
                    sistem.tampilSemuaBuku();
                    break;
                case 3:
                    System.out.println("\nData Peminjaman:");
                    sistem.tampilSemuaPeminjaman();
                    break;
                case 4:
                    sistem.urutkanBerdasarkanDenda();
                    System.out.println("\nSetelah diurutkan (Denda terbesar):");
                    sistem.tampilSemuaPeminjaman();
                    break;
                case 5:
                    System.out.print("\nMasukkan NIM: ");
                    String nimCari = scanner.nextLine();
                    sistem.cariBerdasarkanNIM(nimCari);
                    break;

                //jawaban sesi 3B
                case 6: 
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.print("Masukkan Lama Pinjam Baru (hari): ");
                    int baru = scanner.nextInt();
                    sistem.updateLamaPinjam(nimUpdate, baru);
                    break;
                    
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        
        scanner.close();
    }
}