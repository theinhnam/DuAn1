/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author theinhnam
 */
public class LoaiNguoiDung {

    private String idLoaiNguoiDung;

    private String ten;

    public LoaiNguoiDung() {
    }

    public LoaiNguoiDung(String idLoaiNguoiDung, String ten) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.ten = ten;
    }

    public String getIdLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIdLoaiNguoiDung(String idLoaiNguoiDung) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
