import java.util.Scanner;

public class Tugas2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah jadwal kuliah (n): ");
        int n = input.nextInt();
        input.nextLine(); 

       
        String[][] jadwal = new String[n][4];

    
        inputData(jadwal);

        tampilkanSemua(jadwal);

        System.out.println("Cari jadwal berdasarkan HARI: ");
        String cariHari = input.nextLine();
        tampilkanBerdasarkanHari(jadwal, cariHari);

        System.out.println("Cari jadwal berdasarkan NAMA MATA KULIAH: ");
        String cariMK = input.nextLine();
        tampilkanBerdasarkanMK(jadwal, cariMK);
    }

    public static void inputData(String[][] jadwal) {
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println("Input Jadwal ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah : ");
            jadwal[i][0] = input.nextLine();
            System.out.print("Ruang            : ");
            jadwal[i][1] = input.nextLine();
            System.out.print("Hari Kuliah      : ");
            jadwal[i][2] = input.nextLine();
            System.out.print("Jam Kuliah       : ");
            jadwal[i][3] = input.nextLine();
        }
    }

    public static void tampilkanSemua(String[][] jadwal) {
        System.out.println("============================================================================");
        System.out.printf("%-3s | %-25s | %-15s | %-10s | %-12s\n", "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < jadwal.length; i++) {
            System.out.printf("%-3d | %-25s | %-15s | %-10s | %-12s\n", 
                (i + 1), jadwal[i][0], jadwal[i][1], jadwal[i][2], jadwal[i][3]);
        }
        System.out.println("============================================================================");
    }


    public static void tampilkanBerdasarkanHari(String[][] jadwal, String hari) {
        System.out.println("--- Hasil Pencarian Hari: " + hari + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hari)) {
                System.out.printf("%-25s | %-15s | %-12s\n", jadwal[i][0], jadwal[i][1], jadwal[i][3]);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Jadwal tidak ditemukan.");
    }


    public static void tampilkanBerdasarkanMK(String[][] jadwal, String mk) {
        System.out.println("--- Hasil Pencarian Mata Kuliah: " + mk + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jadwal.length; i++) {
 
            if (jadwal[i][0].toLowerCase().contains(mk.toLowerCase())) {
                System.out.printf("Ruang: %s | Hari: %s | Jam: %s\n", jadwal[i][1], jadwal[i][2], jadwal[i][3]);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Mata kuliah tidak ditemukan.");

        
    }
}