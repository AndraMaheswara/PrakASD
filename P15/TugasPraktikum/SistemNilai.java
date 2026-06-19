package P15.TugasPraktikum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SistemNilai {
    List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    List<MataKuliah> daftarMataKuliah = new ArrayList<>();
    
    // Menggunakan Queue (LinkedList) untuk menampung data nilai mahasiswa (Tugas Nomor 2)
    Queue<Nilai> antreanNilai = new LinkedList<>();

    public void inisialisasiDataAwal() {
        daftarMahasiswa.add(new Mahasiswa("20001", "Thalhah", "021xxx"));
        daftarMahasiswa.add(new Mahasiswa("20002", "Zubair", "021xxx"));
        daftarMahasiswa.add(new Mahasiswa("20003", "Abdur-Rahman", "021xxx"));
        daftarMahasiswa.add(new Mahasiswa("20004", "Sa'ad", "021xxx"));
        daftarMahasiswa.add(new Mahasiswa("20005", "Sa'id", "021xxx"));
        daftarMahasiswa.add(new Mahasiswa("20006", "Ubaidah", "021xxx"));

        daftarMataKuliah.add(new MataKuliah("00001", "Internet of Things", 3));
        daftarMataKuliah.add(new MataKuliah("00002", "Algoritma dan Struktur Data", 2));
        daftarMataKuliah.add(new MataKuliah("00003", "Algoritma dan Pemrograman", 2));
        daftarMataKuliah.add(new MataKuliah("00004", "Praktikum Algoritma dan Struktur Data", 3));
        daftarMataKuliah.add(new MataKuliah("00005", "Praktikum Algoritma dan Pemrograman", 3));
    }

    public void tampilMenu() {
        System.out.println("*************************************************");
        System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
        System.out.println("*************************************************");
        System.out.println("1. Input Nilai");
        System.out.println("2. Tampil Nilai");
        System.out.println("3. Mencari Nilai Mahasiswa");
        System.out.println("4. Urut Data Nilai");
        System.out.println("5. Hapus Nilai (Queue - FIFO)");
        System.out.println("6. Keluar");
        System.out.println("*************************************************");
    }

    public void inputNilai(Scanner sc) {
        System.out.print("Masukkan data\nNilai\t: ");
        double nilaiInput = sc.nextDouble();
        sc.nextLine();

        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println("*************************************************");
        System.out.printf("%-12s%-20s%-15s\n", "NIM", "Nama", "Telf");
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.printf("%-12s%-20s%-15s\n", mhs.nim, mhs.nama, mhs.telf);
        }
        System.out.print("Pilih mahasiswa by nim: ");
        String nimPilih = sc.nextLine();

        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.println("*************************************************");
        System.out.printf("%-10s%-40s%-5s\n", "Kode", "Mata Kuliah", "SKS");
        for (MataKuliah mk : daftarMataKuliah) {
            System.out.printf("%-10s%-40s%-5d\n", mk.kode, mk.nama, mk.sks);
        }
        System.out.print("Pilih MK by kode: ");
        String kodePilih = sc.nextLine();

        Mahasiswa mhsTerpilih = null;
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.nim.equals(nimPilih)) {
                mhsTerpilih = mhs;
                break;
            }
        }

        MataKuliah mkTerpilih = null;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.kode.equals(kodePilih)) {
                mkTerpilih = mk;
                break;
            }
        }

        if (mhsTerpilih != null && mkTerpilih != null) {
            antreanNilai.add(new Nilai(mhsTerpilih, mkTerpilih, nilaiInput));
        } else {
            System.out.println("NIM atau Kode Mata Kuliah tidak valid!");
        }
    }

    public void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.println("*************************************************");
        System.out.printf("%-12s%-15s%-40s%-7s%-7s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai n : antreanNilai) {
            System.out.printf("%-12s%-15s%-40s%-7d%-7.2f\n", n.mhs.nim, n.mhs.nama, n.mk.nama, n.mk.sks, n.nilai);
        }
        System.out.println();
    }

    public void cariNilaiMahasiswa(Scanner sc) {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.println("*************************************************");
        System.out.printf("%-12s%-15s%-40s%-7s%-7s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai n : antreanNilai) {
            System.out.printf("%-12s%-15s%-40s%-7d%-7.2f\n", n.mhs.nim, n.mhs.nama, n.mk.nama, n.mk.sks, n.nilai);
        }
        
        System.out.print("Masukkan data mahasiswa[nim] :");
        String nimCari = sc.nextLine();
        
        System.out.printf("%-12s%-15s%-40s%-7s%-7s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        int totalSks = 0;
        boolean ditemukan = false;
        
        for (Nilai n : antreanNilai) {
            if (n.mhs.nim.equals(nimCari)) {
                System.out.printf("%-12s%-15s%-40s%-7d%-7.2f\n", n.mhs.nim, n.mhs.nama, n.mk.nama, n.mk.sks, n.nilai);
                totalSks += n.mk.sks;
                ditemukan = true;
            }
        }
        
        if (ditemukan) {
            System.out.println("Total SKS " + totalSks + " telah diambil.");
        } else {
            System.out.println("Data nilai mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
        System.out.println();
    }

    public void urutDataNilai() {
        // Karena Queue tidak bisa diurutkan secara langsung, kita pindahkan sementara ke List
        List<Nilai> listSementaranilai = new ArrayList<>(antreanNilai);
        
        // Mengurutkan data berdasarkan nilai secara Ascending menggunakan Comparator
        Collections.sort(listSementaranilai, new Comparator<Nilai>() {
            @Override
            public int compare(Nilai n1, Nilai n2) {
                return Double.compare(n1.nilai, n2.nilai);
            }
        });

        System.out.println("\nDAFTAR NILAI MAHASISWA (URUT ASCENDING BY NILAI)");
        System.out.println("*************************************************");
        System.out.printf("%-12s%-15s%-40s%-7s%-7s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai n : listSementaranilai) {
            System.out.printf("%-12s%-15s%-40s%-7d%-7.2f\n", n.mhs.nim, n.mhs.nama, n.mk.nama, n.mk.sks, n.nilai);
        }
        System.out.println();
    }

    // Prosedur penghapusan data berbasis Queue FIFO (Tugas Nomor 2)
    public void hapusNilaiAntrean() {
        if (!antreanNilai.isEmpty() && antreanNilai.peek() != null) {
            Nilai dihapus = antreanNilai.poll(); // Menghapus elemen paling pertama masuk (FIFO)
            System.out.println("Berhasil menghapus nilai milik " + dihapus.mhs.nama + " untuk MK " + dihapus.mk.nama);
        } else {
            System.out.println("Antrean nilai kosong, tidak ada data yang bisa dihapus!");
        }
        System.out.println();
    }

    // LANGKAH 5: Main Method Uji Coba Program
    public static void main(String[] args) {
        SistemNilai sistem = new SistemNilai();
        sistem.inisialisasiDataAwal();
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        do {
            sistem.tampilMenu();
            System.out.print("Pilih    : ");
            menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1:
                    sistem.inputNilai(sc);
                    break;
                case 2:
                    sistem.tampilNilai();
                    break;
                case 3:
                    sistem.cariNilaiMahasiswa(sc);
                    break;
                case 4:
                    sistem.urutDataNilai();
                    break;
                case 5:
                    sistem.hapusNilaiAntrean();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia!");
            }
        } while (menu != 6);

        sc.close();
    }
}
