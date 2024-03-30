/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author Duc Toan
 */
public class HoaDonNhap {

    private String idHoaDon;
    private String nhaCungUng;
    private String tenHoaDon;
    private String idNhanVienKho;
    private String idNhanVienCuaHang;
    private String ngayThem;
    private BigDecimal tongTien;
    private String ghiChu;
    private int trangThai;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String idHoaDon, String nhaCungUng, String tenHoaDon, String idNhanVienKho, String idNhanVienCuaHang, String ngayThem, BigDecimal tongTien, String ghiChu, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.nhaCungUng = nhaCungUng;
        this.tenHoaDon = tenHoaDon;
        this.idNhanVienKho = idNhanVienKho;
        this.idNhanVienCuaHang = idNhanVienCuaHang;
        this.ngayThem = ngayThem;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNhaCungUng() {
        return nhaCungUng;
    }

    public void setNhaCungUng(String nhaCungUng) {
        this.nhaCungUng = nhaCungUng;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public String getIdNhanVienKho() {
        return idNhanVienKho;
    }

    public void setIdNhanVienKho(String idNhanVienKho) {
        this.idNhanVienKho = idNhanVienKho;
    }

    public String getIdNhanVienCuaHang() {
        return idNhanVienCuaHang;
    }

    public void setIdNhanVienCuaHang(String idNhanVienCuaHang) {
        this.idNhanVienCuaHang = idNhanVienCuaHang;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
    
}
