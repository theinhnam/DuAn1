/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.sql.Date;

/**
 *
 * @author theinhnam
 */
public class TaiKhoanViews {

    private String idTaiKhoan;

    private String email;

    private String matKhau;

    private String hoTen;

    private String idLoaiNguoiDung;

    private String tenLoaiNguoiDung;

    private Date ngayThem;

    private Date ngaySua;

    private int trangThai;

    public TaiKhoanViews() {
    }

    public TaiKhoanViews(String idTaiKhoan, String email, String matKhau, String hoTen, String idLoaiNguoiDung, String tenLoaiNguoiDung, Date ngayThem, Date ngaySua, int tinhTrang) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = tinhTrang;
    }

    public TaiKhoanViews(String idTaiKhoan ,String email, String matKhau, String hoTen, String tenLoaiNguoiDung, Date ngayThem, Date ngaySua, int tinhTrang) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = tinhTrang;
    }

    public TaiKhoanViews(String idTaiKhoan, String email, String matKhau, String hoTen, String tenLoaiNguoiDung, int trangThai) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
        this.trangThai = trangThai;
    }

    public TaiKhoanViews(String email, String matKhau, String hoTen, String tenLoaiNguoiDung, int trangThai) {
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
        this.trangThai = trangThai;
    }

    public String getIdLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIdLoaiNguoiDung(String idLoaiNguoiDung) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
    }

    public String getTenLoaiNguoiDung() {
        return tenLoaiNguoiDung;
    }

    public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
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

    public int getTinhTrang() {
        return trangThai;
    }

    public void setTinhTrang(int tinhTrang) {
        this.trangThai = tinhTrang;
    }

    public TaiKhoanViews(String hoTen, String idLoaiNguoiDung) {
        this.hoTen = hoTen;
        this.idLoaiNguoiDung = idLoaiNguoiDung;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
