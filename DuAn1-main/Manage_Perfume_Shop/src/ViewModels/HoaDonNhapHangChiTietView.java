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
public class HoaDonNhapHangChiTietView {

    private String tenSanPham;

    private int soLuong;

    private int soLuongThucTe;

    private BigDecimal donGia;

    private int kichThuoc;

    public HoaDonNhapHangChiTietView() {
    }

    public HoaDonNhapHangChiTietView(String tenSanPham, int soLuong, int soLuongThucTe, BigDecimal donGia) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.soLuongThucTe = soLuongThucTe;
        this.donGia = donGia;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
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

    public int getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(int soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

}
