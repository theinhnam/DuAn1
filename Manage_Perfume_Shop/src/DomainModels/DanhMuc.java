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
public class DanhMuc {
    private String idDanhMuc;
    
    private String tenDanhMuc;
    private Date ngayThem;
    private Date ngaySua;
    private int trangThai;

    public DanhMuc() {
    }

    public DanhMuc(String idDanhMuc, String tenDanhMuc, Date ngayThem, Date ngaySua, int trangThai) {
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
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
