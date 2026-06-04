
|  | Algorithm and Data Structure |
|--|--|
| NIM |  254107020090|
| Nama |  Rajendra Putra Maheswara |
| Kelas | TI - 1F |
| Repository | (https://github.com/AndraMaheswara/PrakASD) |

## 2.1 Percobaan 1: Mahasiswa Mengumpulkan Tugas
(image)

### 2.1.3 Pertanyaan
**1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi
hasil percobaan! Bagian mana yang perlu diperbaiki?**

Bagian yang perlu diperbaiki adalah urutan penempatan potongan pertanyaan soal di dalam case 1 pada class MahasiswaDemo. Pertanyaan soal nomor 1, 3, 4, 5, dan 6 tersisip di tengah-tengah baris kode instansiasi objek Mahasiswa dan pemanggilan stack.push(mhs);, sehingga menyebabkan syntax error saat di-compile.

Selain itu, jika dilihat dari case 2, terdapat pemanggilan method stack.konversiDesimalKeBiner(nilai); yang mana method konversi biner tersebut umumnya harus diimplementasikan secara terpisah menggunakan struktur data stack di dalam class StackTugasMahasiswa.

**3. Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan
kode programnya!**

```StackTugasMahasiswa stack = new StackTugasMahasiswa(5);```

Banyak data tugas mahasiswa yang dapat ditampung di dalam Stack adalah 5 data. Hal ini ditentukan saat instansiasi objek stack pada class MahasiswaDemo dengan melewatkan argumen integer 5 ke dalam constructor.

**4. Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut
dihapus, apa dampaknya?****
Pengecekan kondisi !isFull() pada method push diperlukan untuk memastikan bahwa stack masih memiliki ruang kosong sebelum data baru dimasukkan. Hal ini mencegah terjadinya fenomena Stack Overflow (kondisi di mana program mencoba memasukkan data ke dalam struktur data yang kapasitasnya sudah penuh).

Dampaknya jika if-else tersebut dihapus:
Jika kondisi tersebut dihapus, program akan tetap mencoba menambahkan data baru dan menaikkan nilai indeks variabel pointer top. Akibatnya, saat program mencoba mengakses indeks array yang melebihi batas kapasitas yang telah ditentukan (misal indeks ke-5 pada array berukuran 5), Java akan melemparkan error ArrayIndexOutOfBoundsException dan program akan berhenti mendadak (crash).

**5. Modifikasi kode program pada class MahasiswaDemo dan StackTugasMahasiswa sehingga
pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi
lihat tugas terbawah!**

**6. Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat
ini, serta tambahkan operasi menunya!**

```
package P9;

public class Mahasiswa {
    String nama;
    String nim;
    String kelas;
    int nilai;

    public Mahasiswa(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.nilai = -1;
    }

    public void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
```

```
package P9;

public class StackTugasMahasiswa {
    int size;
    int top;
    Mahasiswa[] data;

    public StackTugasMahasiswa(int size) {
        this.size = size;
        this.data = new Mahasiswa[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Mahasiswa mhs) {
        if (!isFull()) {
            top++;
            data[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak dapat mengumpulkan tugas lagi.");
        }
    }

    public Mahasiswa pop() {
        if (!isEmpty()) {
            Mahasiswa mhs = data[top];
            top--;
            return mhs;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas yang bisa dinilai.");
            return null;
        }
    }

    public Mahasiswa peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    // Modifikasi Soal 5: Method melihat tugas terbawah (paling pertama dikumpulkan)
    public Mahasiswa peekBottom() {
        if (!isEmpty()) {
            return data[0]; // Tugas pertama selalu berada di indeks 0
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    // Modifikasi Soal 6: Method menghitung jumlah tugas saat ini
    public int getJumlahTugas() {
        return top + 1;
    }

    public void print() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(data[i].nama + "\t" + data[i].nim + "\t" + data[i].kelas);
            }
        } else {
            System.out.println("Tidak ada daftar tugas.");
        }
    }

    // Pendukung Fitur Desimal ke Biner di Menu 2
    public String konversiDesimalKeBiner(int desimal) {
        if (desimal == 0) return "0";
        
        // Menggunakan stack internal sederhana untuk menampung sisa bagi
        int[] tempStack = new int[32];
        int tempTop = -1;
        
        while (desimal > 0) {
            tempTop++;
            tempStack[tempTop] = desimal % 2;
            desimal = desimal / 2;
        }
        
        StringBuilder biner = new StringBuilder();
        while (tempTop >= 0) {
            biner.append(tempStack[tempTop]);
            tempTop--;
        }
        return biner.toString();
    }
}
```

## 2.2.1 Langkah-langkah Percobaan
(image2)

### 2.2.3 Pertanyaan
**1. Jelaskan alur kerja dari method konversiDesimalKeBiner!**
Method konversiDesimalKeBiner berfungsi mengubah bilangan desimal (berbasis 10) menjadi bilangan biner (berbasis 2) dengan memanfaatkan struktur data Stack dari class StackKonversi. Alur kerjanya adalah sebagai berikut:

Inisialisasi: Program membuat objek stack baru bernama stackKonv dari class StackKonversi untuk menampung sisa hasil bagi.

Perulangan Pertama (Proses Pembagian dan Push): * Melakukan perulangan while (nilai > 0). Di dalam perulangan, nilai desimal dibagi dengan 2 untuk mendapatkan sisa baginya (nilai % 2), yang hasilnya pasti 0 atau 1.

Sisa bagi tersebut dimasukkan (push) ke dalam stackKonv.

Nilai desimal kemudian diperbarui dengan hasil pembagian bilangan bulat bagi dua (nilai / 2).

Proses ini terus berulang hingga nilai berharga 0.

Perulangan Kedua (Proses Pop dan Penggabungan String):

Melakukan perulangan while (!stackKonv.isEmpty()) untuk mengambil kembali data dari stack. Karena sifat stack adalah LIFO (Last In First Out), data sisa bagi yang dimasukkan paling terakhir akan keluar pertama kali. Hal ini secara otomatis membalik urutan angka biner sehingga posisinya menjadi benar dari MSB (Most Significant Bit) ke LSB (Least Significant Bit).

Setiap elemen yang di-pop digabungkan ke dalam variabel string biner.

Pengembalian Nilai: Method mengembalikan string biner yang merupakan hasil konversi akhir.

**2. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0),
bagaimana hasilnya? Jelaskan alasannya!**
Hasil program tetap sama dan berjalan dengan normal (tidak ada perubahan output) untuk input nilai bilangan bulat positif (0-100) seperti yang dimasukkan pada menu penilaian tugas. Namun, program akan mengalami infinite loop (perulangan tanpa henti) jika diberi input nilai bilangan negatif.

