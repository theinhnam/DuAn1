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
public class NhatKyHoatDong_HoaDonNhapView {

    private String emailNhanVienKho;
    private String emailNhanVienCuaHang;
    private String tenHoaDon;
    private String nhaCungUng;
    private BigDecimal tongTien;
    private String ngayThem;
    private String ghiChu;
    private String tinhTrang;
    private String idHoaDon;

    public NhatKyHoatDong_HoaDonNhapView() {
    }

    public NhatKyHoatDong_HoaDonNhapView(String emailNhanVienKho, String emailNhanVienCuaHang, String tenHoaDon, String nhaCungUng, BigDecimal tongTien, String ngayThem, String ghiChu, String tinhTrang, String idHoaDon) {
        this.emailNhanVienKho = emailNhanVienKho;
        this.emailNhanVienCuaHang = emailNhanVienCuaHang;
        this.tenHoaDon = tenHoaDon;
        this.nhaCungUng = nhaCungUng;
        this.tongTien = tongTien;
        this.ngayThem = ngayThem;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
        this.idHoaDon = idHoaDon;
    }

    public String getEmailNhanVienKho() {
        return emailNhanVienKho;
    }

    public void setEmailNhanVienKho(String emailNhanVienKho) {
        this.emailNhanVienKho = emailNhanVienKho;
    }

    public String getEmailNhanVienCuaHang() {
        return emailNhanVienCuaHang;
    }

    public void setEmailNhanVienCuaHang(String emailNhanVienCuaHang) {
        this.emailNhanVienCuaHang = emailNhanVienCuaHang;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public String getNhaCungUng() {
        return nhaCungUng;
    }

    public void setNhaCungUng(String nhaCungUng) {
        this.nhaCungUng = nhaCungUng;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    
    
    
    
}
