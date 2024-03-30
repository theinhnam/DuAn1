/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhuyenMai;
import DomainModels.SanPham;
import Repositories.BanHangRepo;
import Ultilities.DBConnection;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
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
public class IBanHangService implements BanHangService {

    BanHangRepo banHangRepo = new BanHangRepo();

    @Override
    public String taoHoaDon(String idTaiKhoan) {
        if (banHangRepo.taoHoaDOn(idTaiKhoan)) {
            return "Thành công";
        }
        return "Thất bại";
    }

//    @Override
//    public List<BanHang_SanPhamView> getSanPham(int start, int end) {
//        List<BanHang_SanPhamView> lstSpView = new ArrayList<>();
//        List<SanPham> lstSp = banHangRepo.getSanPham(start,end);
//        for (int i = 0; i < lstSp.size(); i++) {
//            BanHang_SanPhamView sanPhamView = new BanHang_SanPhamView();
//            sanPhamView.setDungTich(lstSp.get(i).getKichThuoc());
//            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
//            sanPhamView.setTenSp(lstSp.get(i).getTenSanPham());
//            sanPhamView.setNhanHieu(banHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
//            sanPhamView.setNhomHuong(banHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
//            sanPhamView.setDanhMuc(banHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setXuatXu(banHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
//            lstSpView.add(sanPhamView);
//        }
//        return lstSpView;
//    }
    
