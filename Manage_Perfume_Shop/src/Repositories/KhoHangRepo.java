/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhapSanPham;
import DomainModels.SanPham;
import Ultilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class KhoHangRepo {

    public List<SanPham> getSanPham() {
        List<SanPham> lstSanPham = new ArrayList<>();

        String sql = "SELECT * FROM SANPHAM";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
//                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            return lstSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean nhap(NhapSanPham nhapSanPham) {
        System.out.println("so luong = "+nhapSanPham.getSoLuong());
        System.out.println("idSp = "+nhapSanPham.getIdSanPham());
        String sql = "insert into NhapSanPham (IDNhapSanPham,IDSanPham,DonGia,SoLuong,NgayThem,TrangThai,idTaiKhoan)\n"
                + "values (newid(),?,?,?,GETDATE(),?,?)";
        String sql2 = "update SanPham \n"
                + "set SoLuongTon = SoLuongTon + ? where IDSanPham = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, nhapSanPham.getIdSanPham());
            ps.setObject(2, nhapSanPham.getDonGia());
            ps.setObject(3, nhapSanPham.getSoLuong());
            ps.setObject(4, nhapSanPham.getTrangThai());
            ps.setObject(5, nhapSanPham.getIdTaiKhoan());
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setObject(1, nhapSanPham.getSoLuong());
            ps.setObject(2, nhapSanPham.getIdSanPham());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xuat(NhapSanPham nhapSanPham) {
        String sql = "insert into NhapSanPham (IDNhapSanPham,IDSanPham,DonGia,SoLuong,NgayThem,TrangThai,idTaiKhoan)\n"
                + "values (newid(),?,?,?,GETDATE(),?,?)";
        String sql2 = "update SanPham \n"
                + "set SoLuongTon = SoLuongTon - ? where IDSanPham = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, nhapSanPham.getIdSanPham());
            ps.setObject(2, nhapSanPham.getDonGia());
            ps.setObject(3, nhapSanPham.getSoLuong());
            ps.setObject(4, nhapSanPham.getTrangThai());
            ps.setObject(5, nhapSanPham.getIdTaiKhoan());
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setObject(1, nhapSanPham.getSoLuong());
            ps.setObject(2, nhapSanPham.getIdSanPham());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> findSanPham(String tenSp) {
        List<SanPham> lstSanPham = new ArrayList<>();
        if (tenSp.isEmpty()) {
            System.out.println("rong");
        } else {
            System.out.println(tenSp);
        }

        String sql = "SELECT * FROM SANPHAM where tensanpham =?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, tenSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
//                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            return lstSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getIDSanPham(String tenSanPham) {
        String sql = "SELECT IDSanPham from sanpham WHERE TenSanPham = ?";
        String idSanPham = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idSanPham = rs.getString("IDSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSanPham;
    }

    public String getIDTaiKhoan(String email) {
        String sql = "SELECT IDTaiKhoan from TaiKhoan WHERE email = ?";
        String idTaiKhoan = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idTaiKhoan = rs.getString("IDTaiKhoan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTaiKhoan;
    }

    public String getTenDanhMuc(String idDanhMuc) {
        String sql = "SELECT tenDanhMuc from DANHMUC WHERE idDanhMuc = ?";
        String tenDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDanhMuc = rs.getString("tenDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDanhMuc;
    }

    public String getTenNhomHuong(String idNhomHuong) {
        String sql = "SELECT tenNhomHuong from NhomHuong WHERE idNhomHuong = ?";
        String tenNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhomHuong = rs.getString("tenNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhomHuong;
    }

    public String getTenNhanHieu(String idNhanHieu) {
        String sql = "SELECT tenNhanHieu from NhanHieu WHERE idNhanHieu = ?";
        String tenNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhanHieu = rs.getString("tenNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhanHieu;
    }

    public String getTenXuatXu(String idXuatXu) {
        String sql = "SELECT tenXuatXu from XuatXu WHERE idXuatXu = ?";
        String tenXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenXuatXu = rs.getString("tenXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenXuatXu;
    }
}
