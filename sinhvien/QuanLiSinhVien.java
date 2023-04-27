package sinhvien;

import java.io.*;
import java.util.*;

public class QuanLiSinhVien {

    List<SinhVien> listSinhVien;
    Scanner sc = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";

    public void ReadFile() {
        List<SinhVien> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/students.csv"))) {
            System.out.print("Ban co muon tiep tuc? \n1.y   2.n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                System.out.println("Huy thanh cong");
                return;
            }
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(COMMA_DELIMITER);
                SinhVien sinhVien = new SinhVien(data[0], data[1], Integer.parseInt(data[2]),
                        data[3], data[4], Integer.parseInt(data[5]));
                list.add(sinhVien);
            }
            System.out.println("Doc thanh cong!");
            String outFile = "data/students.csv";
            FileWriter fileWriter = new FileWriter(outFile);
            for(SinhVien sinhVien : listSinhVien){
                String[] data = {
                        sinhVien.getMaSinhVien(), sinhVien.getHoTen()
                        ,String.valueOf(sinhVien.getTuoi()),sinhVien.getDiaChi(),
                        sinhVien.getGioiTinh(), String.valueOf(sinhVien.getDiemTrungBinh())
                };
                fileWriter.write(String.join(",",data));
                fileWriter.write("\n");
            }
            fileWriter.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public List<SinhVien> docFile(){
        List<SinhVien> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/students.csv"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(COMMA_DELIMITER);
                SinhVien sinhVien = new SinhVien(data[0], data[1], Integer.parseInt(data[2]),
                        data[3], data[4], Double.parseDouble(data[5]));
                list.add(sinhVien);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void XemDanhSachSinhVien() {
        listSinhVien = docFile();
        if (listSinhVien.isEmpty()) {
            System.out.println("Danh sach trong!");
        } else {
            for (SinhVien sv : listSinhVien) {
                System.out.println(sv);
            }
        }
    }
    public void ThemSinhVien(){
        SinhVien sinhVien = null;
        System.out.println("Nhap ma sinh vien: ");
        String msv = sc.nextLine();
        String hoTen;
        int tuoi;
        String gender = "";
        String diaChi;
        int diem;
        boolean okey = false;
        for(SinhVien sv : listSinhVien){
            if(sv.getMaSinhVien().equals(msv)){
                System.out.println("Da ton tai sinh vien");
                okey = true;
                break;
            }
        }
        if(okey == false){
            System.out.println("Nhap ho va ten: ");
            hoTen = sc.nextLine();
            System.out.println("Nhap tuoi: ");
            tuoi = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap gioi tinh:   1.Nam     2.Nu");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                gender = "Nam";
            }else if(choice == 2){
                gender = "Nu";
            }
            System.out.println("Nhap dia chi: ");
            diaChi = sc.nextLine();
            System.out.println("Nhap diem trung binh: ");
            diem = sc.nextInt();
            sc.nextLine();
            sinhVien = new SinhVien(msv, hoTen, tuoi, diaChi, gender, diem);
            listSinhVien.add(sinhVien);
            System.out.println("Them thanh cong");
        }else{
            System.out.println("Them khong thanh cong");
        }

    }

    public void SuaSinhVien(){
        System.out.println("Nhap ma sinh vien: ");
        String msv = sc.nextLine();
        for(SinhVien sv : listSinhVien){
            if(sv.getMaSinhVien().equals(msv));
            System.out.println("Ban muon chinh sua gi:\n1.Ma sinh vien  \n2.Ho ten \n3.Tuoi  \n4.Gioi tinh \n5.Dia chi  \n6.Diem trung binh");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println("Nhap ma sinh vien moi: ");
                String maSinhVien = sc.nextLine();
                sv.setMaSinhVien(maSinhVien);
            } else if(choice == 2){
                System.out.println("Nhap ten moi: ");
                String NewName = sc.nextLine();
                sv.setHoTen(NewName);
            }else if(choice == 3){
                System.out.println("Nhap tuoi: ");
                int tuoi = sc.nextInt();
                sv.setTuoi(tuoi);
            }else if(choice == 4){
                System.out.println("Nhap gioi tinh: ");
                String gioiTinh = sc.nextLine();
                sv.setGioiTinh(gioiTinh);
            }else if(choice == 5){
                System.out.println("Nhap dia chi: ");
                String diachi = sc.nextLine();
                sv.setDiaChi(diachi);
            }else if(choice == 6){
                System.out.println("Nhap diem trung binh: ");
                int diem = sc.nextInt();
                sc.nextLine();
                sv.setDiemTrungBinh(diem);
            }
            break;
        }

    }

    public void XoaSinhVien(){
        System.out.println("Nhap ma sinh vien muon xoa: ");
        String msv = sc.nextLine();
        for(SinhVien sv : listSinhVien){
            if(sv.getMaSinhVien().equals(msv)){
                System.out.println("Ban chac chan muon xoa sinh vien nay chu? \nY  \nN");
                String choice = sc.nextLine();
                if(choice == "y"){
                    listSinhVien.remove(sv);
                    System.out.println("Xoa thanh cong");
                    break;
                }else{
                    break;
                }
            }
        }
    }
    public void SapXep(){
        System.out.println("Ban muon sap xep theo thu tu nao: \n1.Diem trung binh tang dan  \n2.Diem trung binh giam dan    \n3.Thoat");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 2){
            Collections.sort(listSinhVien, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    if(o1.getDiemTrungBinh() > o2.getDiemTrungBinh()){
                        return -1;
                    }else if(o1.getDiemTrungBinh() == o2.getDiemTrungBinh()){
                        return 0;
                    }else{
                        return 1;
                    }
                }
            });
            for(SinhVien sv : listSinhVien){
                System.out.println(sv);
            }
        }else if(choice == 1){
            Collections.sort(listSinhVien, Comparator.comparing(SinhVien :: getDiemTrungBinh));
            for(SinhVien sv : listSinhVien){
                System.out.println(sv);
            }
        }
    }
    public void WriteFile() {
        try (FileWriter writer = new FileWriter("data/students.csv")) {
            for (SinhVien sinhVien : listSinhVien) {
                String[] data = { sinhVien.getMaSinhVien(), sinhVien.getHoTen(), Integer.toString(sinhVien.getTuoi()), sinhVien.getGioiTinh(), sinhVien.getDiaChi(), Double.toString(sinhVien.getDiemTrungBinh()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
