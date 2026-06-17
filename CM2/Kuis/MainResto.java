package CM2;

import java.util.Scanner;

public class MainResto {
    public static void main(String[] args) {
        DoubleLinkedListAntrean listAntrean = new DoubleLinkedListAntrean();
        DoubleLinkedListPesanan listPesanan = new DoubleLinkedListPesanan();
        Scanner scan = new Scanner(System.in);
        int autoNoAntrean = 1;
        int pilih;

        do {
            System.out.println("=====================================");
            System.out.println("SISTEM ANTREAN ROYAL DELISH");
            System.out.println("=====================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = scan.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = scan.nextLine();
                    Pembeli p = new Pembeli(nama, noHp);
                    listAntrean.addLast(autoNoAntrean, p);
                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + autoNoAntrean);
                    autoNoAntrean++;
                    break;
                case 2:
                    System.out.println("=====================================");
                    System.out.println("Daftar Antrian Pembeli");
                    listAntrean.print();
                    break;
                case 3:
                    System.out.print("Masukkan No. Antrian yang akan dilayani: ");
                    int noHapus = scan.nextInt();
                    Pembeli mhsPesan = listAntrean.getByNo(noHapus);
                    if (mhsPesan != null) {
                        System.out.print("Kode Pesanan : ");
                        int kode = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String menu = scan.nextLine();
                        System.out.print("Harga        : ");
                        int harga = scan.nextInt();
                        Pesanan baru = new Pesanan(kode, menu, harga);
                        listPesanan.addLast(baru);
                        listAntrean.removeByNo(noHapus);
                        System.out.println(mhsPesan.namaPembeli + " telah memesan " + menu);
                    } else {
                        System.out.println("Nomor antrean tidak ditemukan.");
                    }
                    break;
                case 4:
                    listPesanan.printReport();
                    break;
                case 0:
                    System.out.println("Keluar program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilih != 0);

        scan.close();
    }
}
