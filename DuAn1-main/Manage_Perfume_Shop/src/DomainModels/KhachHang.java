/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;



/**
 *
 * @author theinhnam
 */
public class KhachHang {

    private String idKhachHang;

    private String hoTen;

    private String soDienThoai;

    private Date ngayThem;

    private Date ngaySua;

    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(String idKhachHang, String hoTen, String soDienThoai, Date ngayThem, Date ngaySua, int trangThai) {
        this.idKhachHang = idKhachHang;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public KhachHang(String hoTen, String soDienThoai, Date ngayThem, Date ngaySua, int trangThai) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
