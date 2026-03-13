package P3;

import java.util.Scanner;

public class DosenDemo27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan Jumlah Dosen: ");
        int jml = sc.nextInt();
        sc.nextLine(); 

        Dosen27[] arrayOfDosen = new Dosen27[jml];

         
        for (int i = 0; i < jml; i++) {
            System.out.println("Masukkan Data Dosen ke-" + (i + 1));
            System.out.print("Kode          : ");
            String kode = sc.nextLine();
            System.out.print("Nama          : ");
            String nama = sc.nextLine();
            System.out.print("Jenis Kelamin (Pria=true / Wanita=false): ");
            Boolean jk = sc.nextBoolean();
            System.out.print("Usia          : ");
            int usia = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------------");

            arrayOfDosen[i] = new Dosen27(kode, nama, jk, usia);
        }

        
        System.out.println("\n=== DATA SELURUH DOSEN ===");
        for (Dosen27 dsn : arrayOfDosen) {
            String gender = dsn.jenisKelamin ? "Pria" : "Wanita";
            System.out.println("Kode          : " + dsn.kode);
            System.out.println("Nama          : " + dsn.nama);
            System.out.println("Jenis Kelamin : " + gender);
            System.out.println("Usia          : " + dsn.usia);
            System.out.println("-------------------------------------------");
        }
    }
}
