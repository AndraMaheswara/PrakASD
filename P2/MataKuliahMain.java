package P2;

public class MataKuliahMain {
    public static void main(String[] args) {
        
        MataKuliah mk1 = new MataKuliah();
        mk1.kodeMK = "ALSD24";
        mk1.nama = "Algoritma dan Struktur Data";
        mk1.sks = 2;
        mk1.jumlahJam = 4;

        System.out.println("=== Informasi Mata Kuliah 1 ===");
        mk1.tampilInformasi();
        mk1.ubahSKS(3);
        mk1.tambahJam(2);
        mk1.kurangiJam(3);
        mk1.tampilInformasi();

        
        MataKuliah mk2 = new MataKuliah("BING24", "Bahasa Inggris", 2, 2);
        
        System.out.println("\n=== Informasi Mata Kuliah 2 ===");
        mk2.tampilInformasi();
        mk2.kurangiJam(5); 
        mk2.tambahJam(1);
        mk2.tampilInformasi();
    }
}