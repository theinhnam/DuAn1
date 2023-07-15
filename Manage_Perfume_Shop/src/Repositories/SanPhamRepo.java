/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Ultilities.DBConnection;
import ViewModels.SanPhamView;
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


    public boolean addSanPham(SanPhamView sanPhamView) {
        String sql = "insert into SanPham (IDSanPham,TenSanPham,IDDanhMuc,IDNhomHuong,KichThuoc,IDNhanHieu,IDXuatXu,MoTa,GiaGoc,GiaGiam,SoLuongTon,\n"
                + "NgayThem,NgaySua,TrangThai,IDKhuyenMai,ChietKhau,imageurl)  values \n"
                + "(newid(),\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "? - (? * ? / 100),\n"
                + "?,\n"
                + "getdate(),\n"
                + "NULL,\n"
                + "?,\n"
                + "NULL,\n"
                + "?,\n"
                + "?)";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sanPhamView.getTenSanPham());
            ps.setObject(2, getIDDanhMuc(sanPhamView.getTenDanhMuc()));
            ps.setObject(3, getIDNhomHuong(sanPhamView.getTenNhomHuong()));
            ps.setObject(4, sanPhamView.getKichThuoc());
            ps.setObject(5, getIDNhanHieu(sanPhamView.getTenNhanHieu()));
            ps.setObject(6, getIDXuatXu(sanPhamView.getTenXuatxu()));
            ps.setObject(7, sanPhamView.getMoTa());
            ps.setObject(8, sanPhamView.getGiaGoc());
            ps.setObject(9, sanPhamView.getGiaGoc());
            ps.setObject(10, sanPhamView.getGiaGoc());
            ps.setObject(11, sanPhamView.getChietKhau());
            ps.setObject(12, sanPhamView.getSoLuongTon());
            ps.setObject(13, sanPhamView.getTinhTrang());
            ps.setObject(14, sanPhamView.getChietKhau());
            ps.setObject(15, sanPhamView.getImageUrl());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addSanPhamCoKm(SanPhamView sanPhamView) {
        if (sanPhamView.getTenSanPham().isEmpty()) {
            System.out.println("TenSp RONG");
        }
//        System.out.println(sanPhamView.getTenKhuyenMai());
//            System.out.println(getIDKhuyenMai(sanPhamView.getTenKhuyenMai()));
//            System.out.println();
        String sql = "insert into SanPham (IDSanPham,TenSanPham,IDDanhMuc,IDNhomHuong,KichThuoc,IDNhanHieu,IDXuatXu,MoTa,GiaGoc,GiaGiam,SoLuongTon,\n"
                + "NgayThem,NgaySua,TrangThai,IDKhuyenMai,ChietKhau,imageurl)  values \n"
                + "(newid(),\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "? - (? * ? / 100),\n"
                + "?,\n"
                + "getdate(),\n"
                + "NULL,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?)";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sanPhamView.getTenSanPham());
            ps.setObject(2, getIDDanhMuc(sanPhamView.getTenDanhMuc()));
            ps.setObject(3, getIDNhomHuong(sanPhamView.getTenNhomHuong()));
            ps.setObject(4, sanPhamView.getKichThuoc());
            ps.setObject(5, getIDNhanHieu(sanPhamView.getTenNhanHieu()));
            ps.setObject(6, getIDXuatXu(sanPhamView.getTenXuatxu()));
            ps.setObject(7, sanPhamView.getMoTa());
            ps.setObject(8, sanPhamView.getGiaGoc());
            ps.setObject(9, sanPhamView.getGiaGoc());
            ps.setObject(10, sanPhamView.getGiaGoc());
            ps.setObject(11, sanPhamView.getChietKhau());
            ps.setObject(12, sanPhamView.getSoLuongTon());
            ps.setObject(13, sanPhamView.getTinhTrang());
            ps.setObject(14, getIDKhuyenMai(sanPhamView.getTenKhuyenMai()));
            ps.setObject(15, sanPhamView.getChietKhau());
            ps.setObject(16, sanPhamView.getImageUrl());
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public List<SanPham> getSanPham() {
//        List<SanPham> lstSanPham = new ArrayList<>();
//
//        String sql = "select IDSanPham, TenSanPham, TenDanhMuc, TenNhomHuong, KichThuoc, TenNhanHieu, TenXuatXu, MoTa,GiaGoc,GiaGiam, SoLuongTon,\n"
//                + "sanpham.NgayThem,sanpham.NgaySua,sanpham.TrangThai, TenKhuyenMai, ChietKhau, ImageUrl\n"
//                + "from SanPham\n"
//                + "join DanhMuc on SanPham.IDDanhMuc = DanhMuc.IDDanhMuc\n"
//                + "join NhomHuong on SanPham.IDNhomHuong = NhomHuong.IDNhomHuong\n"
//                + "join NhanHieu on SanPham.IDNhanHieu = NhanHieu.IDNhanHieu\n"
//                + "join XuatXu on SanPham.IDXuatXu = XuatXu.IDXuatXu\n"
//                + "join KhuyenMai on SanPham.IDKhuyenMai = KhuyenMai.IDKhuyenMai";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setIdSanPham(rs.getString("idSanPham"));
//                sanPham.setTenSanPham(rs.getString("tenSanPham"));
//                sanPham.setIdDanhMuc(rs.getString("tenDanhMuc"));
//                sanPham.setIdNhomHuong(rs.getString("tenNhomHuong"));
//                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
//                sanPham.setIdNhanHieu(rs.getString("tenNhanHieu"));
//                sanPham.setIdXuatxu(rs.getString("tenXuatXu"));
//                sanPham.setMoTa(rs.getString("moTa"));
//                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
//                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
//                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
//                sanPham.setNgayThem(rs.getString("ngayThem"));
//                sanPham.setNgaySua(rs.getString("ngaySua"));
//                sanPham.setTinhTrang(rs.getInt("trangThai"));
//                sanPham.setIdKhuyenMai(rs.getString("tenKhuyenMai"));
//                sanPham.setChietKhau(rs.getInt("chietkhau"));
//                sanPham.setImageUrl(rs.getString("imageUrl"));
//                lstSanPham.add(sanPham);
//            }
//            return lstSanPham;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
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
                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
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

    public boolean updateSanPham(SanPhamView sanPhamView) {
        String sql = "{CALL updateSanPham(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println(sanPhamView.getIdSanPham());
            CallableStatement cs = conn.prepareCall(sql);
            cs.setObject(1, sanPhamView.getIdSanPham());
            cs.setObject(2, sanPhamView.getTenSanPham());
            cs.setObject(3, sanPhamView.getTenDanhMuc());
            cs.setObject(4, sanPhamView.getTenNhomHuong());
            cs.setObject(5, sanPhamView.getKichThuoc());
            cs.setObject(6, sanPhamView.getTenNhanHieu());
            cs.setObject(7, sanPhamView.getTenXuatxu());
            cs.setObject(8, sanPhamView.getMoTa());
            cs.setObject(9, sanPhamView.getGiaGoc());
            cs.setObject(10, sanPhamView.getSoLuongTon());
            cs.setObject(11, sanPhamView.getTinhTrang());
            cs.setObject(12, sanPhamView.getChietKhau());
            cs.setObject(13, sanPhamView.getImageUrl());

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
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        String sql = "SELECT * FROM SANPHAM WHERE ";
        ArrayList<SanPham> lstSanPham = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {
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

    public String getIDDanhMuc(String tenDanhMuc) {
        String sql = "SELECT IDDanhMuc from DANHMUC WHERE TenDanhMuc = ?";
        String idDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    public String getIDNhomHuong(String tenNhomHuong) {
        String sql = "SELECT IDNhomHuong from NhomHuong WHERE TenNhomHuong = ?";
        String idNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    public String getIDNhanHieu(String tenNhanHieu) {
        String sql = "SELECT IDNhanHieu from NhanHieu WHERE TenNhanHieu = ?";
        String idNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    public String getIDXuatXu(String tenXuatXu) {
        String sql = "SELECT IDXuatXu from XuatXu WHERE TenXuatXu = ?";
        String idXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
    
    public String getIDKhuyenMai(String tenKhuyenMai) {
        String sql = "SELECT IDKhuyenMai from KhuyenMai WHERE TenKhuyenMai = ?";
        String idKhuyenMai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenKhuyenMai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKhuyenMai = rs.getString("IDKhuyenMai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhuyenMai;
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
    
    public String getTenKhuyenMai(String idKhuyenMai) {
        String sql = "SELECT tenKhuyenMai from KhuyenMai WHERE idKhuyenMai = ?";
        String tenKhuyenMai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhuyenMai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenKhuyenMai = rs.getString("tenKhuyenMai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenKhuyenMai;
    }
}
