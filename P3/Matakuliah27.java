package P3;

import java.util.Scanner;

public class Matakuliah27 {
    public String kode;
    public String nama;
    public int sks;
    public int jumlahJam;

public Matakuliah27() { }

    //no2
    public void tambahData(Scanner sc) {
        System.out.print("Kode       : ");
        this.kode = sc.nextLine();
        System.out.print("Nama       : ");
        this.nama = sc.nextLine();
        System.out.print("SKS        : ");
        this.sks = sc.nextInt();
        System.out.print("Jumlah Jam : ");
        this.jumlahJam = sc.nextInt();
        System.out.println();
    }


    public Matakuliah27(String kode, String nama, int sks, int jumlahJam) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;
    }
    //no 3
    public void cetakInfo() {
        System.out.println("Kode: " + kode + " | Nama: " + nama + " | SKS: " + sks + " | Jam: " + jumlahJam);
    }
}