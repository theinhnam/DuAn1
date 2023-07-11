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

    private int idTaiKhoan;

    private String email;

    private String matKhau;

    private String hoTen;

    private String tenLoaiNguoiDung;

    public TaiKhoanViews() {
    }

    public TaiKhoanViews(int idTaiKhoan, String email, String matKhau, String hoTen, String tenLoaiNguoiDung) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
    }

    public TaiKhoanViews(String email, String matKhau) {
        this.email = email;
        this.matKhau = matKhau;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenLoaiNguoiDung() {
        return tenLoaiNguoiDung;
    }

    public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
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
