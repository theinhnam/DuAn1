/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.SanPhamView;
import java.util.ArrayList;
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
    public String addSanPham (SanPhamView sanPhamView);
    public String updateSanPham (SanPhamView sanPhamView);
    public String deleteSanPham (String idSanPham);
    ArrayList<SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu);
    String getIDDanhMuc(String tenDanhMuc);
    String getIDNhomHuong(String tenNhomHuong);
    String getIDNhanHieu(String tenNhanHieu);
    String getIDXuatXu(String tenXuatXu);
    public List<SanPhamView> getSanPham ();
    public void setDanhMucNone (String idDanhMuc); 
    public void setNhanHieuNone (String idNhanHieu); 
    public void setNhomHuongNone (String idNhomHuong); 
    public void setXuatXuNone (String idXuatXu);
    public boolean checkDanhMuc(String danhMuc);
    public boolean checkNhomHuong(String nhomHuong);
    public boolean checkXuatXu(String xuatXu);
    public boolean checkNhanHieu(String nhanHieu);
    
    //Nam code-------------------------------------------------------------------------------
    public String updateSoLuongTon(SanPhamView spv);
}
