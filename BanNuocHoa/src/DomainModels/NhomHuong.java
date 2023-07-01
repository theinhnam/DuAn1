/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author theinhnam
 */
public class NhomHuong {

    private int idNhomHuong;

    private String tenNhomHuong;

    public NhomHuong() {
    }

    public NhomHuong(int idNhomHuong, String tenNhomHuong) {
        this.idNhomHuong = idNhomHuong;
        this.tenNhomHuong = tenNhomHuong;
    }

    public int getIdNhomHuong() {
        return idNhomHuong;
    }

    public void setIdNhomHuong(int idNhomHuong) {
        this.idNhomHuong = idNhomHuong;
    }

    public String getTenNhomHuong() {
        return tenNhomHuong;
    }

    public void setTenNhomHuong(String tenNhomHuong) {
        this.tenNhomHuong = tenNhomHuong;
    }

}
