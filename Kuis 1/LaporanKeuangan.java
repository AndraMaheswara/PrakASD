

public class LaporanKeuangan {
    public String namaPerusahaan;
    public Double pendapatanBulanan;
    public double biayaOperasional;

    public LaporanKeuangan(String nama, double pendapatan, double biaya) {
        this.namaPerusahaan = nama;
        this.pendapatanBulanan = pendapatan;
        this.pendapatanBulanan = biaya;

    }

    public double hitungKeuntungan() {
        return pendapatanBulanan - biayaOperasional;
    }

    public void printData() {
        System.out.println("Nama: " + namaPerusahaan +
                " | Keuntungan: " + hitungKeuntungan());
    }
}
