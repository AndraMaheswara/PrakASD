
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

**2. Pada method Enqueue, jelaskan maksud dan kegunaan dari potongan kode berikut!**
```java
if (rear == max - 1) {
    rear = 0;
}
```
Potongan kode tersebut merupakan mekanisme untuk mengimplementasikan Circular Queue (Antrean Melingkar).
Maksud: Mengecek apakah penunjuk elemen belakang (rear) sudah berada di ujung akhir kapasitas array (max - 1). Jika kondisi tersebut terpenuhi, maka nilai rear akan diputar kembali (diatur ulang) menjadi 0.
Kegunaan: Memanfaatkan kembali ruang atau slot kosong di bagian awal array (indeks 0 dan seterusnya) yang tercipta setelah proses elemen terdepan dikeluarkan melalui operasi Dequeue. Hal ini mencegah pemborosan memori array.

**3. Pada method Dequeue, jelaskan maksud dan kegunaan dari potongan kode berikut!**
```
if (front == max - 1) {
    front = 0;
}
```
Sama halnya dengan nomor 2, potongan kode ini merupakan bagian dari implementasi Circular Queue.

Maksud: Mengecek apakah penunjuk elemen terdepan (front) sudah mencapai batas akhir indeks array (max - 1) setelah sebuah elemen berhasil dikeluarkan. Jika benar, posisi front dipindahkan kembali ke indeks 0.

Kegunaan: Menggeser posisi pointer pengambilan data selanjutnya kembali ke awal array secara melingkar, sehingga proses dequeue dapat terus berjalan secara dinamis mengikuti perputaran elemen data yang masuk dan keluar.

**4. Pada method print, mengapa pada proses perulangan variabel i tidak dimulai dari 0 (int i=0), melainkan int i=front?**

Sifat dasar dari struktur data queue adalah First-In, First-Out (FIFO), di mana elemen yang pertama kali keluar selalu berada di posisi front.

Di dalam struktur circular queue, posisi elemen terdepan tidak selalu menetap di indeks 0 karena pointer front akan terus maju seiring dilakukannya operasi Dequeue. Oleh karena itu, pencetakan data harus dimulai secara tepat dari indeks yang ditunjuk oleh variabel front sebagai elemen pertama antrean, bukan langsung berasumsi dari indeks 0.

**Perhatikan kembali method print, jelaskan maksud dari potongan kode berikut!**
```i = (i + 1) % max;```
Maksud: Kode tersebut berfungsi untuk menaikkan nilai variabel counter i sebesar 1 langkah ke depan, kemudian melakukan operasi modulo (%) dengan kapasitas maksimal array (max).

Kegunaan: Menjamin perulangan berjalan secara melingkar (circular stepping). Jika nilai i + 1 telah mencapai nilai kapasitas max, hasil operasi modulo akan mengembalikan nilai variabel i secara otomatis ke indeks 0, sehingga perulangan mencetak data tidak melompat keluar dari batas indeks array (out of bounds).

**6. Tunjukkan potongan kode program yang merupakan queue overflow!**
```
if (IsFull()) {
    System.out.println("Queue sudah penuh");
}
```
**7. Pada saat terjadi queue overflow dan queue underflow, program tersebut tetap dapat berjalan dan hanya menampilkan teks informasi. Lakukan modifikasi program sehingga pada saat terjadi queue overflow dan queue underflow, program dihentikan!**
```public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    // Modifikasi Enqueue untuk menghentikan program saat Queue Overflow
    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh! Program dihentikan (Queue Overflow).");
            System.exit(0); // Menghentikan jalannya seluruh program
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    // Modifikasi Dequeue untuk menghentikan program saat Queue Underflow
    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong! Program dihentikan (Queue Underflow).");
            System.exit(0); // Menghentikan jalannya seluruh program
            return -1;
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}
```
