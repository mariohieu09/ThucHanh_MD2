package sinhvien;

public class SinhVien {
    private String maSinhVien;
    private String hoTen;
    private int tuoi;
    private String diaChi;
    private String gioiTinh;
    private double DiemTrungBinh;

    public SinhVien(String maSinhVien, String hoTen, int tuoi,String diaChi, String gioiTinh, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        DiemTrungBinh = diemTrungBinh;
    }

    public SinhVien() {
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemTrungBinh() {
        return DiemTrungBinh;
    }

    public void setDiemTrungBinh(int diemTrungBinh) {
        DiemTrungBinh = diemTrungBinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien=" + maSinhVien +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", Dia chi=" + diaChi + '\'' +
                ", DiemTrungBinh=" + DiemTrungBinh +
                '}';
    }

}
