/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhapSanPham;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.NhapSanPhamView;
import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public interface NhatKyHoatDongService {
    public List<NhapSanPhamView> getNhap();
    public List<NhapSanPhamView> getXuat();
    public List<String> getEmail();
    public String getIdTaiKhoan(String email);
    public List<NhatKyHoatDong_HoaDonView> getHoaDon();
    public List<NhatKyHoatDong_HoaDonView> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc);
    public List<NhatKyHoatDong_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon);
}
