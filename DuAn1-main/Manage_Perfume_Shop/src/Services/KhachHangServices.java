/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.HoaDonKhachHangView;
import ViewModels.QLKhachHang;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public interface KhachHangServices {
//    ArrayList<QLKhachHang> findAll();
    
    String save(QLKhachHang qLKhachHang);
    
    String update(QLKhachHang qLKhachHang);
    
    String delete(QLKhachHang qLKhachHang);
    
    ArrayList<QLKhachHang> search(String name, int start, int end);
    public int getSoDong(String name);
    
    ArrayList<HoaDonKhachHangView> getHoaDonKH(String idKhachHang, int start, int end);
    public int getSoDongHD(String idKhachHang);
    public QLKhachHang updateTTKH(QLKhachHang qlkh);
    public QLKhachHang insertKHNew(QLKhachHang qlkh);
    boolean checkSDTMatch(String soDienThoai);
    
}
