package P15;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContohList {
    public static void main(String[] args) {
        //percobaan 1 (modif nomor 2) arraylist dengan generics <integer>
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        
        // l.add("Cireng"); // Baris ini harus dimatikan karena sudah dikunci tipe Integer
        
        System.out.printf("Elemen 0: %d total elemen: %d elemen terakhir: %d\n",
                l.get(0), l.size(), l.get(l.size() - 1));
        
        l.add(4);
        l.remove(0);
        
        System.out.printf("Elemen 0: %d total elemen: %d elemen terakhir: %d\n",
                l.get(0), l.size(), l.get(l.size() - 1));

        System.out.println(); // Pembatas antar percobaan

        
        // percobaan 2 (modif 3 & 4): Menggunakan LinkedList secara langsung
        // Perubahan Nomor 3: Menggunakan referensi class LinkedList langsung
        LinkedList<String> names = new LinkedList<>();
        names.add("Noureen");
        names.add("Akhleema");
        names.add("Shannum");
        names.add("Uwais");
        names.add("Al-Qarni");
        
        System.out.printf("Elemen 0: %s total elemen: %s elemen terakhir: %s\n",
                names.get(0), names.size(), names.get(names.size() - 1));
        
        names.set(0, "My kid");
        
        System.out.printf("Elemen 0: %s total elemen: %s elemen terakhir: %s\n",
                names.get(0), names.size(), names.get(names.size() - 1));
        
        System.out.println("Names: " + names.toString());
        
        // Perubahan Nomor 4: Penambahan operasi Stack/Deque pada LinkedList
        names.push("Mei-mei");
        
        System.out.printf("Elemen 0: %s total elemen: %s elemen terakhir: %s\n",
                names.getFirst(), names.size(), names.getLast());
        
        System.out.println("Names: " + names.toString());
    }
}