package P11;
public class SLLMain {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        Mahasiswa mhs1 = new Mahasiswa("24212200", "Alvaro", "1A", 4.0);
        Mahasiswa mhs2 = new Mahasiswa("22212202", "Cintia", "3C", 3.5);
        Mahasiswa mhs3 = new Mahasiswa("23212201", "Bimon", "2B", 3.8);
        Mahasiswa mhs4 = new Mahasiswa("21212203", "Dirga", "4D", 3.6);

        sll.addFirst(mhs4);
        sll.addLast(mhs1);
        sll.insertAfter("Dirga", mhs3);
        sll.insertAt(2, mhs2);

        System.out.println("data index 1 : ");
        sll.getData(1);

        System.out.println("data mahasiswa an Bimon berada pada index : " + sll.indexOf("bimon"));
        System.out.println();

        sll.removeFirst();
        sll.removeLast();
        sll.print();

        sll.removeAt(0);
        sll.print();
    }
}
