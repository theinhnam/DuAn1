/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author theinhnam
 */
public class NhapSanPham {

    private int idNhapSanPham;

    private int idSanPham;

    private BigDecimal donGia;

    private Date ngayNhap;

    private Date ngayThanhToan;

    private int soLuong;

    private int tinhTrang;

    public NhapSanPham() {
    }

    public NhapSanPham(int idNhapSanPham, int idSanPham, BigDecimal donGia, Date ngayNhap, Date ngayThanhToan, int soLuong, int tinhTrang) {
        this.idNhapSanPham = idNhapSanPham;
        this.idSanPham = idSanPham;
        this.donGia = donGia;
        this.ngayNhap = ngayNhap;
        this.ngayThanhToan = ngayThanhToan;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public int getIdNhapSanPham() {
        return idNhapSanPham;
    }

    public void setIdNhapSanPham(int idNhapSanPham) {
        this.idNhapSanPham = idNhapSanPham;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
