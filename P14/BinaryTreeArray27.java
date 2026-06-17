package P14;

public class BinaryTreeArray27 {
    Mahasiswa27[] dataMahasiswa;
    int idxLast;

    // Constructor default sesuai petunjuk jobsheet
    public BinaryTreeArray27() {
        this.dataMahasiswa = new Mahasiswa27[10];
        this.idxLast = -1; // -1 menandakan array awalnya benar-benar kosong
    }

    // Method dari Percobaan 2 untuk mengisi data secara massal
    void populateData(Mahasiswa27 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    // Method dari Percobaan 2: Penelusuran In-Order (Kiri - Root - Kanan)
    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1); // Ke anak kiri
                dataMahasiswa[idxStart].tampilInformasi(); // Cetak data parent
                traverseInOrder(2 * idxStart + 2); // Ke anak kanan
            }
        }
    }


    // Method add() untuk memasukkan data mahasiswa ke indeks kosong berikutnya
    public void add(Mahasiswa27 data) {
        if (idxLast < dataMahasiswa.length - 1) {
            idxLast++;
            dataMahasiswa[idxLast] = data;
        } else {
            System.out.println("Gagal tambah data, kapasitas Tree Array sudah penuh!");
        }
    }

    // Method traversePreOrder() untuk penelusuran (Root - Kiri - Kanan)
    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                dataMahasiswa[idxStart].tampilInformasi(); // Cetak Root/Parent terlebih dahulu
                traversePreOrder(2 * idxStart + 1);       // Pindah ke anak kiri
                traversePreOrder(2 * idxStart + 2);       // Pindah ke anak kanan
            }
        }
    }
}
