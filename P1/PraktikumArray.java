import java.util.Scanner;

public class PraktikumArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] daftarNamaMK = {
                "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
                "Matematika Dasar", "Bahasa Inggris", "Dasar Pemrograman",
                "Praktikum Dasar Pemrograman", "Keselamatan dan Kesehatan Kerja"
        };
        MataKuliah[] listMK = new MataKuliah[daftarNamaMK.length];
        System.out.println("=====================================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("=====================================");
        double totalBobotSKS = 0;
        int totalSKS = 0;
        for (int i = 0; i < daftarNamaMK.length; i++) {
            System.out.print("masukkan nilai Angka untuk MK " + daftarNamaMK[i] + ": ");
            double nilai = input.nextDouble();

            int sksTiapMK = 2;

            listMK[i] = new MataKuliah(daftarNamaMK[i], nilai, sksTiapMK);

            totalBobotSKS += (listMK[i].nilaiSetara * listMK[i].sks);
            totalSKS += listMK[i].sks;
        }
        System.out.println("\n=====================================");
        System.out.println("hasil Konversi Nilai");
        System.out.println("=====================================");
        System.out.printf("%-40s %-12s %-12s %-12s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        for (int i = 0; i < listMK.length; i++) {
            System.out.printf("%-40s %-12.2f %-12s %-12.2f\n",
                    listMK[i].nama, listMK[i].nilaiAngka, listMK[i].nilaiHuruf, listMK[i].nilaiSetara);
        }

        double ip = totalBobotSKS / totalSKS;
        System.out.println("=====================================");
        System.out.printf("IP : %.2f\n", ip);

        input.close();
    }
}

class MataKuliah {
    String nama;
    double nilaiAngka;
    String nilaiHuruf;
    double nilaiSetara;
    int sks;

    public MataKuliah(String nama, double nilaiAngka, int sks) {
        this.nama = nama;
        this.nilaiAngka = nilaiAngka;
        this.sks = sks;
        konversi(nilaiAngka);
    }

    private void konversi(double n) {
        if (n > 80 && n <= 100) {
            nilaiHuruf = "A";
            nilaiSetara = 4.0;
        } else if (n > 73 && n <= 80) {
            nilaiHuruf = "B+";
            nilaiSetara = 3.5;
        } else if (n > 65 && n <= 73) {
            nilaiHuruf = "B";
            nilaiSetara = 3.0;
        } else if (n > 60 && n <= 65) {
            nilaiHuruf = "C+";
            nilaiSetara = 2.5;
        } else if (n > 50 && n <= 60) {
            nilaiHuruf = "C";
            nilaiSetara = 2.0;
        } else if (n > 39 && n <= 50) {
            nilaiHuruf = "D";
            nilaiSetara = 1.0;
        } else {
            nilaiHuruf = "E";
            nilaiSetara = 0.0;
        }
    }
}