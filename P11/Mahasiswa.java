package P11;
public class Mahasiswa {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa() {
    }

    public Mahasiswa(String nm, String name, String kls, double ip) {
        this.nim = nm;
        this.nama = name;
        this.kelas = kls;
        this.ipk = ip;
    }

    public void tampilInformasi() {
        System.out.println(nama + "\t\t" + nim + "\t\t" + kelas + "\t\t" + ipk);
    }
}
    
