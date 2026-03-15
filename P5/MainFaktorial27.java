package P5;
import java.util.Scanner;
public class MainFaktorial27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nilai: ");
        int nilai = input.nextInt();

       
        Faktorial27 fk = new Faktorial27();

        System.out.println("Nilai faktorial " + nilai + 
                           " menggunakan BF: " + fk.faktorialBF(nilai));
        System.out.println("Nilai faktorial " + nilai + 
                           " menggunakan DC: " + fk.faktorialDC(nilai));
        
        input.close();
    }
}