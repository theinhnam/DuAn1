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

    private String tenHoaDon;
    private BigDecimal tongTien;
    private String ghiChu;
    private String ngayThem;
    private int trangThai;
    private String idkhuyenMai;
    private String idKhachHang;

    public BanHang_HoaDonView() {
    }

    public BanHang_HoaDonView(String idHoaDon, String nguoiThem, String tenHoaDon, BigDecimal tongTien, String ghiChu, String ngayThem, int trangThai, String idkhuyenMai, String idKhachHang) {
        this.idHoaDon = idHoaDon;
        this.nguoiThem = nguoiThem;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayThem = ngayThem;
        this.trangThai = trangThai;
        this.idkhuyenMai = idkhuyenMai;
        this.idKhachHang = idKhachHang;
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

    public String getIdkhuyenMai() {
        return idkhuyenMai;
    }

    public void setIdkhuyenMai(String idkhuyenMai) {
        this.idkhuyenMai = idkhuyenMai;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    
    
    
}
