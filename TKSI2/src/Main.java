
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fadel
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Jumlah Pinjaman: ");
        double pinjaman = sc.nextDouble();
        System.out.print("Bunga/Tahun: ");
        double persen = sc.nextDouble();
        System.out.print("Tenor: ");
        double waktu = sc.nextDouble();
        System.out.print("Biaya Administrasi: ");
        double admin = sc.nextDouble();
        solver s = new solver(pinjaman, persen, waktu, admin);
        System.out.print("Jenis Kredit Bunga: 1)Flat, 2)Efektif =");
        int jenis = sc.nextInt();

        if (jenis == 1) {
            System.out.print("Angsuran Flat : Rp.");
            System.out.println(s.Flat() + ",-");
            System.out.println("");
        } else {
            for (int i = 0; i < waktu; i++) {
                System.out.print("Angsuran Efektif bulan ke-" + (i + 1) + ": Rp.");
                System.out.println(s.efektif(i) + ",-");
            }
        }
       
    }
}

class solver {

    double pinjaman;
    double persen;
    double waktu;
    double admin;
    double[] anuitas;

    public solver(double pinjaman, double persen, double waktu, double admin) {
        this.pinjaman = pinjaman;
        this.persen = persen;
        this.waktu = waktu;
        this.anuitas = new double[(int) waktu];
        for (int i = 0; i < waktu; i++) {
            this.anuitas[i] = 0;
        }
    }

    double Flat() {
        double cicilanPokok = 0;
        double bunga = 0;
        double angsuran = 0;
        cicilanPokok = pinjaman / waktu;
        bunga = (pinjaman * (persen / 100.0)) / 12.0;
        angsuran = cicilanPokok + bunga + admin;
        return angsuran;
    }

    double efektif(double i) {
        double cicilanPokok = 0;
        double bunga = 0;
        double angsuran = 0;
        cicilanPokok = pinjaman / waktu;
        bunga = ((pinjaman - (i * cicilanPokok)) * (persen / 100.0)) / 12.0;
        angsuran = cicilanPokok + bunga + admin;
        return angsuran;
    }


}
