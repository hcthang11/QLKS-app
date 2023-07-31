/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class DichVu {
    String MaDichVu;
    String TenDichVu;
    String MaKhachHang;
    Date NgayBatDauSuDung;
    Date NgayKetThucSuDung;
    float GiaDichVu;

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public Date getNgayBatDauSuDung() {
        return NgayBatDauSuDung;
    }

    public void setNgayBatDauSuDung(Date NgayBatDauSuDung) {
        this.NgayBatDauSuDung = NgayBatDauSuDung;
    }

    public Date getNgayKetThucSuDung() {
        return NgayKetThucSuDung;
    }

    public void setNgayKetThucSuDung(Date NgayKetThucSuDung) {
        this.NgayKetThucSuDung = NgayKetThucSuDung;
    }

    public float getGiaDichVu() {
        return GiaDichVu;
    }

    public void setGiaDichVu(float GiaDichVu) {
        this.GiaDichVu = GiaDichVu;
    }
    
    
}
