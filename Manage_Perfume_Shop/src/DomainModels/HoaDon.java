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
public class HoaDon {

    private String idHoaDon;

    private String idTaiKhoan;

    private String tenHoaDon;

    private BigDecimal tongTien;

    private Date ngayThanhToan;

    private String diaChiNhanHang;

    private String ghiChu;

    private int tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String idTaiKhoan, String tenHoaDon, BigDecimal tongTien, Date ngayThanhToan, String diaChiNhanHang, String ghiChu, int tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.idTaiKhoan = idTaiKhoan;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.diaChiNhanHang = diaChiNhanHang;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
