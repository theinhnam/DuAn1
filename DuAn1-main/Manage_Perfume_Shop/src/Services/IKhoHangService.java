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
import Repositories.BanHangRepo;
import Repositories.KhoHangRepo;
import Ultilities.DBConnection;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.KhoHang_HoaDonChiTietView;
import ViewModels.KhoHang_HoaDonView;
import ViewModels.KhoHang_SanPhamView;
import ViewModels.SanPhamView;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class IKhoHangService implements KhoHangService {

    KhoHangRepo khoHangRepo = new KhoHangRepo();

//    @Override
//    public List<KhoHang_SanPhamView> getSanPham() {
//        List<KhoHang_SanPhamView> lstSpView = new ArrayList<>();
//        List<SanPham> lstSp = khoHangRepo.getSanPham();
//        for (int i = 0; i < lstSp.size(); i++) {
//            KhoHang_SanPhamView sanPhamView = new KhoHang_SanPhamView();
//            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
//            sanPhamView.setDungTich(lstSp.get(i).getKichThuoc());
//            sanPhamView.setTenSp(lstSp.get(i).getTenSanPham());
//            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTrongKho());
//            sanPhamView.setNhanHieu(khoHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
//            sanPhamView.setNhomHuong(khoHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
//            sanPhamView.setDanhMuc(khoHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setXuatXu(khoHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
//            lstSpView.add(sanPhamView);
//        }
//        return lstSpView;
//    }

    @Override
    public List<String> getDanhMuc() {
        return khoHangRepo.getDanhMuc();
    }

    @Override
    public List<String> getNhomHuong() {
        return khoHangRepo.getNhomHuong();
    }

    @Override
    public List<String> getNhanHieu() {
        return khoHangRepo.getNhanHieu();
    }

    @Override
    public List<String> getXuatXu() {
        return khoHangRepo.getXuatXu();
    }

    @Override
    public String nhap(KhoHang_HoaDonView khoHang_HoaDonView,String idNhanVien) {
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        hoaDonNhap.setGhiChu(khoHang_HoaDonView.getGhiChu());
        hoaDonNhap.setNhaCungUng(khoHang_HoaDonView.getNhaCungUng());
        hoaDonNhap.setIdHoaDon(khoHang_HoaDonView.getIdHoaDon());
        hoaDonNhap.setIdNhanVienKho(idNhanVien);
        if (khoHangRepo.nhap(hoaDonNhap)) {
            return "Thành công";
        }
        return "Thất bại";
    }
    
    @Override
    public String xuat(KhoHang_HoaDonView khoHang_HoaDonView,String idNhanVien) {
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        hoaDonNhap.setGhiChu(khoHang_HoaDonView.getGhiChu());
        hoaDonNhap.setIdHoaDon(khoHang_HoaDonView.getIdHoaDon());
hoaDonNhap.setIdNhanVienKho(idNhanVien);
        if (khoHangRepo.xuat(hoaDonNhap)) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String taoHoaDon(String idTaiKhoan,int trangThai) {
        if (khoHangRepo.taoHoaDOn(idTaiKhoan,trangThai)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public List<KhoHang_HoaDonView> getHoaDon(int trangThai) {
        List<KhoHang_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDonNhap> lstHoaDon = khoHangRepo.getHoaDon(trangThai);
        for (int i = 0; i < lstHoaDon.size(); i++) {
            KhoHang_HoaDonView hoaDonView = new KhoHang_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setNguoiThem(khoHangRepo.getEmail(lstHoaDon.get(i).getIdNhanVienKho()));
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            hoaDonView.setGhiChu(lstHoaDon.get(i).getGhiChu());
            lstHoaDonView.add(hoaDonView);
        }

        return lstHoaDonView;
    }

    @Override
    public int getSoLuongTon(String idSanPham) {
        return khoHangRepo.getSoLuongTon(idSanPham);
    }

    @Override
    public String getIDSanPham(String tenSanPham, int dungTich) {
        return khoHangRepo.getIDSanPham(tenSanPham,dungTich);
    }

    @Override
    public int getSoLuongFromHoaDonChiTiet(String idHoaDon, String idSanPham) {
        return khoHangRepo.getSoLuongFromHoaDonChiTiet(idHoaDon, idSanPham);
    }

    @Override
    public List<KhoHang_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<KhoHang_HoaDonChiTietView> lstHoaDonChiTietView = new ArrayList<>();
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = khoHangRepo.getHoaDonChiTietByIdHoaDon(idHoaDon);
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            KhoHang_HoaDonChiTietView hoaDonChiTietView = new KhoHang_HoaDonChiTietView();
            hoaDonChiTietView.setTenSp(khoHangRepo.getTenSanPham(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            hoaDonChiTietView.setDungTich(khoHangRepo.getDungTich(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonChiTietView.setSoLuongThucTe(lstHoaDonChiTiet.get(i).getSoLuongThucTe());
            hoaDonChiTietView.setEmailNv(khoHangRepo.getEmailNhanVienCuaHang(idHoaDon));
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public String updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham, int trangThai) {
        if (khoHangRepo.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham,trangThai)) {
            return "Thanh Cong";
        }
        return "That Bai";
    }
    
    @Override
    public String taoHoaDonChiTiet(KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView, String idHoaDon, int trangThai) {
        HoaDonNhapChiTiet hoaDonChiTiet = new HoaDonNhapChiTiet();
        hoaDonChiTiet.setIdSanPham(khoHangRepo.getIDSanPham(khoHang_HoaDonChiTietView.getTenSp(),khoHang_HoaDonChiTietView.getDungTich()));
        hoaDonChiTiet.setDonGia(khoHang_HoaDonChiTietView.getDonGia());
        hoaDonChiTiet.setSoLuong(khoHang_HoaDonChiTietView.getSoLuong());
        hoaDonChiTiet.setIdHoaDon(idHoaDon);
        
        if (khoHangRepo.taoHoaDonChiTiet(hoaDonChiTiet,trangThai)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String deleteHoaDonChiTiet(String tenSanPham, String idHoaDon, int soLuong, int trangThai, int dungTich) {
        if (khoHangRepo.deleteHoaDonChiTiet(khoHangRepo.getIDSanPham(tenSanPham,dungTich),idHoaDon,soLuong,trangThai)) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public ArrayList<KhoHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end) {

        ArrayList<KhoHang_SanPhamView> lstSpView = new ArrayList<>();
        ArrayList<SanPham> lstSp = khoHangRepo.findSanPham(danhMuc, nhanHieu, nhomHuong, xuatXu, start, end);
        for (int i = 0; i < lstSp.size(); i++) {
            KhoHang_SanPhamView sanPhamView = new KhoHang_SanPhamView();
            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
            sanPhamView.setTenSp(lstSp.get(i).getTenSanPham());
            sanPhamView.setNhanHieu(khoHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setNhomHuong(khoHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setDanhMuc(khoHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
            sanPhamView.setXuatXu(khoHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTrongKho());
            sanPhamView.setDungTich(lstSp.get(i).getKichThuoc());
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }

    @Override
    public String getIDDanhMuc(String tenDanhMuc) {
        return khoHangRepo.getIDDanhMuc(tenDanhMuc);
    }

    @Override
    public String getIDNhomHuong(String tenNhomHuong) {
        return khoHangRepo.getIDNhomHuong(tenNhomHuong);
    }

    @Override
    public String getIDNhanHieu(String tenNhanHieu) {
        return khoHangRepo.getIDNhanHieu(tenNhanHieu);
    }

    @Override
    public String getIDXuatXu(String tenXuatXu) {
        return khoHangRepo.getIDXuatXu(tenXuatXu);
    }

    @Override
    public boolean huy(List<KhoHang_HoaDonChiTietView> lsthoaDonNhapChiTietView, String idHoaDon,int trangThai) {
        List<HoaDonNhapChiTiet> lsthoaDonNhapChiTiet = new ArrayList<>();
        for (int i = 0; i < lsthoaDonNhapChiTietView.size(); i++) {
            HoaDonNhapChiTiet hoaDonNhapChiTiet = new HoaDonNhapChiTiet();
            hoaDonNhapChiTiet.setIdSanPham(khoHangRepo.getIDSanPham(lsthoaDonNhapChiTietView.get(i).getTenSp(),lsthoaDonNhapChiTietView.get(i).getDungTich()));
            hoaDonNhapChiTiet.setSoLuong(lsthoaDonNhapChiTietView.get(i).getSoLuong());
            lsthoaDonNhapChiTiet.add(hoaDonNhapChiTiet);
        }
        return khoHangRepo.huy(lsthoaDonNhapChiTiet,idHoaDon, trangThai);
    }

    @Override
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        return khoHangRepo.getSoDong(danhMuc, nhanHieu, nhomHuong, xuatXu);
    }
}
