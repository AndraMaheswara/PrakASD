package P15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMahasiswa {
    // Atribut penampung koleksi berbasis objek Mahasiswa
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    // Method menambahkan beberapa objek mahasiswa sekaligus menggunakan Varargs (...)
    public void tambah(Mahasiswa... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    // Method menghapus mahasiswa berdasarkan indeks posisi list
    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    // Method memperbarui/mengubah data mahasiswa pada indeks tertentu
    public void update(int index, Mahasiswa mhs) {
        mahasiswas.set(index, mhs);
    }

    // Method menampilkan seluruh data mahasiswa menggunakan Stream API dan Lambda Expression
    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    // Method pencarian sekuensial berdasarkan NIM untuk menghasilkan posisi indeks objek
    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1; // Mengembalikan -1 jika NIM mahasiswa tidak ditemukan
    }

  
    // LANGKAH 5: Main Method Uji Coba Program
    public static void main(String[] args) {
        ListMahasiswa lm = new ListMahasiswa();
        
        // Instansiasi objek mahasiswa baru
        Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
        Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
        Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");
        
        // Menambahkan objek mahasiswa ke dalam list
        lm.tambah(m, m1, m2);
        
        // Menampilkan data list awal
        lm.tampil();
        
        // Melakukan update data: mencari indeks NIM "201235" lalu mengganti datanya
        lm.update(lm.linearSearch("201235"), new Mahasiswa("201235", "Akhleema Lela", "021xx2"));
        
        System.out.println(""); // Baris kosong pembatas sesuai gambar verifikasi
        
        // Menampilkan data list setelah diperbarui
        lm.tampil();
    }
}
