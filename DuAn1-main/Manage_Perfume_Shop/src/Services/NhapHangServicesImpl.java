/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonNhap;
import DomainModels.HoaDonNhapChiTiet;
import DomainModels.SanPham;
import Repositories.NhapHangRepository;
import ViewModels.HoaDonNhapHangChiTietView;
import ViewModels.HoaDonNhapHangViews;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foxin
 */
public class NhapHangServicesImpl implements NhapHangServices {

    NhapHangRepository nhapHangRepo = new NhapHangRepository();

    @Override
    public ArrayList<HoaDonNhapHangViews> findAll() {
        ArrayList<HoaDonNhapHangViews> listHDViews = new ArrayList<>();
        ArrayList<HoaDonNhap> listHD = nhapHangRepo.findAll();
        for (HoaDonNhap hoaDonNhap : listHD) {
            HoaDonNhapHangViews hoaDonNhapHangViews = new HoaDonNhapHangViews();
            hoaDonNhapHangViews.setIdHoaDon(hoaDonNhap.getIdHoaDon());
            hoaDonNhapHangViews.setNhanVienKho(nhapHangRepo.getTenNhanVienKho(hoaDonNhap.getIdNhanVienKho()));
            hoaDonNhapHangViews.setNgayThem(hoaDonNhap.getNgayThem());
            hoaDonNhapHangViews.setNhaCungUng(hoaDonNhap.getNhaCungUng());
            hoaDonNhapHangViews.setTenHoaDon(hoaDonNhap.getTenHoaDon());
            hoaDonNhapHangViews.setTongTien(hoaDonNhap.getTongTien());
            listHDViews.add(hoaDonNhapHangViews);
        }
        return listHDViews;
    }

    @Override
    public ArrayList<HoaDonNhapHangChiTietView> getHDCT(String idHoaDon) {
        ArrayList<HoaDonNhapHangChiTietView> listHDViews = new ArrayList<>();
        ArrayList<HoaDonNhapChiTiet> listHD = nhapHangRepo.getHDCT(idHoaDon);
        for (HoaDonNhapChiTiet hoaDonNhap : listHD) {
            SanPham sanPham = nhapHangRepo.getTenSanPham(hoaDonNhap.getIdSanPham());
            HoaDonNhapHangChiTietView hoaDonNhapHangViews = new HoaDonNhapHangChiTietView();
            hoaDonNhapHangViews.setTenSanPham(sanPham.getTenSanPham());
            hoaDonNhapHangViews.setKichThuoc(sanPham.getKichThuoc());
            hoaDonNhapHangViews.setSoLuong(hoaDonNhap.getSoLuong());
            hoaDonNhapHangViews.setSoLuongThucTe(hoaDonNhap.getSoLuongThucTe());
            hoaDonNhapHangViews.setSoLuongThucTe(hoaDonNhap.getSoLuongThucTe());
            listHDViews.add(hoaDonNhapHangViews);
        }
        return listHDViews;
    }

    @Override
    public String getID(String tenSanPham, int kichThuoc) {
        return nhapHangRepo.getID(tenSanPham, kichThuoc);
    }

    @Override
    public String update(String idHoaDon, String idSanPham, int soLuongThucTe) {
        if (nhapHangRepo.update(idSanPham, idHoaDon, soLuongThucTe)) {
            return "Xác nhận thành công";
        } else {
            return "Xác nhận thất bại";
        }
    }

    @Override
    public String updateHD(String ghiChu, String idHoaDon, String idNhanVien) {
        if (nhapHangRepo.updateHoaDon(ghiChu, idHoaDon,idNhanVien)) {
            return "Hoàn thành xác nhận đơn nhập hàng thành công";
        } else {
            return "Hoàn thành xác nhận đơn nhập hàng chưa thành công";
        }
    }

    @Override
    public ArrayList<SanPhamView> getSoLuongTon() {
        ArrayList<SanPhamView> listSPV = new ArrayList<>();
        ArrayList<SanPham> listSP = nhapHangRepo.getSoLuongTon();
        for (SanPham sanPham : listSP) {
            SanPhamView sp = new SanPhamView();
            sp.setIdSanPham(sanPham.getIdSanPham());
            sp.setTenSanPham(sanPham.getTenSanPham());
            sp.setKichThuoc(sanPham.getKichThuoc());
            sp.setSoLuongTon(sanPham.getSoLuongTon());
            listSPV.add(sp);
        }
        return listSPV;
    }

    @Override
    public String updateSoLuongTon(List<HoaDonNhapHangChiTietView> lsthoaDonNhapHangChiTietView) {
        List<HoaDonNhapChiTiet> lstHoaDonNhapChiTiet = new ArrayList<>();
        for (int i = 0; i < lsthoaDonNhapHangChiTietView.size(); i++) {
            HoaDonNhapChiTiet hoaDonNhapChiTiet = new HoaDonNhapChiTiet();
            hoaDonNhapChiTiet.setIdSanPham(nhapHangRepo.getID(lsthoaDonNhapHangChiTietView.get(i).getTenSanPham(), lsthoaDonNhapHangChiTietView.get(i).getKichThuoc()));
            hoaDonNhapChiTiet.setSoLuongThucTe(lsthoaDonNhapHangChiTietView.get(i).getSoLuongThucTe());
            lstHoaDonNhapChiTiet.add(hoaDonNhapChiTiet);
        }
        if (nhapHangRepo.updateSoLuongTon(lstHoaDonNhapChiTiet)) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String updateHDFailed(String ghiChu, String idHoaDon, String idNhanVien) {
        if (nhapHangRepo.updateHoaDonFailed(ghiChu, idHoaDon,idNhanVien)) {
            return "Hoàn thành xác nhận đơn nhập hàng thành công";
        } else {
            return "Hoàn thành xác nhận đơn nhập hàng chưa thành công";
        }
    }

}
