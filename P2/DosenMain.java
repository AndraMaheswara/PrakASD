package P2;

public class DosenMain {
    public static void main(String[] args) {
  
        Dosen d1 = new Dosen();
        d1.idDosen = "D001";
        d1.nama = "Dr. Andi Wijaya";
        d1.statusAktif = true;
        d1.tahunBergabung = 2015;
        d1.bidangKeahlian = "Basis Data";

        System.out.println("=== Profil Dosen 1 ===");
        d1.tampilInformasi();
        d1.setStatusAktif(false);
        d1.ubahKeahlian("Big Data");
        System.out.println("Masa Kerja: " + d1.hitungMasaKerja(2025) + " tahun");

       
        Dosen d2 = new Dosen("D002", "Siti Aminah, M.T.", true, 2020, "Cyber Security");

        System.out.println("\n=== Profil Dosen 2 ===");
        d2.tampilInformasi();
        System.out.println("Masa Kerja: " + d2.hitungMasaKerja(2025) + " tahun");
        d2.setStatusAktif(true);
    }
}