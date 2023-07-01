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

    private int idLoaiNguoiDung;

    private String ten;

    public LoaiNguoiDung() {
    }

    public LoaiNguoiDung(int idLoaiNguoiDung, String ten) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.ten = ten;
    }

    public int getIdLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIdLoaiNguoiDung(int idLoaiNguoiDung) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
