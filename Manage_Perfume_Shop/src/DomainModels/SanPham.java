/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author theinhnam
 */
public class SanPham {
    private int idSanPham;
    
    private String tenSanPham;
    
    private int idDanhMuc;
    
    private int idNhomHuong;
    
    private int kichThuoc;
    
    private int idNhanHieu;
    
    private int idXuatxu;
    
    private String moTa;
    
    private BigDecimal giaGoc;
    
    private BigDecimal giaGiam;
    
    private int soLuongTon;
    
    private int tinhTrang;
    
    private int idKhuyenMai;
    
    private int chietKhau;

    public SanPham() {
    }

    public SanPham(int idSanPham, String tenSanPham, int idDanhMuc, int idNhomHuong, int kichThuoc, int idNhanHieu, int idXuatxu, String moTa, BigDecimal giaGoc, BigDecimal giaGiam, int soLuongTon, int tinhTrang, int idKhuyenMai, int chietKhau) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.idDanhMuc = idDanhMuc;
        this.idNhomHuong = idNhomHuong;
        this.kichThuoc = kichThuoc;
        this.idNhanHieu = idNhanHieu;
        this.idXuatxu = idXuatxu;
        this.moTa = moTa;
        this.giaGoc = giaGoc;
        this.giaGiam = giaGiam;
        this.soLuongTon = soLuongTon;
        this.tinhTrang = tinhTrang;
        this.idKhuyenMai = idKhuyenMai;
        this.chietKhau = chietKhau;
    }
    
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public int getIdNhomHuong() {
        return idNhomHuong;
    }

    public void setIdNhomHuong(int idNhomHuong) {
        this.idNhomHuong = idNhomHuong;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getIdNhanHieu() {
        return idNhanHieu;
    }

    public void setIdNhanHieu(int idNhanHieu) {
        this.idNhanHieu = idNhanHieu;
    }

    public int getIdXuatxu() {
        return idXuatxu;
    }

    public void setIdXuatxu(int idXuatxu) {
        this.idXuatxu = idXuatxu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(BigDecimal giaGoc) {
        this.giaGoc = giaGoc;
    }

    public BigDecimal getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(BigDecimal giaGiam) {
        this.giaGiam = giaGiam;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(int idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }
    
    
}
