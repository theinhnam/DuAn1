/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonNhap;
import DomainModels.HoaDonNhapChiTiet;
import DomainModels.SanPham;
import Ultilities.DBConnection;
import ViewModels.HoaDonNhapHangChiTietView;
import ViewModels.HoaDonNhapHangViews;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author foxin
 */
public class NhapHangRepository {

    public ArrayList<HoaDonNhap> findAll() {
        String sql = "SELECT * FROM HoaDonNhap WHERE TrangThai = 2";
        ArrayList<HoaDonNhap> listHoaDonNhap = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhap hoaDonNhap = new HoaDonNhap();
                hoaDonNhap.setIdHoaDon(rs.getString("IDHoaDon"));
                hoaDonNhap.setTenHoaDon(rs.getString("TenHoaDon"));
                hoaDonNhap.setIdNhanVienKho(rs.getString("IDNhanVienKho"));
                hoaDonNhap.setNhaCungUng(rs.getString("NhaCungUng"));
                hoaDonNhap.setTongTien(rs.getBigDecimal("TongTien"));
                hoaDonNhap.setNgayThem(rs.getString("NgayThem"));
                listHoaDonNhap.add(hoaDonNhap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonNhap;
    }

    public String getTenNhanVienKho(String idNhanVienKho) {
        String sql = "SELECT HoTen FROM TaiKhoan WHERE IDTaiKhoan = ?";
        String hoTen = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanVienKho);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hoTen = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoTen;
    }

    public ArrayList<HoaDonNhapChiTiet> getHDCT(String idHoaDon) {
        String sql = "SELECT * FROM HoaDonNhapChiTiet WHERE IDHoaDon = ?";
        ArrayList<HoaDonNhapChiTiet> listHoaDonNhap = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhapChiTiet hoaDonNhapHangChiTietView = new HoaDonNhapChiTiet();
                hoaDonNhapHangChiTietView.setIdSanPham(rs.getString("IDSanPham"));
                hoaDonNhapHangChiTietView.setSoLuong(rs.getInt("SoLuong"));
                hoaDonNhapHangChiTietView.setSoLuongThucTe(rs.getInt("SoLuongThucTe"));
                hoaDonNhapHangChiTietView.setDonGia(rs.getBigDecimal("DonGia"));
                listHoaDonNhap.add(hoaDonNhapHangChiTietView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonNhap;
    }

    public SanPham getTenSanPham(String idSanPham) {
        String sql = "SELECT TenSanPham, KichThuoc FROM SanPham WHERE IDSanPham = ?";
        SanPham sanPham = new SanPham();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public String getID(String tenSanPham, int kichThuoc) {
        String sql = "SELECT IDSanPham FROM SanPham WHERE TenSanPham = ? and KichThuoc = ?";
        String idSanPham = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSanPham);
            ps.setObject(2, kichThuoc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idSanPham = rs.getString("IDSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSanPham;
    }

    public boolean update(String idSanPham, String idHoaDon, int soLuongThucTe) {
        String sql = "UPDATE HoaDonNhapChiTiet SET SoLuongThucTe = ? WHERE IDHoaDon = ? and IDSanPham = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, soLuongThucTe);
            ps.setObject(2, idHoaDon);
            ps.setObject(3, idSanPham);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateHoaDon(String ghiChu, String idHoaDon, String idNhanVien) {
        String sql = "UPDATE HoaDonNhap SET GhiChu = ?, IDNhanVienCuaHang=?, TrangThai=3 WHERE IDHoaDon = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, ghiChu);
            ps.setObject(2, idNhanVien);
            ps.setObject(3, idHoaDon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateHoaDonFailed(String ghiChu, String idHoaDon, String idNhanVien) {
        String sql = "UPDATE HoaDonNhap SET GhiChu = ?, IDNhanVienCuaHang=?, TrangThai=4 WHERE IDHoaDon = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, ghiChu);
            ps.setObject(2, idNhanVien);
            ps.setObject(3, idHoaDon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSoLuongTon(List<HoaDonNhapChiTiet> lstHoaDonNhapChiTiet) {
        String sql = "update SanPham\n"
                + "set SoLuongTon = SoLuongTon + ?\n"
                + "where IDSanPham = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps;
            for (int i = 0; i < lstHoaDonNhapChiTiet.size(); i++) {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,lstHoaDonNhapChiTiet.get(i).getSoLuongThucTe());
                ps.setObject(2,lstHoaDonNhapChiTiet.get(i).getIdSanPham());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getSoLuongTon() {
        String sql = "SELECT * FROM SanPham WHERE TrangThai = 1 order by SoLuongTon asc";
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getString("IDSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setSoLuongTon(rs.getInt("SoLuongTon"));
                sp.setKichThuoc(rs.getInt("KichThuoc"));
                listSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
}
