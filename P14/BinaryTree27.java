package P14;

public class BinaryTree27 {
    Node27 root;

    public BinaryTree27() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Menambahkan node baru secara non-rekursif berdasarkan nilai IPK
    public void add(Mahasiswa27 mahasiswa) {
        Node27 newNode = new Node27(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node27 current = root;
            Node27 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Melakukan pencarian data mahasiswa berdasarkan IPK
    public boolean find(double ipk) {
        boolean result = false;
        Node27 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    // Traversal Pre-Order
    void traversePreOrder(Node27 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Traversal In-Order
    void traverseInOrder(Node27 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    // Traversal Post-Order
    void traversePostOrder(Node27 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    // Mendapatkan node suksesor untuk proses penghapusan (node dengan 2 anak)
    Node27 getSuccessor(Node27 del) {
        Node27 successor = del.right;
        Node27 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    // Menghapus node berdasarkan IPK
    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }

        // Cari node (current) yang akan dihapus beserta parent-nya
        Node27 parent = root;
        Node27 current = root;
        boolean isLeftChild = false;

        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        // Proses Penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            // Kasus 1: Jika tidak ada anak (leaf node)
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } 
            // Kasus 2a: Jika hanya punya 1 anak kanan
            else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } 
            // Kasus 2b: Jika hanya punya 1 anak kiri
            else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } 
            // Kasus 3: Jika memiliki 2 anak
            else {
                Node27 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();

                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }


    public void addRekursif(Mahasiswa27 mahasiswa) {
        root = addRekursif(root, mahasiswa);
    }

    private Node27 addRekursif(Node27 current, Mahasiswa27 mahasiswa) {
        if (current == null) {
            return new Node27(mahasiswa);
        }
        
        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = addRekursif(current.left, mahasiswa);
        } else if (mahasiswa.ipk > current.mahasiswa.ipk) {
            current.right = addRekursif(current.right, mahasiswa);
        }
        return current;
    }


    public void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong!");
            return;
        }
        Node27 current = root;
        while (current.left != null) {
            current = current.left; // IPK terkecil selalu berada di paling kiri bawah
        }
        System.out.print("IPK Terkecil -> ");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong!");
            return;
        }
        Node27 current = root;
        while (current.right != null) {
            current = current.right; // IPK terbesar selalu berada di paling kanan bawah
        }
        System.out.print("IPK Terbesar -> ");
        current.mahasiswa.tampilInformasi();
    }

 
    public void tampilMahasiswaIPKDiAtas(double ipkBatas) {
        System.out.println("Daftar Mahasiswa dengan IPK > " + ipkBatas + " :");
        tampilIPKDiAtas(root, ipkBatas);
    }

    private void tampilIPKDiAtas(Node27 node, double ipkBatas) {
        if (node != null) {
            tampilIPKDiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilIPKDiAtas(node.right, ipkBatas);
        }
    }
}