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
public class BanHang_HoaDonChiTietView {
    private String tenSp;
    private int soLuong;
    private BigDecimal donGia;
    private int dungTich;
    public BanHang_HoaDonChiTietView() {
    }

    public BanHang_HoaDonChiTietView(String tenSp, int soLuong, BigDecimal donGia) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public BanHang_HoaDonChiTietView(String tenSp, int soLuong, BigDecimal donGia, int dungTich) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.dungTich = dungTich;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
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
    
    
    
    
}
