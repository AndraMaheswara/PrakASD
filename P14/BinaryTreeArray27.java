package P14;

public class BinaryTreeArray27 {
    Mahasiswa27[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray27() {
        this.dataMahasiswa = new Mahasiswa27[10];
        this.idxLast = -1; // -1 menandakan array awalnya kosong
    }

    void populateData(Mahasiswa27 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1); // Ke anak kiri
                dataMahasiswa[idxStart].tampilInformasi(); // Cetak root/parent
                traverseInOrder(2 * idxStart + 2); // Ke anak kanan
            }
        }
    }

    // =========================================================================
    // TUGAS 4: Modifikasi Tambahan Method add() dan traversePreOrder()
    // =========================================================================
    
    // Method untuk memasukkan data ke indeks array berikutnya yang kosong
    public void add(Mahasiswa27 data) {
        if (idxLast < dataMahasiswa.length - 1) {
            idxLast++;
            dataMahasiswa[idxLast] = data;
        } else {
            System.out.println("Gagal tambah data, kapasitas Tree Array sudah penuh!");
        }
    }

    // Method untuk melakukan penelusuran Pre-Order (Root - Kiri - Kanan)
    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                dataMahasiswa[idxStart].tampilInformasi(); // Cetak Parent terlebih dahulu
                traversePreOrder(2 * idxStart + 1);       // Masuk ke anak kiri
                traversePreOrder(2 * idxStart + 2);       // Masuk ke anak kanan
            }
        }
    }
}