/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMaiView {
    private String tenKhuyenMai;
    private int chietKhau;

    public HoaDonKhuyenMaiView() {
    }

    public HoaDonKhuyenMaiView(String tenKhuyenMai, int chietKhau) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.chietKhau = chietKhau;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }
    
    
}
