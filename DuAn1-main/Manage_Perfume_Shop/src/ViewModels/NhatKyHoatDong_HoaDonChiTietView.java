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
public class NhatKyHoatDong_HoaDonChiTietView {

    private String idHoaDon;
    private String tenSanPham;

    private int soLuong;

    private String ngayThem;

    private BigDecimal donGia;

    private int trangThai;
    private int dungTich;

    public NhatKyHoatDong_HoaDonChiTietView() {
    }

    public NhatKyHoatDong_HoaDonChiTietView(String idHoaDon, String tenSanPham, int soLuong, String ngayThem, BigDecimal donGia, int trangThai, int dungTich) {
        this.idHoaDon = idHoaDon;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.ngayThem = ngayThem;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.dungTich = dungTich;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

}
