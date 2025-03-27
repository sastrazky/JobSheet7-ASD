import java.util.Scanner;

public class MainDosen20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen20 dataDosen = new DataDosen20();
        int pilihan;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Sorting ASC (Usia Termuda ke Tertua)");
            System.out.println("4. Sorting DSC (Usia Tertua ke Termuda)");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Kode: ");
                    String kode = sc.next();
                    System.out.print("Nama: ");
                    String nama = sc.next();
                    System.out.print("Jenis Kelamin (true=Laki-laki, false=Perempuan): ");
                    boolean jenisKelamin = sc.nextBoolean();
                    System.out.print("Usia: ");
                    int usia = sc.nextInt();
                    Dosen20 dsn = new Dosen20(kode, nama, jenisKelamin, usia);
                    dataDosen.tambah(dsn);
                    break;

                case 2:
                    dataDosen.tampil();
                    break;

                case 3:
                    dataDosen.sortingASC();
                    System.out.println("Data berhasil diurutkan secara ASC (Usia Termuda ke Tertua)");
                    break;

                case 4:
                    dataDosen.sortingDSC();
                    System.out.println("Data berhasil diurutkan secara DSC (Usia Tertua ke Termuda)");
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 5);

        sc.close();
    }
}
