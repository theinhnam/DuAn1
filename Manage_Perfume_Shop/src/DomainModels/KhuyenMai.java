/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.sql.Date;

/**
 *
 * @author theinhnam
 */
public class KhuyenMai {

    private String idKhuyenMai;

    private String tenKhuyenMai;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private int tinhTrang;

    public KhuyenMai() {
    }

    public KhuyenMai(String idKhuyenMai, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, int tinhTrang) {
        this.idKhuyenMai = idKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhTrang = tinhTrang;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
