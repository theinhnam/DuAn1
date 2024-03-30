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

    private String idSanPham;

    private String tenSanPham;

    private String idDanhMuc;

    private String idNhomHuong;

    private int kichThuoc;

    private String idNhanHieu;

    private String idXuatxu;

    private String moTa;

    private BigDecimal giaGoc;

    private BigDecimal giaGiam;

    private int soLuongTon;

    private int tinhTrang;

    private String idKhuyenMai;

    private int chietKhau;

    private String ngayThem;

    private String ngaySua;

    private String imageUrl;
    private int soLuongTrongKho;

    public SanPham() {
    }

    public SanPham(String idSanPham, String tenSanPham, String idDanhMuc, String idNhomHuong, int kichThuoc, String idNhanHieu, String idXuatxu, String moTa, BigDecimal giaGoc, BigDecimal giaGiam, int soLuongTon, int tinhTrang, String idKhuyenMai, int chietKhau, String ngayThem, String ngaySua, String imageUrl, int soLuongTrongKho) {
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
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.imageUrl = imageUrl;
        this.soLuongTrongKho = soLuongTrongKho;
    }
    
    public SanPham(String idSanPham, String tenSanPham, String idDanhMuc, String idNhomHuong, int kichThuoc, String idNhanHieu, String idXuatxu, String moTa, BigDecimal giaGoc, BigDecimal giaGiam, int soLuongTon, int tinhTrang, String idKhuyenMai, int chietKhau, String ngayThem, String ngaySua, String imageUrl) {
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
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.imageUrl = imageUrl;
        
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getIdNhomHuong() {
        return idNhomHuong;
    }

    public void setIdNhomHuong(String idNhomHuong) {
        this.idNhomHuong = idNhomHuong;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getIdNhanHieu() {
        return idNhanHieu;
    }

    public void setIdNhanHieu(String idNhanHieu) {
        this.idNhanHieu = idNhanHieu;
    }

    public String getIdXuatxu() {
        return idXuatxu;
    }

    public void setIdXuatxu(String idXuatxu) {
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

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(int soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    
    
    
}
