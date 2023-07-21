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

    private Date ngayThem;

    private Date ngaySua;
    
    private int soLanApDung ;
    
    private int chietKhau ;

    private int tinhTrang;

    public KhuyenMai() {
    }

    public KhuyenMai(String idKhuyenMai, String tenKhuyenMai, Date ngayThem, Date ngaySua, int soLanApDung, int chietKhau, int tinhTrang) {
        this.idKhuyenMai = idKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.soLanApDung = soLanApDung;
        this.chietKhau = chietKhau;
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

    public int getSoLanApDung() {
        return soLanApDung;
    }

    public void setSoLanApDung(int soLanApDung) {
        this.soLanApDung = soLanApDung;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}
