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
public class NhanHieu {

    private String idNhanHieu;

    private String tenNhanHieu;

    private Date ngayThem;
    private Date ngaySua;
    private int trangThai;

    public NhanHieu() {
    }

    public NhanHieu(String idNhanHieu, String tenNhanHieu, Date ngayThem, Date ngaySua, int trangThai) {
        this.idNhanHieu = idNhanHieu;
        this.tenNhanHieu = tenNhanHieu;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }
    
    public NhanHieu(String idNhanHieu, String tenNhanHieu, int trangThai) {
        this.idNhanHieu = idNhanHieu;
        this.tenNhanHieu = tenNhanHieu;
        this.trangThai = trangThai;
    }

    public String getIdNhanHieu() {
        return idNhanHieu;
    }

    public void setIdNhanHieu(String idNhanHieu) {
        this.idNhanHieu = idNhanHieu;
    }

    public String getTenNhanHieu() {
        return tenNhanHieu;
    }

    public void setTenNhanHieu(String tenNhanHieu) {
        this.tenNhanHieu = tenNhanHieu;
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
