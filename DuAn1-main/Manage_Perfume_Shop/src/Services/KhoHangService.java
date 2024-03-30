/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonNhapChiTiet;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.KhoHang_HoaDonChiTietView;
import ViewModels.KhoHang_HoaDonView;
import ViewModels.KhoHang_SanPhamView;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Duc Toan
 */
public interface KhoHangService {

//    public List<KhoHang_SanPhamView> getSanPham();

    public List<String> getDanhMuc();

    public List<String> getNhomHuong();

    public List<String> getNhanHieu();

    public List<String> getXuatXu();

    public String nhap(KhoHang_HoaDonView khoHang_HoaDonView,String idNhanVien);
    
    public String xuat(KhoHang_HoaDonView khoHang_HoaDonView, String idNhanVien);

    public String taoHoaDon(String idTaiKhoan,int trangThai);

    public List<KhoHang_HoaDonView> getHoaDon(int trangThai);

    public int getSoLuongTon(String idSanPham);

    public String getIDSanPham(String tenSanPham, int dungTich);

    public int getSoLuongFromHoaDonChiTiet(String idHoaDon, String idSanPham);

    public List<KhoHang_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon);

    public String updateHoaDonChiTiet(int soLuong,String idHoaDon, String idSanPham, int trangThai);

    public String taoHoaDonChiTiet(KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView, String idHoaDon, int trangThai);

    public String deleteHoaDonChiTiet(String tenSanPham, String idHoaDon, int soLuong, int trangThai, int dungTich);

    public String getIDDanhMuc(String tenDanhMuc);

    public String getIDNhomHuong(String tenNhomHuong);

    public String getIDNhanHieu(String tenNhanHieu);

    public String getIDXuatXu(String tenXuatXu);

    public boolean huy(List<KhoHang_HoaDonChiTietView> lsthoaDonNhapChiTietView,String idHoaDon,int trangThai);
    
    public ArrayList<KhoHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end);
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu);
}
