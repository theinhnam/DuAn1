/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonNhap;
import DomainModels.HoaDonNhapChiTiet;

import DomainModels.SanPham;
import Repositories.NhatKyHoatDongRepo;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;

import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class INhatKyHoatDong implements NhatKyHoatDongService {

    NhatKyHoatDongRepo nhatKyHoatDongRepo = new NhatKyHoatDongRepo();

//    @Override
//    public List<NhatKyHoatDong_HoaDonView> getHoaDon() {
//        List<NhatKyHoatDong_HoaDonView> lstHoaDonView = new ArrayList<>();
//        List<HoaDon> lstHoaDon = nhatKyHoatDongRepo.getHoaDon();
//        for (int i = 0; i < lstHoaDon.size(); i++) {
//            NhatKyHoatDong_HoaDonView hoaDonView = new NhatKyHoatDong_HoaDonView();
//            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
//            hoaDonView.setEmail(nhatKyHoatDongRepo.getEmailById(lstHoaDon.get(i).getIdTaiKhoan()));
//            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
//            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
//            hoaDonView.setTinhTrang(lstHoaDon.get(i).getTinhTrang());
//            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
//            hoaDonView.setGhiChu(lstHoaDon.get(i).getGhiChu());
//            hoaDonView.setSdtKhachHang(nhatKyHoatDongRepo.getSdtKhachHang(lstHoaDon.get(i).getIdKhachHang()));
//            lstHoaDonView.add(hoaDonView);
//        }
//
//        return lstHoaDonView;
//    }
    
    @Override
    public List<NhatKyHoatDong_HoaDonView> getHoaDonById(String idHoaDon) {
        List<NhatKyHoatDong_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = nhatKyHoatDongRepo.getHoaDonById(idHoaDon);
        for (int i = 0; i < lstHoaDon.size(); i++) {
            NhatKyHoatDong_HoaDonView hoaDonView = new NhatKyHoatDong_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setEmail(nhatKyHoatDongRepo.getEmailById(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            hoaDonView.setTinhTrang(lstHoaDon.get(i).getTinhTrang());
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setGhiChu(lstHoaDon.get(i).getGhiChu());
            hoaDonView.setSdtKhachHang(nhatKyHoatDongRepo.getSdtKhachHang(lstHoaDon.get(i).getIdKhachHang()));
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
            hoaDonChiTietView.setDungTich(nhatKyHoatDongRepo.getDungTich(lstHoaDonChiTiet.get(i).getIdSanPham()));
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public List<String> getEmail() {
        return nhatKyHoatDongRepo.getEmail();
    }

    @Override
    public List<NhatKyHoatDong_HoaDonView> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start,int end) {
        List<NhatKyHoatDong_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = nhatKyHoatDongRepo.findHoaDon(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc, start, end);
        for (int i = 0; i < lstHoaDon.size(); i++) {
            NhatKyHoatDong_HoaDonView hoaDonView = new NhatKyHoatDong_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setEmail(nhatKyHoatDongRepo.getEmailById(lstHoaDon.get(i).getIdTaiKhoan()));
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

    @Override
    public List<String> getTenSpForCbo() {
        return nhatKyHoatDongRepo.getTenSpForCbo();
    }

    @Override
    public String getIdSanPham(String tenSanPham) {
        return nhatKyHoatDongRepo.getIdSp(tenSanPham);
    }

//    @Override
//    public List<NhatKyHoatDong_HoaDonNhapView> getHoaDonXuat() {
//        List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhapView = new ArrayList<>();
//        List<HoaDonNhap> lstHoaDonNhap = nhatKyHoatDongRepo.getHoaDonXuat();
//        for (int i = 0; i < lstHoaDonNhap.size(); i++) {
//            NhatKyHoatDong_HoaDonNhapView nhatKyHoatDong_HoaDonNhapView = new NhatKyHoatDong_HoaDonNhapView();
//            nhatKyHoatDong_HoaDonNhapView.setIdHoaDon(lstHoaDonNhap.get(i).getIdHoaDon());
//            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienCuaHang(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienCuaHang()));
//            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienKho(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienKho()));
//            nhatKyHoatDong_HoaDonNhapView.setGhiChu(lstHoaDonNhap.get(i).getGhiChu());
//            nhatKyHoatDong_HoaDonNhapView.setNgayThem(lstHoaDonNhap.get(i).getNgayThem());
//            nhatKyHoatDong_HoaDonNhapView.setTenHoaDon(lstHoaDonNhap.get(i).getTenHoaDon());
//            nhatKyHoatDong_HoaDonNhapView.setTinhTrang(convertTrangThaiToString(lstHoaDonNhap.get(i).getTrangThai()));
//            lstHoaDonNhapView.add(nhatKyHoatDong_HoaDonNhapView);
//        }
//        return lstHoaDonNhapView;
//    }

//    @Override
//    public List<NhatKyHoatDong_HoaDonNhapView> getHoaDonNhap() {
//        List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhapView = new ArrayList<>();
//        List<HoaDonNhap> lstHoaDonNhap = nhatKyHoatDongRepo.getHoaDonNhap();
//        for (int i = 0; i < lstHoaDonNhap.size(); i++) {
//            NhatKyHoatDong_HoaDonNhapView nhatKyHoatDong_HoaDonNhapView = new NhatKyHoatDong_HoaDonNhapView();
//            nhatKyHoatDong_HoaDonNhapView.setIdHoaDon(lstHoaDonNhap.get(i).getIdHoaDon());
//            nhatKyHoatDong_HoaDonNhapView.setTongTien(lstHoaDonNhap.get(i).getTongTien());
//            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienKho(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienKho()));
//            nhatKyHoatDong_HoaDonNhapView.setGhiChu(lstHoaDonNhap.get(i).getGhiChu());
//            nhatKyHoatDong_HoaDonNhapView.setNhaCungUng(lstHoaDonNhap.get(i).getNhaCungUng());
//            nhatKyHoatDong_HoaDonNhapView.setNgayThem(lstHoaDonNhap.get(i).getNgayThem());
//            nhatKyHoatDong_HoaDonNhapView.setTenHoaDon(lstHoaDonNhap.get(i).getTenHoaDon());
//            nhatKyHoatDong_HoaDonNhapView.setTinhTrang(convertTrangThaiToString(lstHoaDonNhap.get(i).getTrangThai()));
//            lstHoaDonNhapView.add(nhatKyHoatDong_HoaDonNhapView);
//        }
//        return lstHoaDonNhapView;
//    }

    @Override
    public String convertTrangThaiToString(int trangThai) {
        if (trangThai == 0 || trangThai == -1) {
            return "Đã hủy";
        } else if (trangThai == 1) {
            return "Đã nhập";
        } else if (trangThai == 2) {
            return "Đang xuất";
        } else if (trangThai == 3) {
            return "Xuất thành công";
        } else if (trangThai == 4) {
            return "Xuất thất bại";
        } else if (trangThai == 5) {
            return "Chờ nhập";
        } else {
            return "Chờ xuất";
        }
    }

    @Override
    public List<NhatKyHoatDong_HoaDonNhapView> findHoaDonNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start, int end) {
        List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhapView = new ArrayList<>();
        List<HoaDonNhap> lstHoaDonNhap = nhatKyHoatDongRepo.findHoaDonNhap(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc,start,end);
        for (int i = 0; i < lstHoaDonNhap.size(); i++) {
            NhatKyHoatDong_HoaDonNhapView nhatKyHoatDong_HoaDonNhapView = new NhatKyHoatDong_HoaDonNhapView();
            nhatKyHoatDong_HoaDonNhapView.setIdHoaDon(lstHoaDonNhap.get(i).getIdHoaDon());
            nhatKyHoatDong_HoaDonNhapView.setTongTien(lstHoaDonNhap.get(i).getTongTien());
            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienKho(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienKho()));
            nhatKyHoatDong_HoaDonNhapView.setGhiChu(lstHoaDonNhap.get(i).getGhiChu());
            nhatKyHoatDong_HoaDonNhapView.setNgayThem(lstHoaDonNhap.get(i).getNgayThem());
            nhatKyHoatDong_HoaDonNhapView.setTenHoaDon(lstHoaDonNhap.get(i).getTenHoaDon());
            nhatKyHoatDong_HoaDonNhapView.setNhaCungUng(lstHoaDonNhap.get(i).getNhaCungUng());
            nhatKyHoatDong_HoaDonNhapView.setTinhTrang(convertTrangThaiToString(lstHoaDonNhap.get(i).getTrangThai()));
            lstHoaDonNhapView.add(nhatKyHoatDong_HoaDonNhapView);
        }
        return lstHoaDonNhapView;
    }

    @Override
    public List<String> getEmailNhanVienKho() {
        return nhatKyHoatDongRepo.getEmailNhanVienKho();
    }

    @Override
    public List<NhatKyHoatDong_HoaDonNhapView> findHoaDonXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc,int start,int end) {
        List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhapView = new ArrayList<>();
        List<HoaDonNhap> lstHoaDonNhap = nhatKyHoatDongRepo.findHoaDonXuat(idNhanVienKho, idNhanVienCuaHang, trangThai, ngayBatDau, ngayKetThuc,start,end);
        for (int i = 0; i < lstHoaDonNhap.size(); i++) {
            NhatKyHoatDong_HoaDonNhapView nhatKyHoatDong_HoaDonNhapView = new NhatKyHoatDong_HoaDonNhapView();
            nhatKyHoatDong_HoaDonNhapView.setIdHoaDon(lstHoaDonNhap.get(i).getIdHoaDon());
            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienKho(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienKho()));
            nhatKyHoatDong_HoaDonNhapView.setEmailNhanVienCuaHang(nhatKyHoatDongRepo.getEmailById(lstHoaDonNhap.get(i).getIdNhanVienCuaHang()));
            nhatKyHoatDong_HoaDonNhapView.setGhiChu(lstHoaDonNhap.get(i).getGhiChu());
            nhatKyHoatDong_HoaDonNhapView.setNgayThem(lstHoaDonNhap.get(i).getNgayThem());
            nhatKyHoatDong_HoaDonNhapView.setTenHoaDon(lstHoaDonNhap.get(i).getTenHoaDon());
            nhatKyHoatDong_HoaDonNhapView.setTinhTrang(convertTrangThaiToString(lstHoaDonNhap.get(i).getTrangThai()));
            lstHoaDonNhapView.add(nhatKyHoatDong_HoaDonNhapView);
        }
        return lstHoaDonNhapView;
    }

    @Override
    public List<NhatKyHoatDong_HoaDonNhapChiTietView> getHoaDonChiTietXuat(String idHoaDon) {
        List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonChiTietNhapView = new ArrayList<>();
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = nhatKyHoatDongRepo.getHoaDonChiTietXuat(idHoaDon);
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            NhatKyHoatDong_HoaDonNhapChiTietView hoaDonNhapChiTietView = new NhatKyHoatDong_HoaDonNhapChiTietView();
            hoaDonNhapChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonNhapChiTietView.setDungTich(nhatKyHoatDongRepo.getDungTich(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonNhapChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            hoaDonNhapChiTietView.setSoLuongThucTe(lstHoaDonChiTiet.get(i).getSoLuongThucTe());
            hoaDonNhapChiTietView.setTenSanPham(nhatKyHoatDongRepo.getTenSp(lstHoaDonChiTiet.get(i).getIdSanPham()));
            lstHoaDonChiTietNhapView.add(hoaDonNhapChiTietView);
        }
        return lstHoaDonChiTietNhapView;
    }

    @Override
    public List<NhatKyHoatDong_HoaDonNhapChiTietView> getHoaDonChiTietNhap(String idHoaDon) {
        List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonChiTietNhapView = new ArrayList<>();
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = nhatKyHoatDongRepo.getHoaDonChiTietNhap(idHoaDon);
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            NhatKyHoatDong_HoaDonNhapChiTietView hoaDonNhapChiTietView = new NhatKyHoatDong_HoaDonNhapChiTietView();
            hoaDonNhapChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonNhapChiTietView.setDungTich(nhatKyHoatDongRepo.getDungTich(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonNhapChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            hoaDonNhapChiTietView.setTenSanPham(nhatKyHoatDongRepo.getTenSp(lstHoaDonChiTiet.get(i).getIdSanPham()));
            lstHoaDonChiTietNhapView.add(hoaDonNhapChiTietView);
        }
        return lstHoaDonChiTietNhapView;
    }

    @Override
    public int getSoDongHD(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        return  nhatKyHoatDongRepo.getSoDongHD(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc);
    }

    @Override
    public int getSoDongNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        return nhatKyHoatDongRepo.getSoDongNhap(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc);
    }

    @Override
    public int getSoDongXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc) {
        return nhatKyHoatDongRepo.getSoDongXuat(idNhanVienKho, idNhanVienCuaHang, trangThai, ngayBatDau, ngayKetThuc);
    }

}
