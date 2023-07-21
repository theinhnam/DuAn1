/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.NhapSanPham;
import DomainModels.SanPham;
import Ultilities.DBConnection;
import ViewModels.NhapSanPhamView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class NhatKyHoatDongRepo {

    public String getEmailById(String idTaiKhoan) {
        String sql = "SELECT email from taiKhoan WHERE idTaiKhoan = ?";
        String email = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

    public String getIdTaiKhoanByEmail(String email) {
        String sql = "SELECT IdTaiKhoan from taiKhoan WHERE email = ?";
        String IdTaiKhoan = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IdTaiKhoan = rs.getString("IdTaiKhoan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IdTaiKhoan;
    }

    public List<String> getEmail() {
        List<String> lstEmail = new ArrayList<>();
        String sql = "SELECT email from taiKhoan";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstEmail.add(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstEmail;
    }

    public String getTenSp(String idSp) {
        String sql = "SELECT TenSanPham from sanpham WHERE idSanPham = ?";
        String tenSp = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenSp = rs.getString("tensanpham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenSp;
    }

    public List<NhapSanPham> getNhap() {
        List<NhapSanPham> lstNhap = new ArrayList<>();

        String sql = "SELECT * FROM NhapSanPham where trangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhapSanPham nhapSanPham = new NhapSanPham();
                nhapSanPham.setIdTaiKhoan(rs.getString("idTaiKhoan"));
                nhapSanPham.setIdSanPham(rs.getString("IdSanPham"));
                nhapSanPham.setSoLuong(rs.getInt("SoLuong"));
                nhapSanPham.setDonGia(rs.getBigDecimal("DonGia"));
                nhapSanPham.setNgayThem(rs.getString("ngayThem"));
                lstNhap.add(nhapSanPham);
            }

            return lstNhap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhapSanPham> getXuat() {
        List<NhapSanPham> lstXuat = new ArrayList<>();

        String sql = "SELECT * FROM NhapSanPham where trangThai = 0";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhapSanPham nhapSanPham = new NhapSanPham();
                nhapSanPham.setIdTaiKhoan(rs.getString("idTaiKhoan"));
                nhapSanPham.setIdSanPham(rs.getString("IdSanPham"));
                nhapSanPham.setSoLuong(rs.getInt("SoLuong"));
                nhapSanPham.setDonGia(rs.getBigDecimal("DonGia"));
                nhapSanPham.setNgayThem(rs.getString("ngayThem"));
                lstXuat.add(nhapSanPham);
            }

            return lstXuat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> getHoaDon() {
        List<HoaDon> lstHoaDon = new ArrayList<>();

        String sql = "select * from HoaDon ORDER BY STT ASC";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setGhiChu(rs.getString("ghiChu"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setStt(rs.getInt("stt"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        String sql = "SELECT * FROM hoaDon";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idTaiKhoan");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idTaiKhoan);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = "SELECT * FROM hoaDon where "
                    + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(2).isEmpty() == false && lstInputId.get(3).isEmpty() == false) {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'";
            } else {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
            }

        } else if (lstInputIdNotEmpty.size() == 3) {
            if (lstInputId.get(2).isEmpty() == false && lstInputId.get(3).isEmpty() == false) {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
            } else {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'";
            }

        } else if (lstInputIdNotEmpty.size() == 4) {
            if (lstInputId.get(2).isEmpty() == false && lstInputId.get(3).isEmpty() == false) {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
            } else {
                sql = "SELECT * FROM hoaDon where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "=" + "'" + lstInputIdNotEmpty.get(3) + "'";
            }

        }
        System.out.println(sql);
        List<HoaDon> lstHoaDon = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {

            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setGhiChu(rs.getString("ghiChu"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setStt(rs.getInt("stt"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHoaDon;
    }

    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonChiTiet\n"
                + "where IDHoaDon=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setNgaySua(rs.getString("NgaySua"));
                HoaDonChiTiet.setNgayThem(rs.getString("NgayThem"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
                HoaDonChiTiet.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
