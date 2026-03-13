package Idk;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah data (n): ");
        int n = sc.nextInt();

        // Array
        A[] daftarLaporan = new A[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.print("Nama Perusahaan: ");
            String nama = sc.next();
            System.out.print("Pendapatan Bulanan: ");
            double pendapatan = sc.nextDouble();
            System.out.print("Biaya Operasional: ");
            double biaya = sc.nextDouble();

            daftarLaporan[i] = new A(nama, pendapatan, biaya);
        }

        double totalKeuntunganSemua = 0;
        double totalKeuntunganKriteria = 0;
        int countKriteria = 0;

        for (A lpk : daftarLaporan) {
            double untung = lpk.hitungKeuntungan();
            totalKeuntunganSemua += untung;

            // pendapatan bulanan > 100000
            if (lpk.pendapatanBulanan > 100000) {
                totalKeuntunganKriteria += untung;
                countKriteria++;
            }
        }

        System.out.println("\n--- HASIL ANALISIS ---");
        if (countKriteria > 0) {
            System.out.println("Rata-rata keuntungan (Pendapatan > 100k): " + (totalKeuntunganKriteria / countKriteria));
            System.out.println("Persentase keuntungan kriteria dari total: " + (totalKeuntunganKriteria / totalKeuntunganSemua * 100) + "%");
        } else {
            System.out.println("Tidak ada perusahaan dengan pendapatan > 100.000");
        }
    }
}
