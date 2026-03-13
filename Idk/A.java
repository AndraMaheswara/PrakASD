package Idk;

class A {
    String namaPerusahaan;
    double pendapatanBulanan;
    double biayaOperasional;

    // Constructor
    public A(String nama, double pendapatan, double biaya) {
        this.namaPerusahaan = nama;
        this.pendapatanBulanan = pendapatan;
        this.biayaOperasional = biaya;
    }

    public double hitungKeuntungan() {
        return pendapatanBulanan - biayaOperasional;
    }

    public void printData() {
        System.out.println("Nama: " + namaPerusahaan + 
                           " | Keuntungan: " + hitungKeuntungan());
    }
}
