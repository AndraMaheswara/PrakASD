package P15;

public class Mahasiswa {
    String nim;
    String nama;
    String notelp;

    // Konstruktor Default
    public Mahasiswa() {
    }

    // Konstruktor Parametrik
    public Mahasiswa(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    // Override toString untuk format pencetakan objek sesuai verifikasi hasil
    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
    }
}
