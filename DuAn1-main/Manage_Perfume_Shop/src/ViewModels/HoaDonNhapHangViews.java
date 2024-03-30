/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author foxin
 */
public class HoaDonNhapHangViews {
    private String idHoaDon;
    
    private String nhaCungUng;
    
    private String nhanVienKho;
    
    private String tenHoaDon;
    
    private BigDecimal tongTien;
    
    private String ngayThem;

    public HoaDonNhapHangViews() {
    }

    public HoaDonNhapHangViews(String idHoaDon, String nhaCungUng, String nhanVienKho, String tenHoaDon, BigDecimal tongTien, String ngayThem) {
        this.idHoaDon = idHoaDon;
        this.nhaCungUng = nhaCungUng;
        this.nhanVienKho = nhanVienKho;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ngayThem = ngayThem;
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

    public String getnhanVienKho() {
        return nhanVienKho;
    }

    public void setNhanVienKho(String nhanVienKho) {
        this.nhanVienKho = nhanVienKho;
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
    
    
}
