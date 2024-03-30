/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.SanPhamView;
import java.math.BigDecimal;
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
    ArrayList<SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu,int start,int end);
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu);
    String getIDDanhMuc(String tenDanhMuc);
    String getIDNhomHuong(String tenNhomHuong);
    String getIDNhanHieu(String tenNhanHieu);
    String getIDXuatXu(String tenXuatXu);
//    public List<SanPhamView> getSanPham ();
    public List<SanPhamView> getSanPhamByIndex (int index);
    public void setDanhMucNone (String idDanhMuc); 
    public void setNhanHieuNone (String idNhanHieu); 
    public void setNhomHuongNone (String idNhomHuong); 
    public void setXuatXuNone (String idXuatXu);
    public boolean checkDanhMuc(String danhMuc);
    public boolean checkNhomHuong(String nhomHuong);
    public boolean checkXuatXu(String xuatXu);
    public boolean checkNhanHieu(String nhanHieu);
    public boolean checkProduct(String tenSanPham, int kichThuoc);
    public String getImageUrl (String idSanPham);
    public BigDecimal getGiaGiam (String idSanPham);
    public String getNgayThem (String idSanPham);
    public String getIDSanPham(String tenSanPham, int dungTich);
    public boolean checkNoneDanhMuc(String tenDanhMuc);
   
    //Nam code-------------------------------------------------------------------------------
    public String updateSoLuongTon(SanPhamView spv);
}
