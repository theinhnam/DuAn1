/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author theinhnam
 */
public class TaiKhoan {

    private String idTaiKhoan;

    private String idLoaiNguoiDung;

    private String email;

    private String matKhau;

    private String hoTen;

    public TaiKhoan() {
    }

    public TaiKhoan(String idTaiKhoan, String idLoaiNguoiDung, String email, String matKhau, String hoTen) {
        this.idTaiKhoan = idTaiKhoan;
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
    }

    public TaiKhoan(String idLoaiNguoiDung, String hoTen) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.hoTen = hoTen;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getIdLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIdLoaiNguoiDung(String idLoaiNguoiDung) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
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
