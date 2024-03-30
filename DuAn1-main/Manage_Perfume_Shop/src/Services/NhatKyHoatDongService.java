/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public interface NhatKyHoatDongService {

    public List<String> getEmail();
    public List<String> getEmailNhanVienKho();
    public List<String> getTenSpForCbo();
    public String getIdTaiKhoan(String email);
    public String getIdSanPham(String tenSanPham);
//    public List<NhatKyHoatDong_HoaDonView> getHoaDon();
    public List<NhatKyHoatDong_HoaDonView> getHoaDonById(String idHoaDon);
    public List<NhatKyHoatDong_HoaDonView> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start,int end);
    public int getSoDongHD(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc);
    public List<NhatKyHoatDong_HoaDonNhapView> findHoaDonNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start, int end);
    public int getSoDongNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc);
    public List<NhatKyHoatDong_HoaDonNhapView> findHoaDonXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc, int start,int end);
    public int getSoDongXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc);
    
    public List<NhatKyHoatDong_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon);
    public List<NhatKyHoatDong_HoaDonNhapChiTietView> getHoaDonChiTietXuat(String idHoaDon);
    public List<NhatKyHoatDong_HoaDonNhapChiTietView> getHoaDonChiTietNhap(String idHoaDon);
//    public List<NhatKyHoatDong_HoaDonNhapView> getHoaDonXuat();
//    public List<NhatKyHoatDong_HoaDonNhapView> getHoaDonNhap();
    public String convertTrangThaiToString(int trangThai);
    
}
