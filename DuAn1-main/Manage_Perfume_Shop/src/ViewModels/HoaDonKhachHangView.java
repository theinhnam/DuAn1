/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author theinhnam
 */
public class HoaDonKhachHangView {

    private String hoTen;

    private String tenHoaDon;

    private String soDienThoai;

    private BigDecimal tongTien;

    private String ngayMuaHang;

    public HoaDonKhachHangView() {
    }

    public HoaDonKhachHangView(String hoTen, String tenHoaDon, String soDienThoai, BigDecimal tongTien, String ngayMuaHang) {
        this.hoTen = hoTen;
        this.tenHoaDon = tenHoaDon;
        this.soDienThoai = soDienThoai;
        this.tongTien = tongTien;
        this.ngayMuaHang = ngayMuaHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(String ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

}
