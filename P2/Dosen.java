package P2;
public class Dosen {
    String idDosen;
    String nama;
    boolean statusAktif;
    int tahunBergabung;
    String bidangKeahlian;

   
    public Dosen() {
    }


    public Dosen(String id, String nama, boolean status, int thn, String keahlian) {
        this.idDosen = id;
        this.nama = nama;
        this.statusAktif = status;
        this.tahunBergabung = thn;
        this.bidangKeahlian = keahlian;
    }

    void tampilInformasi() {
        System.out.println("ID Dosen        : " + idDosen);
        System.out.println("Nama            : " + nama);
        System.out.println("Status Aktif    : " + (statusAktif ? "Aktif" : "Tidak Aktif"));
        System.out.println("Tahun Bergabung : " + tahunBergabung);
        System.out.println("Bidang Keahlian : " + bidangKeahlian);
        System.out.println("-----------------------------");
    }

    void setStatusAktif(boolean status) {
        this.statusAktif = status;
        String s = status ? "Aktif" : "Tidak Aktif";
        System.out.println("Status dosen " + nama + " sekarang: " + s);
    }

    int hitungMasaKerja(int thnSkrg) {
        return thnSkrg - tahunBergabung;
    }

    void ubahKeahlian(String bidang) {
        this.bidangKeahlian = bidang;
        System.out.println("Bidang keahlian " + nama + " diubah menjadi: " + bidangKeahlian);
    }
}