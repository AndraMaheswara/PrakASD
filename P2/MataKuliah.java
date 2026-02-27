package P2;

public class MataKuliah {
    String kodeMK;
    String nama;
    int sks;
    int jumlahJam;

   
    public MataKuliah() {
    }

  
    public MataKuliah(String kodeMK, String nama, int sks, int jumlahJam) {
        this.kodeMK = kodeMK;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;
    }

    void tampilInformasi() {
        System.out.println("Kode MK    : " + kodeMK);
        System.out.println("Nama MK    : " + nama);
        System.out.println("SKS        : " + sks);
        System.out.println("Jumlah Jam : " + jumlahJam);
        System.out.println("-----------------------------");
    }

    void ubahSKS(int sksBaru) {
        this.sks = sksBaru;
        System.out.println("SKS telah diubah menjadi: " + sks);
    }

    void tambahJam(int jam) {
        this.jumlahJam += jam;
        System.out.println("Jam berhasil ditambah. Total jam sekarang: " + jumlahJam);
    }

    void kurangiJam(int jam) {
        if (this.jumlahJam >= jam) {
            this.jumlahJam -= jam;
            System.out.println("Pengurangan berhasil. Sisa jam: " + jumlahJam);
        } else {
            System.out.println("Gagal! Pengurangan tidak dapat dilakukan karena jumlah jam tidak mencukupi.");
        }
    }
}