    @Override
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        return banHangRepo.getSoDong(danhMuc, nhanHieu, nhomHuong, xuatXu);
    }

    @Override
    public List<String> getDanhMuc() {
        return banHangRepo.getDanhMuc();
    }

    @Override
    public List<String> getNhomHuong() {
        return banHangRepo.getNhomHuong();
    }

    @Override
    public List<String> getNhanHieu() {
        return banHangRepo.getNhanHieu();
    }

    @Override
    public List<String> getXuatXu() {
        return banHangRepo.getXuatXu();
    }

    @Override
    public ArrayList<BanHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end) {

        ArrayList<BanHang_SanPhamView> lstSpView = new ArrayList<>();
        ArrayList<SanPham> lstSp = banHangRepo.findSanPham(danhMuc, nhanHieu, nhomHuong, xuatXu, start, end);
        for (int i = 0; i < lstSp.size(); i++) {
            BanHang_SanPhamView sanPhamView = new BanHang_SanPhamView();
            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
            sanPhamView.setDungTich(lstSp.get(i).getKichThuoc());
            sanPhamView.setTenSp(lstSp.get(i).getTenSanPham());
            sanPhamView.setNhanHieu(banHangRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setNhomHuong(banHangRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setDanhMuc(banHangRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
            sanPhamView.setXuatXu(banHangRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }

    @Override
    public String getIDDanhMuc(String tenDanhMuc) {
        return banHangRepo.getIDDanhMuc(tenDanhMuc);
    }

    @Override
    public String getIDNhomHuong(String tenNhomHuong) {
        return banHangRepo.getIDNhomHuong(tenNhomHuong);
    }

    @Override
    public String getIDNhanHieu(String tenNhanHieu) {
        return banHangRepo.getIDNhanHieu(tenNhanHieu);
    }

    @Override
    public String getIDXuatXu(String tenXuatXu) {
        return banHangRepo.getIDXuatXu(tenXuatXu);
    }

    @Override
    public String taoHoaDonChiTiet(BanHang_HoaDonChiTietView banHang_HoaDonChiTietView, String idHoaDon) {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setIdSanPham(banHangRepo.getIDSanPham(banHang_HoaDonChiTietView.getTenSp(), banHang_HoaDonChiTietView.getDungTich()));
        hoaDonChiTiet.setDonGia(banHang_HoaDonChiTietView.getDonGia());
        hoaDonChiTiet.setSoLuong(banHang_HoaDonChiTietView.getSoLuong());
        hoaDonChiTiet.setIdHoaDon(idHoaDon);
        if (banHangRepo.taoHoaDonChiTiet(hoaDonChiTiet,idHoaDon)) {
            return "Thành công";
        }
        return "Thất bại";
    }

    

    @Override
    public String deleteHoaDonChiTiet(String tenSanPham, String idHoaDon, int dungTich) {
        if (banHangRepo.deleteHoaDonChiTiet(banHangRepo.getIDSanPham(tenSanPham,dungTich),idHoaDon)) {
            return "Thành công";
        }
        return "Thất bại";
        
    }

    @Override
    public List<BanHang_HoaDonView> getHoaDon() {
        List<BanHang_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = banHangRepo.getHoaDon();
        for (int i = 0; i < lstHoaDon.size(); i++) {
            BanHang_HoaDonView hoaDonView = new BanHang_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setNguoiThem(banHangRepo.getEmail(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            lstHoaDonView.add(hoaDonView);
        }

        return lstHoaDonView;
    }

    @Override
    public List<BanHang_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView = new ArrayList<>();
        List<HoaDonChiTiet> lstHoaDonChiTiet = banHangRepo.getHoaDonChiTietByIdHoaDon(idHoaDon);
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            BanHang_HoaDonChiTietView hoaDonChiTietView = new BanHang_HoaDonChiTietView();
            hoaDonChiTietView.setTenSp(banHangRepo.getTenSanPham(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            hoaDonChiTietView.setDungTich(banHangRepo.getDungTich(lstHoaDonChiTiet.get(i).getIdSanPham()));
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public String update(BanHang_HoaDonView bhhd) {
        if(banHangRepo.updateHoaDon(new HoaDon(bhhd.getIdHoaDon(), null, null, bhhd.getTongTien(), bhhd.getGhiChu(), null, bhhd.getTrangThai(), bhhd.getIdKhachHang(), null))){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }
    
    

    @Override
    public int getSoLuongTon(String idSanPham) {
        return banHangRepo.getSoLuongTon(idSanPham);
    }

    @Override
    public String getIDSanPham(String tenSanPham, int dungTich) {
        return banHangRepo.getIDSanPham(tenSanPham, dungTich);
    }

    @Override
    public String updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham) {
        if (banHangRepo.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham)) {
            return "Thành công";
        }
        return"Thất bại";
    }

    @Override
    public Date getNgayThem(String idHoaDon) {
        return banHangRepo.getNgayThem(idHoaDon);
    }

    @Override
    public BigDecimal getTongTien(String idHoaDon) {
        return banHangRepo.getTongTien(idHoaDon);
    }

    @Override
    public int getSoLuongFromHoaDonChiTiet(String idHoaDon, String idSanPham) {
        return banHangRepo.getSoLuongFromHoaDonChiTiet(idHoaDon, idSanPham);
    }

    @Override
    public String updateKhuyenMai(BanHang_HoaDonView bhhd) {
        if(banHangRepo.updateKhuyenMai(new HoaDon(bhhd.getIdHoaDon(), null, null, BigDecimal.ONE, null, null, 0, null, bhhd.getIdkhuyenMai()))){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }
    
    @Override
    public List<BanHang_HoaDonView> getHoaDonDaThanhToan(String idTaiKhoan) {
        List<BanHang_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = banHangRepo.getHoaDonDaThanhToan(idTaiKhoan);
        for (int i = 0; i < lstHoaDon.size(); i++) {
            BanHang_HoaDonView hoaDonView = new BanHang_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setNguoiThem(banHangRepo.getEmail(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            lstHoaDonView.add(hoaDonView);
        }

        return lstHoaDonView;
    }

    @Override
    public String getKHByPhone(String phoneNumber) {
        return banHangRepo.getKHByPhone(phoneNumber);
    }

    @Override
    public String getTenByIDNV(String idNV) {
        return banHangRepo.getTenByIDNV(idNV);
    }

    @Override
    public String getIdKhacHang(String sdt) {
        return banHangRepo.getIdKhachHang(sdt);
    }

    @Override
    public ArrayList<KhuyenMai> getTTKM(String idHoaDon) {
        return banHangRepo.getThongTinKM(banHangRepo.getKMBIDHD(idHoaDon));
    }

    

    

}
