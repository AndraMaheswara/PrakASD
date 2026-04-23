package P6;

public class MahasiswaDemo {
    public static void main(String[] args) {
        MahasiswaBerprestasi data = new MahasiswaBerprestasi();
        
        data.tambah(new Mahasiswa("123", "Zidan", "2A", 3.2));
        data.tambah(new Mahasiswa("124", "Ayu", "2A", 3.5));
        data.tambah(new Mahasiswa("125", "Sofi", "2A", 3.1));
        data.tambah(new Mahasiswa("126", "Sita", "2A", 3.9));
        data.tambah(new Mahasiswa("127", "Miki", "2A", 3.7));

        System.out.println("Data mahasiswa sebelum sorting:");
        data.tampil();

        System.out.println("Data Mahasiswa setelah sorting berdasarkan IPK (DESC):");
        data.bubbleSort();
        data.tampil();
    }
}
