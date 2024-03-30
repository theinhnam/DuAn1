/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.KhuyenMai;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Duc Toan
 */
public interface BanHangService {
    public String taoHoaDon (String idTaiKhoan);
    public String taoHoaDonChiTiet (BanHang_HoaDonChiTietView banHang_HoaDonChiTietView, String idHoaDon);
    public String deleteHoaDonChiTiet(String tenSanPham, String idHoaDon, int dungTich);
//    public List<BanHang_SanPhamView> getSanPham (int start, int end);
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu);
    public List<String> getDanhMuc ();
    public List<String> getNhomHuong ();
    public List<String> getNhanHieu ();
    public List<String> getXuatXu ();
    public ArrayList<BanHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end);
    public String getIDDanhMuc(String tenDanhMuc);
    public String getIDNhomHuong(String tenNhomHuong);
    public String getIDNhanHieu(String tenNhanHieu);
    public String getIDXuatXu(String tenXuatXu);
    public String getIDSanPham(String tenSanPham, int dungTich);

    public List<BanHang_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon);
    public List<BanHang_HoaDonView> getHoaDonDaThanhToan (String idTaiKhoan);
    public List<BanHang_HoaDonView> getHoaDon ();
    public int getSoLuongTon (String idSanPham);
    public String updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham);
    Date getNgayThem(String idHoaDon);
    BigDecimal getTongTien(String idHoaDon);
    public int getSoLuongFromHoaDonChiTiet(String idHoaDon,String idSanPham);
    String getKHByPhone(String phoneNumber);
    public String getIdKhacHang(String sdt);
    //nam code---------------------------------------------------------------------------------------------
    public String update(BanHang_HoaDonView bhhd);
    public String updateKhuyenMai(BanHang_HoaDonView bhhd);
    String getTenByIDNV(String idNV);
    ArrayList<KhuyenMai> getTTKM(String idHoaDon);
    
    
    
     
}
