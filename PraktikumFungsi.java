public class PraktikumFungsi {

    public static void main(String[] args) {
   
        String[] cabang = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};

        int[][] stock = {
            {10, 5, 15, 7},
            {6, 11, 9, 12},
            {2, 10, 10, 5},
            {5, 7, 12, 9}
        };


        int[] harga = {75000, 50000, 60000, 10000};

        System.out.println("==========================================================");
        System.out.printf("%-15s | %-15s | %-15s\n", "Cabang", "Pendapatan", "Status");
        System.out.println("----------------------------------------------------------");


        tampilkanPendapatanDanStatus(cabang, stock, harga);
        
        System.out.println("==========================================================");
    }

    public static void tampilkanPendapatanDanStatus(String[] cabang, int[][] stock, int[] harga) {
        for (int i = 0; i < stock.length; i++) {
            int pendapatanCabang = 0;

            for (int j = 0; j < stock[i].length; j++) {
                pendapatanCabang += stock[i][j] * harga[j];
            }

            String status;
            if (pendapatanCabang > 1500000) {
                status = "Sangat Baik";
            } else {
                status = "Perlu Evaluasi";
            }

            System.out.printf("%-15s | Rp %-12d | %-15s\n", cabang[i], pendapatanCabang, status);
        } 
    }
}