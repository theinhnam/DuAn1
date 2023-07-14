/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Ultilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class SanPhamRepo {

    public List<String> getDanhMuc() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from danhmuc where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Tendanhmuc"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhomHuong() {
        List<String> lstHuong = new ArrayList<>();
        String sql = "select * from nhomHuong where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstHuong.add(rs.getString("TennhomHuong"));
            }
            return lstHuong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhanHieu() {
        List<String> lstNhanHieu = new ArrayList<>();
        String sql = "select * from nhanhieu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstNhanHieu.add(rs.getString("Tennhanhieu"));
            }
            return lstNhanHieu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getXuatXu() {
        List<String> lstXuatXu = new ArrayList<>();
        String sql = "select * from XuatXu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstXuatXu.add(rs.getString("TenXuatXu"));
            }
            return lstXuatXu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSanPham(SanPham sanPham, String danhMuc, String nhomHuong, String nhanHieu, String xuatXu) {
        String sql = "insert into SanPham values \n"
                + "(?,?,\n"
                + "(SELECT IDDanhMuc FROM DanhMuc WHERE TenDanhMuc=?),\n"
                + "(SELECT IDNhomHuong FROM NhomHuong WHERE TenNhomHuong=?),?,\n"
                + "(SELECT IDNhanHieu FROM NhanHieu WHERE TenNhanHieu=?),\n"
                + "(SELECT IDXuatXu FROM XuatXu WHERE TenXuatXu=?),\n"
                + "?,?,? - (? * ? / 100),?,default,NULL,?,default,?,?)";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sanPham.getIdSanPham());
            ps.setObject(2, sanPham.getTenSanPham());
            ps.setObject(3, danhMuc);
            ps.setObject(4, nhomHuong);
            ps.setObject(5, sanPham.getKichThuoc());
            ps.setObject(6, nhanHieu);
            ps.setObject(7, xuatXu);
            ps.setObject(8, sanPham.getMoTa());
            ps.setObject(9, sanPham.getGiaGoc());
            ps.setObject(10, sanPham.getGiaGoc());
            ps.setObject(11, sanPham.getGiaGoc());
            ps.setObject(12, sanPham.getChietKhau());
            ps.setObject(13, sanPham.getSoLuongTon());
            ps.setObject(14, sanPham.getTinhTrang());
            ps.setObject(15, sanPham.getChietKhau());
            ps.setObject(16, sanPham.getImageUrl());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> getSanPham() {
        List<SanPham> lstSanPham = new ArrayList<>();

        String sql = "select IDSanPham, TenSanPham, TenDanhMuc, TenNhomHuong, KichThuoc, TenNhanHieu, TenXuatXu, MoTa,GiaGoc,GiaGiam, SoLuongTon,\n"
                + "sanpham.NgayThem,sanpham.NgaySua,sanpham.TrangThai, TenKhuyenMai, ChietKhau, ImageUrl\n"
                + "from SanPham\n"
                + "join DanhMuc on SanPham.IDDanhMuc = DanhMuc.IDDanhMuc\n"
                + "join NhomHuong on SanPham.IDNhomHuong = NhomHuong.IDNhomHuong\n"
                + "join NhanHieu on SanPham.IDNhanHieu = NhanHieu.IDNhanHieu\n"
                + "join XuatXu on SanPham.IDXuatXu = XuatXu.IDXuatXu\n"
                + "join KhuyenMai on SanPham.IDKhuyenMai = KhuyenMai.IDKhuyenMai";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("tenDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("tenNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("tenNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("tenXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
                sanPham.setIdKhuyenMai(rs.getString("tenKhuyenMai"));
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

    public boolean updateSanPham(SanPham sanPham, String danhMuc, String nhomHuong, String nhanHieu, String xuatXu) {
        String sql = "{CALL updateSanPham(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setObject(1, sanPham.getIdSanPham());
            cs.setObject(2, sanPham.getTenSanPham());
            cs.setObject(3, danhMuc);
            cs.setObject(4, nhomHuong);
            cs.setObject(5, sanPham.getKichThuoc());
            cs.setObject(6, nhanHieu);
            cs.setObject(7, xuatXu);
            cs.setObject(8, sanPham.getMoTa());
            cs.setObject(9, sanPham.getGiaGoc());
            cs.setObject(10, sanPham.getSoLuongTon());
            cs.setObject(11, sanPham.getTinhTrang());
            cs.setObject(12, sanPham.getChietKhau());
            cs.setObject(13, sanPham.getImageUrl());

            int result = cs.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSanPham(String idSanPham) {
        String sql = "update SanPham \n"
                + "set TrangThai=0\n"
                + "where IDSanPham =?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setObject(1, idSanPham);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu){
        String sql = "SELECT * FROM SANPHAM WHERE ";
        ArrayList<SanPham> lstSanPham = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();){
            if (danhMuc.length() != 0) {
                sql = sql + "IDDanhMuc = " + "N'" + danhMuc + "'";
            }
            if (nhanHieu.length() != 0) {
                sql = sql + "and IDNhanHieu = " + "N'" + nhanHieu + "'";
            }
            if (nhomHuong.length() != 0) {
                sql = sql + "and IDNhomHuong = " + "N'" + nhomHuong + "'";
            }
            if (xuatXu.length() != 0) {
                sql = sql + "and IDXuatXu = " + "N'" + xuatXu + "'";
            }
            System.out.println(sql);
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
                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;
        
    }
    
    public String getIDDanhMuc(String tenDanhMuc){
        String sql = "SELECT IDDanhMuc from DANHMUC WHERE TenDanhMuc = ?";
        String idDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idDanhMuc = rs.getString("IDDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDanhMuc;
    }
    
    public String getIDNhomHuong(String tenNhomHuong){
        String sql = "SELECT IDNhomHuong from NhomHuong WHERE TenNhomHuong = ?";
        String idNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idNhomHuong = rs.getString("IDNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhomHuong;
    }
    
    public String getIDNhanHieu(String tenNhanHieu){
        String sql = "SELECT IDNhanHieu from NhanHieu WHERE TenNhanHieu = ?";
        String idNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idNhanHieu = rs.getString("IDNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhanHieu;
    }
    
    public String getIDXuatXu(String tenXuatXu){
        String sql = "SELECT IDXuatXu from XuatXu WHERE TenXuatXu = ?";
        String idXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idXuatXu = rs.getString("IDXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idXuatXu;
    }
}
