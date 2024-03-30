/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class ThongKeView {

    private String id;
    private String ten;
    private int dungTich;
    private int soLuongDaBan;
    private int soLuonTon;
    private int soLuongTrongKho;
    private BigDecimal doanhThu;
    private String idNhanHieu;
    private Date ngayThem;
    private int thang;

    public ThongKeView() {
    }

    public ThongKeView(String ten, int dungTich, int soLuongDaBan) {
        this.ten = ten;
        this.dungTich = dungTich;
        this.soLuongDaBan = soLuongDaBan;
    }

    public ThongKeView(String ten, int dungTich, int soLuonTon, int soLuongTrongKho) {
        this.ten = ten;
        this.dungTich = dungTich;
        this.soLuonTon = soLuonTon;
        this.soLuongTrongKho = soLuongTrongKho;
    }
    
    

    public ThongKeView(String id, String ten, int soLuongDaBan, int soLuonTon, BigDecimal doanhThu) {
        this.id = id;
        this.ten = ten;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuonTon = soLuonTon;
        this.doanhThu = doanhThu;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public int getSoLuonTon() {
        return soLuonTon;
    }

    public void setSoLuonTon(int soLuonTon) {
        this.soLuonTon = soLuonTon;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getIdNhanHieu() {
        return idNhanHieu;
    }

    public void setIdNhanHieu(String idNhanHieu) {
        this.idNhanHieu = idNhanHieu;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public int getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(int soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }
    
    

}