Alasan:

Untuk Bilangan Positif: Kondisi nilai > 0 dan nilai != 0 memiliki titik henti yang sama. Melalui operasi pembagian integer (nilai / 2), nilai positif yang terus mengecil lambat laun akan bernilai 0. Ketika nilai mencapai 0, kedua kondisi tersebut sama-sama bernilai false, sehingga perulangan berhenti.

Untuk Bilangan Negatif (Mengapa Berbahaya): Jika kondisi diubah menjadi nilai != 0 dan input bernilai negatif (misal -5), operasi nilai / 2 akan menghasilkan -2, lalu -1, dan pada pembagian berikutnya dalam Java (-1 / 2) hasilnya adalah 0. Perulangan akan berhenti dengan aman. Namun, jika tipe data atau penanganan pembagian menghasilkan nilai yang tidak bisa mencapai 0 (atau jika diaplikasikan pada operasi pengurangan/kasus lain), kondisi != 0 rentan melewati angka nol. Pembagian bilangan negatif dalam tipe data tertentu bisa menghasilkan perulangan tak berujung karena nilainya terus berada di bawah nol (negatif) dan tidak pernah tepat bernilai 0. Oleh karena itu, kondisi nilai > 0 jauh lebih aman digunakan untuk memastikan perulangan hanya memproses bilangan positif secara valid.

