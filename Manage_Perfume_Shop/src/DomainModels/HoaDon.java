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

    private String ghiChu;

    private String ngayThem;

    private int tinhTrang;

    private int stt;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String idTaiKhoan, String tenHoaDon, BigDecimal tongTien, String ghiChu, String ngayThem, int tinhTrang, int stt) {
        this.idHoaDon = idHoaDon;
        this.idTaiKhoan = idTaiKhoan;
        this.tenHoaDon = tenHoaDon;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayThem = ngayThem;
        this.tinhTrang = tinhTrang;
        this.stt = stt;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

}
