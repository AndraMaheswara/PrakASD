package Quiz1;

//class
class Mahasiswa {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public void tampilMahasiswa() {
        System.out.printf("%-10s | %-10s | %-10s\n",
        "NIM: " + nim,
         "Nama: " + nama, 
         "Prodi: " + prodi);
    }
}

class Buku {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    public Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilBuku() {
        System.out.printf("%-10s | %-19s | %-15s\n",
        "Kode: " + kodeBuku, 
        "Judul: " + judul, 
        "Tahun: " + tahunTerbit);
    }
}

class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    public Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    public void hitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    public void tampilPeminjaman() {
        System.out.printf("%-12s | %-15s | %-9s %-6s | %-15s | %-15s\n",
            "Nama: " + mhs.nama, buku.judul, 
            "Lama: " + lamaPinjam, " Hari", 
            "Terlambat: " + terlambat, 
            "Denda: " + denda);
}
}

//sistem
public class SistemPeminjaman {
    Mahasiswa[] daftarMhs;
    Buku[] daftarBuku;
    Peminjaman[] daftarPinjam;

    //inisialisasi data
    public void inisialisasiData() {
        daftarMhs = new Mahasiswa[] {
                new Mahasiswa("22001", "Andi", "Teknik Informatika"),
                new Mahasiswa("22002", "Budi", "Teknik Informatika"),
                new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        daftarBuku = new Buku[] {
                new Buku("B001", "Algoritma", 2020),
                new Buku("B002", "Basis Data", 2019),
                new Buku("B003", "Pemrograman", 2021),
                new Buku("B004", "Fisika", 2024)
        };

        daftarPinjam = new Peminjaman[] {
                new Peminjaman(daftarMhs[0], daftarBuku[0], 7),
                new Peminjaman(daftarMhs[1], daftarBuku[1], 3),
                new Peminjaman(daftarMhs[2], daftarBuku[2], 10),
                new Peminjaman(daftarMhs[2], daftarBuku[3], 6),
                new Peminjaman(daftarMhs[0], daftarBuku[1], 4)
        };
    }

    public void tampilSemuaMahasiswa() {
        for (Mahasiswa m : daftarMhs) {
            m.tampilMahasiswa();
        }
    }

    public void tampilSemuaBuku() {
        for (Buku b : daftarBuku) {
            b.tampilBuku();
        }
    }

    public void tampilSemuaPeminjaman() {
        for (Peminjaman p : daftarPinjam) {
            p.tampilPeminjaman();
        }
    }

    //insertion sort denda
    public void urutkanBerdasarkanDenda() {
        for (int i = 1; i < daftarPinjam.length; i++) {
            Peminjaman key = daftarPinjam[i];
            int j = i - 1;

            while (j >= 0 && daftarPinjam[j].denda < key.denda) {
                daftarPinjam[j + 1] = daftarPinjam[j];
                j = j - 1;
            }
            daftarPinjam[j + 1] = key;
        }
    }

    //binary search berdasarkan nim
    public void cariBerdasarkanNIM(String nimCari) {
        // Urutkan berdasarkan NIM (Ascending) terlebih dahulu
        for (int i = 1; i < daftarPinjam.length; i++) {
            Peminjaman key = daftarPinjam[i];
            int j = i - 1;
            while (j >= 0 && daftarPinjam[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                daftarPinjam[j + 1] = daftarPinjam[j];
                j = j - 1;
            }
            daftarPinjam[j + 1] = key;
        }

        //proses binary
        int left = 0;
        int right = daftarPinjam.length - 1;
        int foundIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = daftarPinjam[mid].mhs.nim.compareTo(nimCari);

            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //cek nim
        if (foundIndex != -1) {
            int start = foundIndex;
            while (start > 0 && daftarPinjam[start - 1].mhs.nim.equals(nimCari)) {
                start--;
            }
            int end = foundIndex;
            while (end < daftarPinjam.length - 1 && daftarPinjam[end + 1].mhs.nim.equals(nimCari)) {
                end++;
            }

            for (int i = start; i <= end; i++) {
                daftarPinjam[i].tampilPeminjaman();
            }
        } else {
            System.out.println("Data peminjaman dengan NIM " + nimCari + " tidak ditemukan.");
        }
    }
}