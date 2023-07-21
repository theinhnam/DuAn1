/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMai {
    private String ifKhuyenMai;
    private String idHoaDon;

    public HoaDonKhuyenMai() {
    }

    public HoaDonKhuyenMai(String ifKhuyenMai, String idHoaDon) {
        this.ifKhuyenMai = ifKhuyenMai;
        this.idHoaDon = idHoaDon;
    }

    public String getIfKhuyenMai() {
        return ifKhuyenMai;
    }

    public void setIfKhuyenMai(String ifKhuyenMai) {
        this.ifKhuyenMai = ifKhuyenMai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    
}
