package Controller;

import sinhvien.QuanLiSinhVien;
import sinhvien.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        QuanLiSinhVien qls = new QuanLiSinhVien();
        List<SinhVien> list = new ArrayList<>();
        while (true){
            System.out.println("\n1.Xem danh sách sinh viên \n2.Sắp xếp   \n3.Them sinh vien   \n4.Sua sinh vien  \n5.Xoa sinh vien  \n6.Doc File   \n7.Ghi file    \n8.Thoat");
            String choice = sc.nextLine();
            switch (choice){
                case "1" -> qls.XemDanhSachSinhVien();
                case "2" -> qls.SapXep();
                case "3" -> qls.ThemSinhVien();
                case "4" -> qls.SuaSinhVien();
                case "5" -> qls.XoaSinhVien();
                case "6" -> qls.ReadFile();
                case "7" -> qls.WriteFile();
                case "8" -> System.exit(0);
            }
        }



    }
}

