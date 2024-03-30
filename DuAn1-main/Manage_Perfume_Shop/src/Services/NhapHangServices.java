/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonNhapChiTiet;
import ViewModels.HoaDonNhapHangChiTietView;
import ViewModels.HoaDonNhapHangViews;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foxin
 */
public interface NhapHangServices {
    ArrayList<HoaDonNhapHangViews> findAll();
    ArrayList<HoaDonNhapHangChiTietView> getHDCT(String idHoaDon);
    String getID(String tenSanPham, int kichThuoc);
    String update(String idHoaDon, String idSanPham, int soLuongThucTe);
    String updateHD(String ghiChu, String idHoaDon, String idNhanVien);
    String updateHDFailed(String ghiChu, String idHoaDon, String idNhanVien);
    public ArrayList<SanPhamView> getSoLuongTon();
    public String updateSoLuongTon(List<HoaDonNhapHangChiTietView> lsthoaDonNhapHangChiTietView);
}
