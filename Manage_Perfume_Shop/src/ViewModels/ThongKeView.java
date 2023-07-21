/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ThongKeView {
    private String id;
    private String ten;
    private int soLuongDaBan;
    private int soLuonTon;
    private BigDecimal doanhThu;

    public ThongKeView() {
    }

    public ThongKeView(String id, String ten, int soLuongDaBan, int soLuonTon, BigDecimal doanhThu) {
        this.id = id;
        this.ten = ten;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuonTon = soLuonTon;
        this.doanhThu = doanhThu;
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

    

    
    
    
}
