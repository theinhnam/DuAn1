/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public interface SanPhamService {
    public List<String> getDanhMuc ();
    public List<String> getNhomHuong ();
    public List<String> getNhanHieu ();
    public List<String> getXuatXu ();
    public String addSanPham (SanPham sanPham,String danhMuc,String nhomHuong,String nhanHieu,String xuatXu);
    public List<SanPham> getSanPham ();
    public String updateSanPham (SanPham sanPham,String danhMuc,String nhomHuong,String nhanHieu,String xuatXu);
    public String deleteSanPham (String idSanPham);
}
