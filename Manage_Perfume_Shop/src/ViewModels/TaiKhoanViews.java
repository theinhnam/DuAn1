/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

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

    public TaiKhoanViews() {
    }

    public TaiKhoanViews(String idTaiKhoan, String email, String matKhau, String hoTen, String idLoaiNguoiDung) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.idLoaiNguoiDung = idLoaiNguoiDung;
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

    public String getIDLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIDLoaiNguoiDung(String tenLoaiNguoiDung) {
        this.idLoaiNguoiDung = tenLoaiNguoiDung;
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
