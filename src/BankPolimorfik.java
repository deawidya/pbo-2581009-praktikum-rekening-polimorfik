public class BankPolimorfik {
    public static void main(String[] args) {
        // Membuat tiga object rekening
        Tabungan ani = new Tabungan(
                "101", "Ani", 1000000, 2.5
        );

        Tabungan citra = new Tabungan(
                "102", "Citra", 300000, 2.0
        );

        Giro budi = new Giro(
                "201", "Budi", 200000, 500000
        );

        // Menguji bahwa Rekening merupakan abstract class
        // Rekening r = new Rekening("999", "Eko", 0);
        // Error: Rekening is abstract; cannot be instantiated.

        // Array seluruh rekening
        Rekening[] semua = { ani, citra, budi };

        // Array rekening yang mendapatkan bunga
        BerBunga[] berbunga = { ani, citra };

        // Menampilkan rekening awal
        System.out.println("========== REKENING AWAL ==========");

        for (Rekening r : semua) {
            r.cetakInfo();
        }

        // Memotong biaya administrasi seluruh rekening
        System.out.println("\n========== AKHIR BULAN ============");

        for (Rekening r : semua) {

            int biaya = r.potongBiayaAdmin();

            System.out.printf(
                    "%s biaya admin  : %s%n",
                    r.getNomor(),
                    Rekening.formatRupiah(biaya)
            );
        }

        // Menambahkan bunga untuk rekening berbunga
        for (BerBunga b : berbunga) {

            int bunga = b.tambahBunga();

            System.out.printf(
                    "%s bunga        : %s%n",
                    b.getNomor(),
                    Rekening.formatRupiah(bunga)
            );
        }

        // Menampilkan rekening akhir
        System.out.println("\n========== REKENING AKHIR =========");

        int totalDana = 0;

        for (Rekening r : semua) {

            r.cetakInfo();

            totalDana += r.getSaldo();
        }

        System.out.println("-----------------------------------");

        System.out.printf(
                "Total dana bank : %s%n",
                Rekening.formatRupiah(totalDana)
        );
    }
}
