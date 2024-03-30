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
public class BanHang_SanPhamView {
    private String tenSp;
    private String nhanHieu;
    private String nhomHuong;
    private String danhMuc;
    private String xuatXu;
    private BigDecimal gia;
    private int dungTich;

    public BanHang_SanPhamView() {
    }

    public BanHang_SanPhamView(String tenSp, String nhanHieu, String nhomHuong, String danhMuc, String xuatXu, BigDecimal gia) {
        this.tenSp = tenSp;
        this.nhanHieu = nhanHieu;
        this.nhomHuong = nhomHuong;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.gia = gia;
    }

    public BanHang_SanPhamView(String tenSp, String nhanHieu, String nhomHuong, String danhMuc, String xuatXu, BigDecimal gia, int dungTich) {
        this.tenSp = tenSp;
        this.nhanHieu = nhanHieu;
        this.nhomHuong = nhomHuong;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.gia = gia;
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

    
    
}
