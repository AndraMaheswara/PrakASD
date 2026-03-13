package P3;

import java.util.Scanner;

public class MatakuliahDemo27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matakuliah27[] arrayOfMatakuliah = new Matakuliah27[3];
        String kode, nama;
        int sks, jumlahJam;
 
        for (int i = 0; i < 3; i++) {
            System.out.println("Masukkan Data Matakuliah ke-" + (i + 1));
            System.out.print("Kode       : ");
            kode = sc.nextLine();
            System.out.print("Nama       : ");
            nama = sc.nextLine();
            System.out.print("Sks        : ");
            sks = sc.nextInt();  
            System.out.print("Jumlah Jam : ");
            jumlahJam = sc.nextInt();
            
            sc.nextLine();  
            System.out.println("--------------------------------------");

        
            arrayOfMatakuliah[i] = new Matakuliah27(kode, nama, sks, jumlahJam);
        }

       
        System.out.println("--- HASIL INPUT DATA MATAKULIAH ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("Data Matakuliah ke-" + (i + 1));
            System.out.println("Kode       : " + arrayOfMatakuliah[i].kode);
            System.out.println("Nama       : " + arrayOfMatakuliah[i].nama);
            System.out.println("Sks        : " + arrayOfMatakuliah[i].sks);
            System.out.println("Jumlah Jam : " + arrayOfMatakuliah[i].jumlahJam);
            System.out.println("--------------------------------------");
        }
    }
}