//Nama: Muhammad Rafiqi Ar Rasyid
//Nim: 244107060052
//No. Absen: 09

import java.util.Scanner;

public class UAS1E09 {
    public static void main(String[] args) {
        Scanner sc09 = new Scanner(System.in);

        System.out.print("Masukkan dua digit terakhir NIM Anda: ");
        int nim09 = sc09.nextInt();
        int jumlahTim09 = (nim09 % 3) + 4;
        sc09.nextLine(); 

        String[] namaTim09 = new String[jumlahTim09];
        int[][] skorTim09 = new int[jumlahTim09][2];
        int[] totalSkor09 = new int[jumlahTim09];
        boolean dataInput09 = false;

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int menu09 = sc09.nextInt();
            sc09.nextLine();

            switch (menu09) {
                case 1:
                    for (int i = 0; i < jumlahTim09; i++) {
                        System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
                        namaTim09[i] = sc09.nextLine();

                        for (int j = 0; j < 2; j++) {
                            while (true) {
                                System.out.print("Masukkan skor " + namaTim09[i] + " untuk Level " + (j + 1) + ": ");
                                int skor09 = sc09.nextInt();
                                if (skor09 >= 0) {
                                    if (j == 0 && skor09 < 35) {
                                        skor09 = 0;
                                    }
                                    skorTim09[i][j] = skor09;
                                    break;
                                } else {
                                    System.out.println("Skor tidak valid. Harus bilangan positif atau nol.");
                                }
                            }
                        }
                        sc09.nextLine();
                    }
                    dataInput09 = true;
                    break;

                case 2:
                    if (!dataInput09) {
                        System.out.println("Tidak ada data yang bisa ditampilkan.");
                        break;
                    }
                    int nomorAbsen09 = 9; 
                    for (int i = 0; i < jumlahTim09; i++) {
                        totalSkor09[i] = skorTim09[i][0] + skorTim09[i][1];

                        if (totalSkor09[i] % 2 == 0) {
                            totalSkor09[i] -= 15; 
                        }

                        if (skorTim09[i][0] > 50 && skorTim09[i][1] > 50) {
                            totalSkor09[i] += nomorAbsen09; 
                        }
                    }

                    System.out.printf("%n%-15s %-10s %-10s %-10s%n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
                    System.out.println("---------------------------------------------");
                    for (int i = 0; i < jumlahTim09; i++) {
                        System.out.printf("%-15s %-10d %-10d %-10d%n", namaTim09[i], skorTim09[i][0], skorTim09[i][1], totalSkor09[i]);
                    }
                    break;

                case 3:
                    if (!dataInput09) {
                        System.out.println("Data skor belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                        break;
                    }

                    int juara09 = 0;
                    boolean seri09 = false;
                    for (int i = 1; i < jumlahTim09; i++) {
                        if (totalSkor09[i] > totalSkor09[juara09]) {
                            juara09 = i;
                            seri09 = false;
                        } else if (totalSkor09[i] == totalSkor09[juara09]) {
                            seri09 = true;
                            if (skorTim09[i][1] > skorTim09[juara09][1]) {
                                juara09 = i;
                                seri09 = false;
                            }
                        }
                    }

                    if (seri09) {
                        System.out.println("Turnamen berakhir seri. Tim terbaik adalah yang buat progam RAFIQIII!!!.");
                    } else {
                        System.out.println("Selamat kepada Tim " + namaTim09[juara09] + " yang telah memenangkan kompetisi!");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    return;

                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu antara 1-4.");
            }
        }
    }
}
