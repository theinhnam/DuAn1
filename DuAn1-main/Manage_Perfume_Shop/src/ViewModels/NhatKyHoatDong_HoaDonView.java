/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author Duc Toan
 */
public class NhatKyHoatDong_HoaDonView {
    private String idHoaDon;

    private String email;

    private String tenHoaDon;

    private BigDecimal tongTien;

    private String ghiChu;

    private String ngayThem;

    private int tinhTrang;
    
    private String sdtKhachHang;

    public NhatKyHoatDong_HoaDonView() {
    }

    public NhatKyHoatDong_HoaDonView(String idHoaDon, String email, String tenHoaDon, BigDecimal tongTien, String ghiChu, String ngayThem, int tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.email = email;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayThem = ngayThem;
        this.tinhTrang = tinhTrang;
    }

    public NhatKyHoatDong_HoaDonView(String idHoaDon, String email, String tenHoaDon, BigDecimal tongTien, String ghiChu, String ngayThem, int tinhTrang, String sdtKhachHang) {
        this.idHoaDon = idHoaDon;
        this.email = email;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayThem = ngayThem;
        this.tinhTrang = tinhTrang;
        this.sdtKhachHang = sdtKhachHang;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }
    
    
    

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
    
}
