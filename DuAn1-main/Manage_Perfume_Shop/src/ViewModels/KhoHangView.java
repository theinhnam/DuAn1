/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Duc Toan
 */
public class KhoHangView {
    private String tenSp;
    private String tenNhanHieu;
    private String tenNhomHuong;
    private String tenDanhMuc;
    private String tenXuatXu;
    private int dungTich;
    private int soLuongTrongKho;

    public KhoHangView() {
    }

    public KhoHangView(String tenSp, String tenNhanHieu, String tenNhomHuong, String tenDanhMuc, String tenXuatXu, int dungTich, int soLuongTrongKho) {
        this.tenSp = tenSp;
        this.tenNhanHieu = tenNhanHieu;
        this.tenNhomHuong = tenNhomHuong;
        this.tenDanhMuc = tenDanhMuc;
        this.tenXuatXu = tenXuatXu;
        this.dungTich = dungTich;
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenNhanHieu() {
        return tenNhanHieu;
    }

    public void setTenNhanHieu(String tenNhanHieu) {
        this.tenNhanHieu = tenNhanHieu;
    }

    public String getTenNhomHuong() {
        return tenNhomHuong;
    }

    public void setTenNhomHuong(String tenNhomHuong) {
        this.tenNhomHuong = tenNhomHuong;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
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
