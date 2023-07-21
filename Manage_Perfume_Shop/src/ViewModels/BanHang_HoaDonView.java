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
public class BanHang_HoaDonView {
    private String idHoaDon;
    private String nguoiThem;
    private int stt;
    private String tenHoaDon;
    private BigDecimal tongTien;
    private String ghiChu;
    private String ngayThem;
    private int trangThai;

    public BanHang_HoaDonView() {
    }

    public BanHang_HoaDonView(String idHoaDon, String nguoiThem, int stt, String tenHoaDon, BigDecimal tongTien, String ghiChu, String ngayThem, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.nguoiThem = nguoiThem;
        this.stt = stt;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayThem = ngayThem;
        this.trangThai = trangThai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNguoiThem() {
        return nguoiThem;
    }

    public void setNguoiThem(String nguoiThem) {
        this.nguoiThem = nguoiThem;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
