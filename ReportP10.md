
|  | Algorithm and Data Structure |
|--|--|
| NIM |  254107020090|
| Nama |  Rajendra Putra Maheswara |
| Kelas | TI - 1F |
| Repository | (https://github.com/AndraMaheswara/PrakASD) |

### 2.1.3 Pertanyaan

**1. Pada konstruktor, mengapa nilai awal atribut front dan rear bernilai -1, sementara atribut size bernilai 0?**
Nilai awal `front` dan `rear` diinisialisasi dengan `-1` untuk menandakan bahwa struktur data queue saat pertama kali dibuat berada dalam kondisi **kosong** dan belum menunjuk ke indeks array mana pun (karena indeks array di Java dimulai dari `0`).
Sementara itu, atribut `size` bernilai `0` karena atribut ini berfungsi sebagai pencatat **jumlah total elemen** yang tersimpan di dalam queue secara riil. Saat objek queue baru dibuat, tentu belum ada elemen data satu pun yang dimasukkan ke dalamnya.

---

**2. Pada method Enqueue, jelaskan maksud dan kegunaan dari potongan kode berikut!**
```java
if (rear == max - 1) {
    rear = 0;
}
```
Potongan kode tersebut merupakan mekanisme untuk mengimplementasikan Circular Queue (Antrean Melingkar).
Maksud: Mengecek apakah penunjuk elemen belakang (rear) sudah berada di ujung akhir kapasitas array (max - 1). Jika kondisi tersebut terpenuhi, maka nilai rear akan diputar kembali (diatur ulang) menjadi 0.
Kegunaan: Memanfaatkan kembali ruang atau slot kosong di bagian awal array (indeks 0 dan seterusnya) yang tercipta setelah proses elemen terdepan dikeluarkan melalui operasi Dequeue. Hal ini mencegah pemborosan memori array.

---
