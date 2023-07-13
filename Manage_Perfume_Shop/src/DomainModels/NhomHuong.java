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
public class NhomHuong {

    private String idNhomHuong;

    private String tenNhomHuong;

    private Date ngayThem;
    private Date ngaySua;
    private int trangThai;

    public NhomHuong() {
    }

    public NhomHuong(String idNhomHuong, String tenNhomHuong, Date ngayThem, Date ngaySua, int trangThai) {
        this.idNhomHuong = idNhomHuong;
        this.tenNhomHuong = tenNhomHuong;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }
    
    public NhomHuong(String idNhomHuong, String tenNhomHuong, int trangThai) {
        this.idNhomHuong = idNhomHuong;
        this.tenNhomHuong = tenNhomHuong;
        this.trangThai = trangThai;
    }

    public String getIdNhomHuong() {
        return idNhomHuong;
    }

    public void setIdNhomHuong(String idNhomHuong) {
        this.idNhomHuong = idNhomHuong;
    }

    public String getTenNhomHuong() {
        return tenNhomHuong;
    }

    public void setTenNhomHuong(String tenNhomHuong) {
        this.tenNhomHuong = tenNhomHuong;
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
