/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Repositories.BanHangRepo;
import Ultilities.DBConnection;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
import java.sql.Connection;
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
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public List<BanHang_SanPhamView> getSanPham() {
        List<BanHang_SanPhamView> lstSpView = new ArrayList<>();
        List<SanPham> lstSp = banHangRepo.getSanPham();
        for (int i = 0; i < lstSp.size(); i++) {
            BanHang_SanPhamView sanPhamView = new BanHang_SanPhamView();
            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
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
    public ArrayList<BanHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {

        ArrayList<BanHang_SanPhamView> lstSpView = new ArrayList<>();
        ArrayList<SanPham> lstSp = banHangRepo.findSanPham(danhMuc, nhanHieu, nhomHuong, xuatXu);
        for (int i = 0; i < lstSp.size(); i++) {
            BanHang_SanPhamView sanPhamView = new BanHang_SanPhamView();
            sanPhamView.setGia(lstSp.get(i).getGiaGiam());
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
    public String taoHoaDonChiTiet(BanHang_HoaDonChiTietView banHang_HoaDonChiTietView, int stt) {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setIdSanPham(banHangRepo.getIDSanPham(banHang_HoaDonChiTietView.getTenSp()));
        hoaDonChiTiet.setDonGia(banHang_HoaDonChiTietView.getDonGia());
        hoaDonChiTiet.setSoLuong(banHang_HoaDonChiTietView.getSoLuong());
        if (banHangRepo.taoHoaDonChiTiet(hoaDonChiTiet,stt)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public List<BanHang_HoaDonChiTietView> getHoaDonChiTiet() {
        List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView = new ArrayList<>();
        List<HoaDonChiTiet> lstHoaDonChiTiet = banHangRepo.getHoaDonChiTiet();
        System.out.println("Day la hoaDonDomain " + lstHoaDonChiTiet.get(0).getIdHoaDon());
        for (int i = 0; i < lstHoaDonChiTiet.size(); i++) {
            BanHang_HoaDonChiTietView hoaDonChiTietView = new BanHang_HoaDonChiTietView();
            hoaDonChiTietView.setTenSp(banHangRepo.getTenSanPham(lstHoaDonChiTiet.get(i).getIdSanPham()));
            hoaDonChiTietView.setDonGia(lstHoaDonChiTiet.get(i).getDonGia());
            hoaDonChiTietView.setSoLuong(lstHoaDonChiTiet.get(i).getSoLuong());
            
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public String deleteHoaDonChiTiet(String tenSanPham, String idHoaDon) {
        if (banHangRepo.deleteHoaDonChiTiet(banHangRepo.getIDSanPham(tenSanPham),idHoaDon)) {
            return "Thanh cong";
        }
        return "That bai";
        
    }

    @Override
    public List<BanHang_HoaDonView> getHoaDon() {
        List<BanHang_HoaDonView> lstHoaDonView = new ArrayList<>();
        List<HoaDon> lstHoaDon = banHangRepo.getHoaDon();
        for (int i = 0; i < lstHoaDon.size(); i++) {
            BanHang_HoaDonView hoaDonView = new BanHang_HoaDonView();
            hoaDonView.setNgayThem(lstHoaDon.get(i).getNgayThem());
            hoaDonView.setNguoiThem(banHangRepo.getEmail(lstHoaDon.get(i).getIdTaiKhoan()));
            hoaDonView.setStt(lstHoaDon.get(i).getStt());
            hoaDonView.setTenHoaDon(lstHoaDon.get(i).getTenHoaDon());
            hoaDonView.setTongTien(lstHoaDon.get(i).getTongTien());
            hoaDonView.setTrangThai(lstHoaDon.get(i).getTinhTrang());
            hoaDonView.setIdHoaDon(lstHoaDon.get(i).getIdHoaDon());
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
            lstHoaDonChiTietView.add(hoaDonChiTietView);
        }

        return lstHoaDonChiTietView;
    }

    @Override
    public String update(BanHang_HoaDonView bhhd) {
        if(banHangRepo.updateHoaDon(new HoaDon(null, null, null, bhhd.getTongTien(), bhhd.getGhiChu(), null, bhhd.getTrangThai(), bhhd.getStt()))){
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
    public String getIDSanPham(String tenSanPham) {
        return banHangRepo.getIdSanPham(tenSanPham);
    }

    @Override
    public String updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham) {
        if (banHangRepo.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham)) {
            return "Thanh Cong";
        }
        return"That Bai";
    }

}
