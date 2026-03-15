package P5;

import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    int tahunMasuk;
    int nilaiUTS;
    int nilaiUAS;

    Mahasiswa(String nama, String nim, int tahunMasuk, int nilaiUTS, int nilaiUAS) {
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }
}

public class TugasP5 {

    // nilai tertinggi dnq
    static int cariMaxUTS(Mahasiswa[] mhs, int l, int r) {
        if (l == r) {
            return mhs[l].nilaiUTS;
        }
        int mid = (l + r) / 2;
        int maxL = cariMaxUTS(mhs, l, mid);
        int maxR = cariMaxUTS(mhs, mid + 1, r);
        return (maxL > maxR) ? maxL : maxR;
    }

    // nilai terendah dnq
    static int cariMinUTS(Mahasiswa[] mhs, int l, int r) {
        if (l == r) {
            return mhs[l].nilaiUTS;
        }
        int mid = (l + r) / 2;
        int minL = cariMinUTS(mhs, l, mid);
        int minR = cariMinUTS(mhs, mid + 1, r);
        return (minL < minR) ? minL : minR;
    }

    // ratarata BF
    static double hitungRataUAS(Mahasiswa[] mhs) {
        double total = 0;
        for (int i = 0; i < mhs.length; i++) {
            total += mhs[i].nilaiUAS;
        }
        return total / mhs.length;
    }

    public static void main(String[] args) {

        Mahasiswa[] daftarMhs = new Mahasiswa[8];
        daftarMhs[0] = new Mahasiswa("Ahmad", "220101001", 2022, 78, 82);
        daftarMhs[1] = new Mahasiswa("Budi", "220101002", 2022, 85, 88);
        daftarMhs[2] = new Mahasiswa("Cindy", "220101003", 2021, 90, 87);
        daftarMhs[3] = new Mahasiswa("Dian", "220101004", 2021, 76, 79);
        daftarMhs[4] = new Mahasiswa("Eko", "220101005", 2023, 92, 95);
        daftarMhs[5] = new Mahasiswa("Fajar", "220101006", 2020, 88, 85);
        daftarMhs[6] = new Mahasiswa("Gina", "220101007", 2023, 80, 83);
        daftarMhs[7] = new Mahasiswa("Hadi", "220101008", 2020, 82, 84);

        System.out.println("--- HASIL PENGOLAHAN DATA MAHASISWA ---");

        int maxUTS = cariMaxUTS(daftarMhs, 0, daftarMhs.length - 1);
        System.out.println("Nilai UTS Tertinggi (Divide and Conquer)    : " + maxUTS);

        int minUTS = cariMinUTS(daftarMhs, 0, daftarMhs.length - 1);
        System.out.println("Nilai UTS Terendah (Divide and Conquer)     : " + minUTS);

        double rataUAS = hitungRataUAS(daftarMhs);
        System.out.println("Rata-rata Nilai UAS                         : " + rataUAS);
    }
}