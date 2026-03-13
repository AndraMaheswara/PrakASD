import java.util.Scanner;

public class LaporanKeuanganMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Jumlah data: ");
        int n = sc.nextInt();

        // Array
        LaporanKeuangan[] daftarLaporan = new LaporanKeuangan[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Data ke- :" + (i + 1));
            System.out.print("Nama Perusahaan: ");
            String nama = sc.next();
            System.out.print("Pendapatan Bulanan: ");
            Double pendapatan = sc.nextDouble();
            System.out.print("Biaya Operasional: ");
            double biaya = sc.nextDouble();

            daftarLaporan[i] = new LaporanKeuangan(nama, n, biaya);
        }

        // variable untuk next step
        double totalKeuntunganSemua = 0;
        double totalKeuntunganKriteria = 0;
        int countKriteria = 0;

        
        for (LaporanKeuangan lpk : daftarLaporan) {
            double untung = lpk.hitungKeuntungan();
            totalKeuntunganSemua += untung;

            // pendapatan bulanan > 100000
            if (lpk.pendapatanBulanan > 100000) {
                totalKeuntunganKriteria += untung;
                countKriteria++;
            }
        }

        // print hasil analisis
        System.out.println("====Hasil Aalisis====");
        if (countKriteria > 0) {
            System.out.println("Rata rata keuntungan: " + (totalKeuntunganKriteria / countKriteria));
            System.out
                    .println("Prosentase keuntungan: " + (totalKeuntunganKriteria / totalKeuntunganSemua * 100) + "%");
        } else {
            System.out.println("Tidak ada perusahaan dengan pendapatan >100.000");
        }

    }

}
