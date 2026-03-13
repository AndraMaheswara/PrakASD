package P3;

import java.util.Scanner;

public class MatakuliahDemo27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //no 4
        System.out.print("Masukkan jumlah matakuliah: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); 

        Matakuliah27[] arrayOfMatakuliah = new Matakuliah27[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.println("Masukkan Data ke-" + (i + 1));
            arrayOfMatakuliah[i] = new Matakuliah27();
            arrayOfMatakuliah[i].tambahData(sc); //  
            System.out.println("---------------------------");
        }

        System.out.println("\n=== DATA MATAKULIAH ===");
        for (Matakuliah27 mk : arrayOfMatakuliah) {
            mk.cetakInfo();  
        }
    }
}