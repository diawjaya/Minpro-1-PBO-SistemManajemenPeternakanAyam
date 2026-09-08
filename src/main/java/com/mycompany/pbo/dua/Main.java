/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo.dua;

/**
 *
 * @author ASUS TUF
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Kandang> kandang = new ArrayList<>();
    static ArrayList<JenisAyam> jenisAyam = new ArrayList<>();
    static ArrayList<Pakan> pakan = new ArrayList<>();
    static ArrayList<PemberianPakan> pemberian = new ArrayList<>();

    public static void main(String[] args) {

        // Data awal kandang
        kandang.add(new Kandang(1, "Kandang A", 100, 80, "Broiler", 20));
        kandang.add(new Kandang(2, "Kandang B", 150, 120, "Layer", 30));
        kandang.add(new Kandang(3, "Kandang C", 80, 60, "Kampung", 15));

        // Data awal jenis ayam
        jenisAyam.add(new JenisAyam(1, "Broiler", 35));
        jenisAyam.add(new JenisAyam(2, "Layer", 70));
        jenisAyam.add(new JenisAyam(3, "Kampung", 60));

        // Data awal pakan
        pakan.add(new Pakan(1, "Jagung", 500));
        pakan.add(new Pakan(2, "Dedak", 300));

        // Data awal pemberian pakan
        pemberian.add(new PemberianPakan(1, 20, "08-09-2026", "08:00"));
        pemberian.add(new PemberianPakan(2, 25, "08-09-2026", "16:00"));

        int pilih;

        do {
            System.out.println("\n=== SISTEM PETERNAKAN ===");
            System.out.println("1. Data Kandang");
            System.out.println("2. Data Jenis Ayam");
            System.out.println("3. Data Pakan");
            System.out.println("4. Pemberian Pakan");
            System.out.println("5. Penghitungan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tampilKandang();
                case 2 -> tampilJenisAyam();
                case 3 -> menuPakan();
                case 4 -> menuPemberian();
                case 5 -> hitung();
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 0);
    }

    // Menampilkan data kandang
    static void tampilKandang() {
        System.out.println("\n=== DATA KANDANG ===");

        for (Kandang k : kandang) {
            System.out.println(
                k.getIdKandang() + " | " +
                k.getNamaKandang() + " | Kapasitas: " +
                k.getKapasitas() + " | Ayam: " +
                k.getJumlahAyam() + " | Jenis: " +
                k.getJenisAyam() + " | Pakan: " +
                k.getPakanDibutuhkan() + " kg"
            );
        }
    }

    // Menampilkan data jenis ayam
    static void tampilJenisAyam() {
        System.out.println("\n=== DATA JENIS AYAM ===");

        for (JenisAyam j : jenisAyam) {
            System.out.println(
                j.getIdJenisAyam() + " | " +
                j.getNamaJenis() + " | Panen: " +
                j.getUmurPanen() + " hari"
            );
        }
    }

    // Menu pakan
    static void menuPakan() {

        System.out.println("\n=== MENU PAKAN ===");
        System.out.println("1. Tambah");
        System.out.println("2. Tampilkan");
        System.out.println("3. Ubah");
        System.out.println("4. Hapus");
        System.out.print("Pilih: ");

        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {

            case 1 -> {
                System.out.print("ID: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Nama: ");
                String nama = input.nextLine();

                System.out.print("Stok: ");
                int stok = input.nextInt();

                pakan.add(new Pakan(id, nama, stok));
                System.out.println("Pakan berhasil ditambahkan.");
            }

            case 2 -> {
                System.out.println("\n=== DATA PAKAN ===");

                for (Pakan p : pakan) {
                    System.out.println(
                        p.getIdPakan() + " | " +
                        p.getNamaPakan() + " | " +
                        p.getStok() + " kg"
                    );
                }
            }

            case 3 -> {
                System.out.print("ID Pakan: ");
                int id = input.nextInt();
                input.nextLine();

                Pakan p = cariPakan(id);

                if (p != null) {
                    System.out.print("Nama baru: ");
                    p.setNamaPakan(input.nextLine());

                    System.out.print("Stok baru: ");
                    p.setStok(input.nextInt());

                    System.out.println("Pakan berhasil diubah.");
                } else {
                    System.out.println("Pakan tidak ditemukan.");
                }
            }

            case 4 -> {
                System.out.print("ID Pakan: ");
                int id = input.nextInt();

                Pakan p = cariPakan(id);

                if (p != null) {
                    pakan.remove(p);
                    System.out.println("Pakan berhasil dihapus.");
                } else {
                    System.out.println("Pakan tidak ditemukan.");
                }
            }

            default -> System.out.println("Pilihan tidak tersedia.");
        }
    }

    // Menu pemberian pakan
    static void menuPemberian() {

        System.out.println("\n=== MENU PEMBERIAN PAKAN ===");
        System.out.println("1. Tambah");
        System.out.println("2. Tampilkan");
        System.out.println("3. Ubah");
        System.out.println("4. Hapus");
        System.out.print("Pilih: ");

        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {

            case 1 -> {
                System.out.print("ID Pemberian: ");
                int id = input.nextInt();

                System.out.print("Jumlah Pakan: ");
                int jumlah = input.nextInt();
                input.nextLine();

                System.out.print("Tanggal: ");
                String tanggal = input.nextLine();

                System.out.print("Waktu: ");
                String waktu = input.nextLine();

                pemberian.add(
                    new PemberianPakan(id, jumlah, tanggal, waktu)
                );

                System.out.println("Data berhasil ditambahkan.");
            }

            case 2 -> {
                System.out.println("\n=== DATA PEMBERIAN PAKAN ===");

                for (PemberianPakan p : pemberian) {
                    System.out.println(
                        p.getIdPemberian() + " | " +
                        p.getJumlahPakan() + " kg | " +
                        p.getTanggalPemberian() + " | " +
                        p.getWaktuPemberian()
                    );
                }
            }

            case 3 -> {
                System.out.print("ID Pemberian: ");
                int id = input.nextInt();
                input.nextLine();

                PemberianPakan p = cariPemberian(id);

                if (p != null) {

                    System.out.print("Jumlah baru: ");
                    p.setJumlahPakan(input.nextInt());
                    input.nextLine();

                    System.out.print("Tanggal baru: ");
                    p.setTanggalPemberian(input.nextLine());

                    System.out.print("Waktu baru: ");
                    p.setWaktuPemberian(input.nextLine());

                    System.out.println("Data berhasil diubah.");

                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

            case 4 -> {
                System.out.print("ID Pemberian: ");
                int id = input.nextInt();

                PemberianPakan p = cariPemberian(id);

                if (p != null) {
                    pemberian.remove(p);
                    System.out.println("Data berhasil dihapus.");
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

            default -> System.out.println("Pilihan tidak tersedia.");
        }
    }

    // Menghitung data
    static void hitung() {

        int totalAyam = 0;
        int totalKapasitas = 0;
        int totalStok = 0;
        int totalPemberian = 0;

        for (Kandang k : kandang) {
            totalAyam += k.getJumlahAyam();
            totalKapasitas += k.getKapasitas();
        }

        for (Pakan p : pakan) {
            totalStok += p.getStok();
        }

        for (PemberianPakan p : pemberian) {
            totalPemberian += p.getJumlahPakan();
        }

        System.out.println("\n=== HASIL PENGHITUNGAN ===");
        System.out.println("Total Ayam       : " + totalAyam + " ekor");
        System.out.println("Total Kapasitas  : " + totalKapasitas + " ekor");
        System.out.println("Total Stok Pakan : " + totalStok + " kg");
        System.out.println("Total Pemberian  : " + totalPemberian + " kg");
        System.out.println("Sisa Pakan       : "
                + (totalStok - totalPemberian) + " kg");
    }

    // Mencari data pakan
    static Pakan cariPakan(int id) {

        for (Pakan p : pakan) {
            if (p.getIdPakan() == id) {
                return p;
            }
        }

        return null;
    }

    // Mencari data pemberian pakan
    static PemberianPakan cariPemberian(int id) {

        for (PemberianPakan p : pemberian) {
            if (p.getIdPemberian() == id) {
                return p;
            }
        }

        return null;
    }
}