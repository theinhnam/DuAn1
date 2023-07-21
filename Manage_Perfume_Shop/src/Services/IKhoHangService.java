/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhapSanPham;
import DomainModels.SanPham;
import Repositories.KhoHangRepo;
import ViewModels.NhapSanPhamView;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class IKhoHangService implements KhoHangService {
    
    KhoHangRepo khoHangRepo = new KhoHangRepo();
    
    @Override
    public List<SanPhamView> getSp() {
        List<SanPhamView> lstSpView = new ArrayList<>();
        List<SanPham> lstSp = khoHangRepo.getSanPham();
        for (int i = 0; i < lstSp.size(); i++) {
            SanPhamView sanPhamView = new SanPhamView();
            sanPhamView.setTenDanhMuc(khoHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setTenKhuyenMai(sanPhamRepo.getTenKhuyenMai(lstSp.get(i).getIdKhuyenMai()));
            sanPhamView.setTenNhanHieu(khoHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setTenNhomHuong(khoHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setTenXuatxu(khoHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            sanPhamView.setChietKhau(lstSp.get(i).getChietKhau());
            sanPhamView.setGiaGiam(lstSp.get(i).getGiaGiam());
            sanPhamView.setGiaGoc(lstSp.get(i).getGiaGoc());
            sanPhamView.setIdSanPham(lstSp.get(i).getIdSanPham());
            sanPhamView.setImageUrl(lstSp.get(i).getImageUrl());
            sanPhamView.setKichThuoc(lstSp.get(i).getKichThuoc());
            sanPhamView.setMoTa(lstSp.get(i).getMoTa());
            sanPhamView.setNgaySua(lstSp.get(i).getNgaySua());
            sanPhamView.setNgayThem(lstSp.get(i).getNgayThem());
            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTon());
            sanPhamView.setTenSanPham(lstSp.get(i).getTenSanPham());
            sanPhamView.setTinhTrang(lstSp.get(i).getTinhTrang());
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }
    
    
    @Override
    public String nhap(NhapSanPhamView nhapSanPhamView) {
        NhapSanPham nhapSanPham = new NhapSanPham();
        nhapSanPham.setIdSanPham(khoHangRepo.getIDSanPham(nhapSanPhamView.getTenSanPham()));
        nhapSanPham.setDonGia(nhapSanPhamView.getDonGia());
        nhapSanPham.setSoLuong(nhapSanPhamView.getSoLuong());
        nhapSanPham.setTrangThai(nhapSanPhamView.getTrangThai());
        nhapSanPham.setIdTaiKhoan(khoHangRepo.getIDTaiKhoan(nhapSanPhamView.getemail()));
        if (khoHangRepo.nhap(nhapSanPham)) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public String xuat(NhapSanPhamView nhapSanPhamView) {
        NhapSanPham nhapSanPham = new NhapSanPham();
        nhapSanPham.setIdSanPham(khoHangRepo.getIDSanPham(nhapSanPhamView.getTenSanPham()));
        nhapSanPham.setDonGia(nhapSanPhamView.getDonGia());
        nhapSanPham.setSoLuong(nhapSanPhamView.getSoLuong());
        nhapSanPham.setTrangThai(nhapSanPhamView.getTrangThai());
        nhapSanPham.setIdTaiKhoan(khoHangRepo.getIDTaiKhoan(nhapSanPhamView.getemail()));
        if (khoHangRepo.xuat(nhapSanPham)) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public List<SanPhamView> findSp(String tenSp) {
        List<SanPhamView> lstSpView = new ArrayList<>();
        List<SanPham> lstSp = khoHangRepo.findSanPham(tenSp);
        for (int i = 0; i < lstSp.size(); i++) {
            SanPhamView sanPhamView = new SanPhamView();
            sanPhamView.setTenDanhMuc(khoHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setTenKhuyenMai(sanPhamRepo.getTenKhuyenMai(lstSp.get(i).getIdKhuyenMai()));
            sanPhamView.setTenNhanHieu(khoHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setTenNhomHuong(khoHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setTenXuatxu(khoHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            sanPhamView.setChietKhau(lstSp.get(i).getChietKhau());
            sanPhamView.setGiaGiam(lstSp.get(i).getGiaGiam());
            sanPhamView.setGiaGoc(lstSp.get(i).getGiaGoc());
            sanPhamView.setIdSanPham(lstSp.get(i).getIdSanPham());
            sanPhamView.setImageUrl(lstSp.get(i).getImageUrl());
            sanPhamView.setKichThuoc(lstSp.get(i).getKichThuoc());
            sanPhamView.setMoTa(lstSp.get(i).getMoTa());
            sanPhamView.setNgaySua(lstSp.get(i).getNgaySua());
            sanPhamView.setNgayThem(lstSp.get(i).getNgayThem());
            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTon());
            sanPhamView.setTenSanPham(lstSp.get(i).getTenSanPham());
            sanPhamView.setTinhTrang(lstSp.get(i).getTinhTrang());
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }
    
}
