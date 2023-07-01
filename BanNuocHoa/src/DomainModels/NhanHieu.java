/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author theinhnam
 */
public class NhanHieu {

    private int idNhanHieu;

    private String tenNhanHieu;

    public NhanHieu() {
    }

    public NhanHieu(int idNhanHieu, String tenNhanHieu) {
        this.idNhanHieu = idNhanHieu;
        this.tenNhanHieu = tenNhanHieu;
    }

    public int getIdNhanHieu() {
        return idNhanHieu;
    }

    public void setIdNhanHieu(int idNhanHieu) {
        this.idNhanHieu = idNhanHieu;
    }

    public String getTenNhanHieu() {
        return tenNhanHieu;
    }

    public void setTenNhanHieu(String tenNhanHieu) {
        this.tenNhanHieu = tenNhanHieu;
    }

}
