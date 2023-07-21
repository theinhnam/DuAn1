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
public class NhapSanPham {
    private String idNhapSanPham;
    private String idSanPham;
    private BigDecimal donGia;
    private String ngayThanhToan;
    private int soLuong;
    private String ngayThem;
    private String ngaySua;
    private int trangThai;
    private String idTaiKhoan;

    public NhapSanPham() {
    }

    public NhapSanPham(String idNhapSanPham, String idSanPham, BigDecimal donGia, String ngayThanhToan, int soLuong, String ngayThem, String ngaySua, int trangThai, String idTaiKhoan) {
        this.idNhapSanPham = idNhapSanPham;
        this.idSanPham = idSanPham;
        this.donGia = donGia;
        this.ngayThanhToan = ngayThanhToan;
        this.soLuong = soLuong;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getIdNhapSanPham() {
        return idNhapSanPham;
    }

    public void setIdNhapSanPham(String idNhapSanPham) {
        this.idNhapSanPham = idNhapSanPham;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }
    
    
    
    
}
