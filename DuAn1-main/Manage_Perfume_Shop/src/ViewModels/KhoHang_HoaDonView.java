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
public class KhoHang_HoaDonView {

    private String nguoiThem;
    private String tenHoaDon;
    private BigDecimal tongTien;
    private String ngayThem;
    private String nhaCungUng;
    private String ghiChu;
    private String idHoaDon;

    public KhoHang_HoaDonView() {
    }

    public KhoHang_HoaDonView(String nguoiThem, String tenHoaDon, BigDecimal tongTien, String ngayThem, String nhaCungUng, String ghiChu, String idHoaDon) {
        this.nguoiThem = nguoiThem;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ngayThem = ngayThem;
        this.nhaCungUng = nhaCungUng;
        this.ghiChu = ghiChu;
        this.idHoaDon = idHoaDon;
    }

    public String getNguoiThem() {
        return nguoiThem;
    }

    public void setNguoiThem(String nguoiThem) {
        this.nguoiThem = nguoiThem;
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

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getNhaCungUng() {
        return nhaCungUng;
    }

    public void setNhaCungUng(String nhaCungUng) {
        this.nhaCungUng = nhaCungUng;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }


    
}
