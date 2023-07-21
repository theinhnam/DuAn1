/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.NhapSanPham;
import DomainModels.SanPham;
import Repositories.NhatKyHoatDongRepo;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.NhapSanPhamView;
import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class INhatKyHoatDong implements NhatKyHoatDongService{
    NhatKyHoatDongRepo nhatKyHoatDongRepo = new NhatKyHoatDongRepo();
    @Override
    public List<NhapSanPhamView> getNhap() {
        List<NhapSanPhamView> lstNhapSanPhamView = new ArrayList<>();
        List<NhapSanPham> lstNhapSanPham = nhatKyHoatDongRepo.getNhap();
        for (int i = 0; i < lstNhapSanPham.size(); i++) {
            NhapSanPhamView nhapSanPhamView = new NhapSanPhamView();
            nhapSanPhamView.setemail(nhatKyHoatDongRepo.getEmailById(lstNhapSanPham.get(i).getIdTaiKhoan()));
             nhapSanPhamView.setTenSanPham(nhatKyHoatDongRepo.getTenSp(lstNhapSanPham.get(i).getIdSanPham()));
             nhapSanPhamView.setDonGia(lstNhapSanPham.get(i).getDonGia());
             nhapSanPhamView.setNgayThem(lstNhapSanPham.get(i).getNgayThem());
             nhapSanPhamView.setSoLuong(lstNhapSanPham.get(i).getSoLuong());
             nhapSanPhamView.setTrangThai(lstNhapSanPham.get(i).getTrangThai());
            lstNhapSanPhamView.add(nhapSanPhamView);
        }
        return lstNhapSanPhamView;
    }

    @Override
    public List<NhapSanPhamView> getXuat() {
        List<NhapSanPhamView> lstNhapSanPhamView = new ArrayList<>();
        List<NhapSanPham> lstNhapSanPham = nhatKyHoatDongRepo.getXuat();
        for (int i = 0; i < lstNhapSanPham.size(); i++) {
            NhapSanPhamView nhapSanPhamView = new NhapSanPhamView();
            nhapSanPhamView.setemail(nhatKyHoatDongRepo.getEmailById(lstNhapSanPham.get(i).getIdTaiKhoan()));
             nhapSanPhamView.setTenSanPham(nhatKyHoatDongRepo.getTenSp(lstNhapSanPham.get(i).getIdSanPham()));
             nhapSanPhamView.setDonGia(lstNhapSanPham.get(i).getDonGia());
             nhapSanPhamView.setNgayThem(lstNhapSanPham.get(i).getNgayThem());
             nhapSanPhamView.setSoLuong(lstNhapSanPham.get(i).getSoLuong());
             nhapSanPhamView.setTrangThai(lstNhapSanPham.get(i).getTrangThai());
            lstNhapSanPhamView.add(nhapSanPhamView);
        }
        return lstNhapSanPhamView;
    }

    @Override
    public List<NhatKyHoatDong_HoaDonView> getHoaDon() {
        List<NhatKyHoatDong_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = nhatKyHoatDongRepo.getHoaDon();
        for (int i = 0; i < lstHoaDon.size(); i++) {
            NhatKyHoatDong_HoaDonView hoaDonView = new NhatKyHoatDong_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setEmail(nhatKyHoatDongRepo.getEmailById(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setStt(lstHoaDon.get(i).getStt());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            hoaDonView.setTinhTrang(lstHoaDon.get(i).getTinhTrang());
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setGhiChu(lstHoaDon.get(i).getGhiChu());
            lstHoaDonView.add(hoaDonView);
        }

        return lstHoaDonView;
    }

    @Override
    public List<NhatKyHoatDong_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<NhatKyHoatDong_HoaDonChiTietView> lstHoaDonChiTietView = new ArrayList<>();
        List<HoaDonChiTiet> lstHoaDonChiTiet = nhatKyHoatDongRepo.getHoaDonChiTietByIdHoaDon(idHoaDon);
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            NhatKyHoatDong_HoaDonChiTietView hoaDonChiTietView = new NhatKyHoatDong_HoaDonChiTietView();
            hoaDonChiTietView.setTenSanPham(nhatKyHoatDongRepo.getTenSp(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            hoaDonChiTietView.setIdHoaDon(lstHoaDonChiTiet.get(i).getIdHoaDon());
            hoaDonChiTietView.setTrangThai(lstHoaDonChiTiet.get(i).getTrangThai());
            hoaDonChiTietView.setNgayThem(lstHoaDonChiTiet.get(i).getNgayThem());
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public List<String> getEmail() {
        return nhatKyHoatDongRepo.getEmail();
    }

    @Override
    public List<NhatKyHoatDong_HoaDonView> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        List<NhatKyHoatDong_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = nhatKyHoatDongRepo.findHoaDon(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc);
        for (int i = 0; i < lstHoaDon.size(); i++) {
            NhatKyHoatDong_HoaDonView hoaDonView = new NhatKyHoatDong_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setEmail(nhatKyHoatDongRepo.getEmailById(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setStt(lstHoaDon.get(i).getStt());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            hoaDonView.setTinhTrang(lstHoaDon.get(i).getTinhTrang());
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setGhiChu(lstHoaDon.get(i).getGhiChu());
            lstHoaDonView.add(hoaDonView);
        }

        return lstHoaDonView;
    }

    @Override
    public String getIdTaiKhoan(String email) {
        return nhatKyHoatDongRepo.getIdTaiKhoanByEmail(email);
    }
    
}
