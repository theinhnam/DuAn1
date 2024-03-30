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
public class KhoHang_SanPhamView {
    private String tenSp;
    private String nhanHieu;
    private String nhomHuong;
    private String danhMuc;
    private String xuatXu;
    private BigDecimal gia;
    private int soLuongTon;
    private int dungTich;
    public KhoHang_SanPhamView() {
    }

    public KhoHang_SanPhamView(String tenSp, String nhanHieu, String nhomHuong, String danhMuc, String xuatXu, BigDecimal gia) {
        this.tenSp = tenSp;
        this.nhanHieu = nhanHieu;
        this.nhomHuong = nhomHuong;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.gia = gia;
    }

    public KhoHang_SanPhamView(String tenSp, String nhanHieu, String nhomHuong, String danhMuc, String xuatXu, BigDecimal gia, int soLuongTon, int dungTich) {
        this.tenSp = tenSp;
        this.nhanHieu = nhanHieu;
        this.nhomHuong = nhomHuong;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.gia = gia;
        this.soLuongTon = soLuongTon;
        this.dungTich = dungTich;
    }
    
    
    

    public KhoHang_SanPhamView(String tenSp, String nhanHieu, String nhomHuong, String danhMuc, String xuatXu, BigDecimal gia, int soLuongTon) {
        this.tenSp = tenSp;
        this.nhanHieu = nhanHieu;
        this.nhomHuong = nhomHuong;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.gia = gia;
        this.soLuongTon = soLuongTon;
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

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public String getNhomHuong() {
        return nhomHuong;
    }

    public void setNhomHuong(String nhomHuong) {
        this.nhomHuong = nhomHuong;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    
    
}
