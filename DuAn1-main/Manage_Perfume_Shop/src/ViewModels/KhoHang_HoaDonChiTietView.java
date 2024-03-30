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
public class KhoHang_HoaDonChiTietView {
    private String tenSp;
    private int soLuong;
    private int soLuongThucTe;
    private String emailNv;
    private BigDecimal donGia;
    private String idSanPham;
    private int dungTich;

    public KhoHang_HoaDonChiTietView() {
    }

    public KhoHang_HoaDonChiTietView(String tenSp, int soLuong, BigDecimal donGia, String idSanPham, int dungTich) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.idSanPham = idSanPham;
        this.dungTich = dungTich;
    }

    public KhoHang_HoaDonChiTietView(String tenSp, int soLuong, int soLuongThucTe, String emailNv, BigDecimal donGia, String idSanPham, int dungTich) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.soLuongThucTe = soLuongThucTe;
        this.emailNv = emailNv;
        this.donGia = donGia;
        this.idSanPham = idSanPham;
        this.dungTich = dungTich;
    }
    
    
    

    public int getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(int soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }

    public String getEmailNv() {
        return emailNv;
    }

    public void setEmailNv(String emailNv) {
        this.emailNv = emailNv;
    }
    
    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }
    
    
    
    
}
