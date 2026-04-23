package P6;

import java.util.Scanner;

public class MahasiswaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi data = new MahasiswaBerprestasi();
        
        
        int jumlahMhs = 5; 

        System.out.println("--- Input Data Mahasiswa ---");
        for (int i = 0; i < jumlahMhs; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine(); 

            Mahasiswa m = new Mahasiswa(nim, nama, kelas, ipk);
            data.tambah(m);
            System.out.println();
        }

        System.out.println("Data sebelum sorting:");
        data.tampil();

        System.out.println("\nData setelah sorting (Bubble Sort DESC):");
        data.bubbleSort();
        data.tampil();
        
        sc.close();
    }
}