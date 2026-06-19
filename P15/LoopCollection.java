package P15;

import java.util.Iterator;
import java.util.Stack;

public class LoopCollection {
    public static void main(String[] args) {
      
        // LANGKAH 1: Inisialisasi Stack & Perulangan
       
        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        // Menampilkan elemen menggunakan Enhanced For-Loop (for-each)
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        
        // Menampilkan representasi string dari Stack
        System.out.println("\n\n" + fruits.toString());

        // Mengosongkan Stack menggunakan method pop() dalam perulangan while
        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }
        
        System.out.println(""); // Baris baru pembatas

        // LANGKAH 2: Variasi Menampilkan Elemen Stack
        fruits.push("Melon");
        fruits.push("Durian");
        
        System.out.println("");

        // Variasi A: Menggunakan Iterator
        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }

        System.out.println("");
        
        // Variasi B: Menggunakan Stream API dan Lambda Expression
        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });

        System.out.println("");

        // Variasi C: Menggunakan Perulangan For Biasa dengan Indeks (Karakteristik Vector)
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
        
        System.out.println("");
    }
}
