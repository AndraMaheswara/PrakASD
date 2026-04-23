package P6;

public class MahasiswaBerprestasi {
    Mahasiswa[] listMhs = new Mahasiswa[5];
    int idx;

    void tambah(Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh");
        }
    }

    void tampil() {
        for (Mahasiswa m : listMhs) {
            if (m != null) {
                m.tampilInformasi();
                System.out.println("-----------------------------");
            }
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                
                if (listMhs[j] != null && listMhs[j - 1] != null) {
                    if (listMhs[j - 1].ipk < listMhs[j].ipk) {
                        
                        Mahasiswa temp = listMhs[j];
                        listMhs[j] = listMhs[j - 1];
                        listMhs[j - 1] = temp;
                    }
                }
            }
        }
    }
    void selectionSort() {
    for (int i = 0; i < listMhs.length - 1; i++) {
        int idxMin = i;
        for (int j = i + 1; j < listMhs.length; j++) {
            if (listMhs[j].ipk < listMhs[idxMin].ipk) {
                idxMin = j;
            }
        }
        Mahasiswa tmp = listMhs[idxMin];
        listMhs[idxMin] = listMhs[i];
        listMhs[i] = tmp;
        }
    }
}