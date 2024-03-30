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
public class NhatKyHoatDong_HoaDonNhapChiTietView {
    private String tenSanPham;
    private int dungTich;
    private BigDecimal donGia;
    private int soLuong;
    private int soLuongThucTe;

    public NhatKyHoatDong_HoaDonNhapChiTietView() {
    }

    public NhatKyHoatDong_HoaDonNhapChiTietView(String tenSanPham, int dungTich, BigDecimal donGia, int soLuong, int soLuongThucTe) {
        this.tenSanPham = tenSanPham;
        this.dungTich = dungTich;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.soLuongThucTe = soLuongThucTe;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(int soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }
    
    
    
    
}
