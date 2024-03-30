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
public class XuatXu {

    private String idXuatXu;
    private String ten;
    private Date ngayThem;
    private Date ngaySua;
    private int trangThai;

    public XuatXu() {
    }

    public XuatXu(String idXuatXu, String ten, Date ngayThem, Date ngaySua, int trangThai) {
        this.idXuatXu = idXuatXu;
        this.ten = ten;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }
    
    public XuatXu(String idXuatXu, String ten, int trangThai) {
        this.idXuatXu = idXuatXu;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(String idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
